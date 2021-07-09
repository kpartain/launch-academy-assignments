import java.util.ArrayList;

public class LibraryCardholder {
  //account name/ID
  //array of checked out books
  ArrayList<String> checkedOutBooks = new ArrayList<String>();

  //method to check out books
  public void checkOutBook(String title) {
    checkedOutBooks.remove(title);
  }

  //method to see all checked out books
  public void currentListOfCheckedOutBooks(){
    int lengthOfArray = checkedOutBooks.size();
    for(int i = 0; lengthOfArray > i; i++) {
      System.out.println(checkedOutBooks.get(i));
    }
  }
}
