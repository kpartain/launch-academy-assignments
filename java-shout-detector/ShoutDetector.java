import java.io.IOException;
import java.util.Scanner;

public class ShoutDetector {

  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Say something");
    String reply = scanner.nextLine();
    String testCaps = reply.replaceAll("\\p{Punct}", "");
    if (isStringUpperCase(testCaps) == true) {
      System.out.println("PLEASE STOP YELLING AT ME.");
    } else if (reply.contains("?!?!") == true) {
      System.out.println("I don't response to inflammatory questions?!?!");
    } else if (reply.contains("!!") == true) {
      System.out.println("Please stop yelling at me!!");
    } else {
      System.out.println("You said" + " " + reply);
      System.out.println("Ok, thanks.");
    }
  }

  private static boolean isStringUpperCase(String str) {
    char[] charArray = str.toCharArray();
    for (int i = 0; i < charArray.length; i++) {
      if (!Character.isUpperCase(charArray[i])) {
        return false;
      }
    }
    return true;
  }

}
