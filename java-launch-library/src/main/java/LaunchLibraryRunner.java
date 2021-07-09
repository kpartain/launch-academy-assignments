import java.util.Scanner;

public class LaunchLibraryRunner {
  public static void main(String[] args) {
    //ask for account name or number
    System.out.println("Can I get your name to look up your library card?");
    Scanner initialScanner = new Scanner(System.in);
    String libraryCard = initialScanner.next();
    LibraryMenu menu = new LibraryMenu(libraryCard);
    menu.promptUntilQuit();
  }
}