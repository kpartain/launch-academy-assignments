import java.util.Scanner;

public class LoopingDrills {

  public static void main(String[] args) {
    String primeAnswer = isPrime();
    System.out.println(primeAnswer);

    String evenOddAnswer = isOddOrEven();
    System.out.println(evenOddAnswer);

    multiplicationTable();

    System.out.println(sumNumbers());

    countDown();

  }

  //COUNT DOWN
  //count down from 1000 to 711 each on a line. IF % 15 = 0, skip.
  public static void countDown() {
    for (int i = 1000; i >= 711; i--) {
      if (i % 15 != 0) {
        System.out.println(i);
      }
    }
  }

  //SUM NUMBERS
  //ask user for two numbers, validate that the 2nd is larger than 1st. if 2nd smaller, ask again.
  //if invalid number, exit program.
  //calculate sum of numbers that are between the two provided numbers
  //ie 2 & 6 ---- 3 + 4 + 5 = 12
  public static int sumNumbers() {
    Scanner scanner = new Scanner(System.in);
    int numOne;
    int numTwo;
    int answer = 0;
    System.out.println("Pick your first number.");
    String resultOne = scanner.next();
    numOne = Integer.parseInt(resultOne);
    do {
      System.out.println("Pick your second number");
      String resultTwo = scanner.next();
      numTwo = Integer.parseInt(resultTwo);
    } while (numOne > numTwo || numOne == numTwo);
    if (numOne < numTwo) {
      for (int i = numOne + 1; i < numTwo; i++) {
        answer += i;
      }
    }
    return answer;
  }

  //MULTIPLCATION TABLE
  //ask user for a number
  //print that number times every number from 1-12 on its own line
  //ie input 4 would have lines: 4 8 12 16 20 24 28 32 36 40 44 48
  public static void multiplicationTable() {
    Scanner scanner = new Scanner(System.in);
    int num;
    String answer = "null";
    System.out.println("Pick a number and I will multiply it by every number between 1 and 12");
    String result = scanner.next();
    num = Integer.parseInt(result);
    int lineValue;
    for (int i = 1; i <= 12; i++) {
      lineValue = num * i;
      System.out.println(i + " multiplied by " + num + " equals " + lineValue);
    }

  }

  //ODD EVEN CHECKER
  //ask for a number
  //if odd, sout "it is odd." if even, sout "it is even."
  //continue to re-prompt for a number and do this until user replies exit.
  //handle for bad input - if failed parsem allow re-entry of #
  public static String isOddOrEven() {
    Scanner scanner = new Scanner(System.in);
    int num;
    String answer = "null";
    do {
      System.out.println("Pick a number and I will determine if it is even or not.");
    } while (!scanner.hasNextInt());
    String result = scanner.next();
    num = Integer.parseInt(result);
    if (num % 2 == 0) {
      answer = "Even";
    } else if (num % 2 != 0) {
      answer = "Odd";
    }
    return answer;
  }

  //PRIME CHECKER
  //write a program to output if a number is prime or not
  public static String isPrime() {
    System.out.println("Pick a number and I will determine if it is prime or not.");
    Scanner scanner = new Scanner(System.in);
    String result = scanner.next();
    int num = Integer.parseInt(result);
    String answer = "null";
    if (num <= 1) {
      answer = "not possible to evaluate";
    }
    if (num > 1) {
      for (int i = 2; i < num; i++) {
        if (num % i == 0) {
          answer = "not prime";
        } else if (num % i != 0) {
          answer = "prime";
        }
        return answer;
      }
    }
    return answer;
  }
}