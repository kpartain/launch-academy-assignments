import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainMenu {
  public static final String ADD_CONTACT = "Add a Contact";
  public static final String FIND_CONTACT = "Look Up a Contact";
  public static final String DISTRIBUTION_LIST = "Get Distribution List for Contacts";
  public static final String QUIT = "Exit";

  public enum MenuOption {
    a(ADD_CONTACT),
    f(FIND_CONTACT),
    d(DISTRIBUTION_LIST),
    q(QUIT);

    private String optionText;

    MenuOption(String optionText) {
      this.optionText = optionText;
    }

    public String toString() {
      return this.name() + ". " + this.optionText;
    }
  }

  @Override
  public String toString() {
    String output = "";
    for(MenuOption option : MenuOption.values()) {
      output += option.toString() + "\n";
    }
    return output;
  }

  public void promptUntilQuit() {
    System.out.println(this.toString());
    MenuOption input = null;
    Scanner scanner = new Scanner(System.in);
    Map<String, String> contactList = new HashMap<String, String>()
    do{
      System.out.print("> ");
      try {
        input = MenuOption.valueOf(scanner.next());
      } catch(IllegalArgumentException error) {
        System.out.println("Please make a valid selection!");
      }

      if(input == MenuOption.a) {
        //allow the user to add a contact
        System.out.println("What name should the contact be stored under?");
        String contactName = scanner.nextLine();
        System.out.println("What email should be saved for this contact?");
        String contactEmail = scanner.nextLine();
        contactList.put(contactName, contactEmail);
      }
      else if(input == MenuOption.f) {
        System.out.println("Whose email shoud I return?");
        String searchForThis = scanner.nextLine();
        if(contactList.containsKey(searchForThis)){
          System.out.println(contactList.get(searchForThis));
        } else {
          System.out.println("Hmm that person isn't in your contacts.");
        }
      }
      else if(input == MenuOption.d) {
        //return a distribution list
        //"Jane Doe" <jane@example.com>, "Sam Smith" <sam@example.com>, "Sally Swanson" <sally@example.com>
        for(Map.Entry<String, String> bookAuthorPair : contactList.entrySet()) {
          String name = bookAuthorPair.getKey();
          String email = bookAuthorPair.getValue();
          System.out.println("'" + name + "'" + "<" + email + ">");
        }
      }

    } while(input != MenuOption.q);
    System.out.println("Thanks! Come to the library again.");
    scanner.close();
  }
}
