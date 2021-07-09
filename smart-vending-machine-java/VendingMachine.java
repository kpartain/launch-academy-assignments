import java.io.IOException;
import java.util.Scanner;

public class VendingMachine {

  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(System.in);
    System.out.println("What vending machine item would you like?");
    String itemRequested = scanner.nextLine();
    try {
      System.out.println("How many of those would you like?");
      String userInput = scanner.nextLine();
      int quantity = Integer.parseInt(userInput);
      if (quantity > 0) {
        System.out.println("Thank you, here are your " + quantity + " " + itemRequested);
        System.out.println("There you go! Come again!");
      } else {
        System.out.println(
            "You selected an item, but not a quantity. Please come back when you can decide on both");
      }
    } catch (NumberFormatException e) {
      System.out.println("This is not an accepted reply, please try again later. ");
    }
  }
}
