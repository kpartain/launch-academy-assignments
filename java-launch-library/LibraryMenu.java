import java.util.Scanner;
import java.io.IOException;

public class LibraryMenu {
  public static final String ADD_BOOK_TEXT = "Contribute a book";
  public static final String CHECKOUT_TEXT = "Check out a book";
  public static final String RETURN_BOOK_TEXT = "Return a book";
  public static final String QUIT_TEXT = "Quit";

  public enum MenuOption {
    a(ADD_BOOK_TEXT),
    c(CHECKOUT_TEXT),
    r(RETURN_BOOK_TEXT),
    q(QUIT_TEXT);

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

  public void promptUntilQuit(String libraryCard) {
    //use LibraryCardHolder class to return this user's rented books array
    System.out.println(this.toString());
    MenuOption input = null;
    Scanner scanner = new Scanner(System.in);
    do{
      System.out.print("> ");
      try {
        input = MenuOption.valueOf(scanner.next());
      } catch(IllegalArgumentException error) {
        System.out.println("Please make a valid selection!");
      }

      if(input == MenuOption.a) {
        //allow the user to add a book to the library
        System.out.println("What book would you like to donate?");
        String addedTitle = scanner.nextLine();
        //add this to the catalogue array
        //write that array to the txt file
      }
      else if(input == MenuOption.c) {
        //allow the user to check out a book from the library
        System.out.println("What book would you like to check out?");
        String rentedBook = scanner.nextLine();
        //check if the input matches a title or index in the array
        //if not, prompt again
        //else if it does match a title or index in the array
        //remove this from the array
        //overwrite the txt file with the array
        //return to the main menu
      }
      //allow the user to return a book to the library.
      else if(input == MenuOption.r) {
        //if account holder's array of checked out books is zero
        //say you don't have any books to return, return user to main menu

        //if checked out books array is > 0
        //list their current checked out book and their index
        System.out.println("What book are you returning?");
        //if user does not specify a valid index, ask again

        //if index is valid
        //remove book from checked out array
        //add book to library catalogue
        //return to main menu
      }

    } while(input != MenuOption.q);
    System.out.println("Thanks! Come to the library again.");
    scanner.close();
  }

}
