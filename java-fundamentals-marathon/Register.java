import java.io.IOException;
import java.util.Scanner;
import java.io.File;

public class Register {

  public static String RECEIPT_READ_PATH = "./outstandingReceipts.txt";


  public static void main(String[] args) throws IOException {

    double cashRegisterBalance = getMoneyValue("How much money do you have?");

    File receiptList = new File(RECEIPT_READ_PATH);
    Scanner receiptScanner = new Scanner(receiptList);
    while (receiptScanner.hasNextLine()) {
      cashRegisterBalance += receiptScanner.nextInt();
    }
    System.out.println("cashRegister balance is " + cashRegisterBalance);

    double customerOrder = getMoneyValue("How much is the customers order?");
    System.out.println("customer order is " + customerOrder);
    double customerPayment = getMoneyValue("What is the Customer's payment amount?");
    System.out.println("customerPayment is " + customerPayment);

    while (customerPayment < customerOrder) {
      customerPayment = getMoneyValue("Not enough to cover order. Please provide more money.");
    }

    //Calculate change
    double changeDue = customerPayment - customerOrder;
    while (cashRegisterBalance < changeDue || changeDue < 0) {
      //you could run the conditional again to ensure customerPayment > order
      customerPayment = getMoneyValue("Please provide cash closer to the amount due.");
      changeDue = customerPayment - customerOrder;
    }
    System.out.println("Change due: $" + changeDue);
  }

  public static double getMoneyValue(String prompt) {
    System.out.println(prompt);
    Scanner scanner = new Scanner(System.in);
    String userAmount = scanner.nextLine();

    while (userAmount.isBlank()) {
      System.out.println("You have entered a blank value. Please enter a valid value ");
      userAmount = scanner.nextLine();
    }

    double userDoubleAmount = Double.parseDouble(userAmount);
    return userDoubleAmount;
  }
}
