import java.util.Scanner;

public class WhileDemo {

  public static void main(String[] args) {
    String echo;
    while(true) {
      System.out.println("Echo Machine: Share Something. Use `exit` to quit.");
      Scanner scanner = new Scanner(System.in);
      echo = scanner.next();
      System.out.println(echo);
      if(echo.equals("exit")) {
        break;
      }
    }
  }
}