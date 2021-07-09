public class BankAccount {
  //you cannot change your account number to Bill Gates to get access to his money
  private String accountNumber;
  //you cannot change me by saying "balance = 100000000000" if you're broke
  private double balance;

  //this defines our constructor
  public BankAccount(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  //because account number is PRIVATE, we need to have a GETTER to read the value
  public String getAccountNumber() {
    return accountNumber;
  }

  //we need to create a setter to create a way to change our balance
  //user can't say myaccount.setBalance(1999999999);
  public void setBalance(double balance) {
    this.balance = balance;
  }

  //this is VOID because it doesn't return anything. It just performs the math
  //we had to use our SETTER here because balance is PRIVATE!
  //this needs an argument of deposit amount
  public double deposit(double banana) {
    setBalance(balance + banana);
    return banana;
  }

  //we now want a way to SEE our balance - so we can create a getter so we can call the value
  //recall private means you can't call account.balance - you have to use the getter
  public double getBalance() {
    return balance;
  }

  //this method needs to return a double (the number) and is expecting argument of withdrawal amt
  public double withdraw(double banana) {
    //IF the balance is higher than the withdrawal amount
    if (balance > banana) {
      //subtract the withdrawal amount from the balance using our setter
      setBalance(balance - banana);
      //IF the user tried to withdraw more than what they have as a balance
    } else {
      //set the withdrawal amount to be the current balance - we can let them withdraw all but not more
      banana = getBalance();
      //THEN, we want to set the current balance to 0 because they just withdrew it all!
      setBalance(0);
    }
    //we want to return the amount withdrawn
    //this will either be the amount initially requested
    //OR this will be the balance amount if they initially requested to withdraw more than they had
    return banana;
  }
}

