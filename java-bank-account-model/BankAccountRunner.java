public class BankAccountRunner {
  public static void main(String[] args) {
    BankAccount account = new BankAccount("2323121");
    System.out.println("The account number is " + account.getAccountNumber());

//    account.deposit(1000);
    double depositAmt = account.deposit(1000);
    System.out.println("You deposited: " + depositAmt);
    double firstW = account.withdraw(200.50);

    System.out.println("You withdrew" + firstW + " your new balance is " + account.getBalance());

    // The bank does not allow you to overdraft
    // So this withdrawal takes all available funds
    double withdrawal = account.withdraw(200);
    System.out.println("You withdrew: " + withdrawal);
    System.out.println("Your new balance is: " + account.getBalance());
  }
}