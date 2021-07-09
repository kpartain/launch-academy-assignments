import java.io.IOException;
import java.util.Scanner;

public class ReadStdIn {

  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Input a number between 0 - 9 ");
    String userInput = scanner.next();
    try {
      int number = Integer.parseInt(userInput);
      if (number < 0 || number > 9) {
        System.out.println("Input a number between 0 and 9");
      } else {
        System.out.println(number);
      }
    } catch (Exception e) {
      System.out.println("Please enter a number, not text");
    }
  }
}