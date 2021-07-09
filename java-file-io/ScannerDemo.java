import java.io.IOException;
import java.util.Scanner;
import java.io.File;

public class ScannerDemo {
  public static String BOOK_READ_PATH = "./booklist.txt";

  public static void main(String[] args) throws IOException {
    File bookList = new File(BOOK_READ_PATH);
    String allContent = new Scanner(bookList).useDelimiter("\\z").next();
    System.out.println(allContent);
  }
}