import java.util.Scanner;
import java.io.IOException;
import java.util.Random;

public class BedTime {

  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(System.in);
    Random r = new Random();
    int myValue = r.nextInt(50-5)+5;
    System.out.println("How many little ones are in the bed? Enter -1 for a random number.");
    int response = scanner.nextInt();
    if(response == -1) {
      response = myValue;
    }
    if (response < -1 || response > 30) {
      System.out.println("How many little ones are in the bed? Enter -1 for a random number.");
      response = scanner.nextInt();
    }
    for (int one = 1; response >= one; response-- ) {
      if(response == 1) {
        System.out.printf("There was %d in the bed, and the little one said,\n"
            + "\"Good night!\"\n", response);
      } else {
        System.out.printf("There were %d in the bed, and the little one said,\n"
            + "\"Roll over! Roll over!\"\n"
            + "So they all rolled over, and one fell out.\n", response);
      }
    }
  }
}