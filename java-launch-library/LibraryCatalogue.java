import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class LibraryCatalogue {
  public static final String LIBRARY_CATALOGUE = "./catalogue.txt";

  File bookCatalogue = new File(LIBRARY_CATALOGUE);
  FileWriter writeToCatalogue = new FileWriter(bookCatalogue);
  ArrayList<String> arrayOfBooks = new ArrayList<String>();

  public void readFileToArray(){
    Scanner bookCatalogueFile = new Scanner(LIBRARY_CATALOGUE).useDelimiter(",\\s*");
    while (bookCatalogueFile.hasNext()) {
      String bookObject = bookCatalogueFile.next();
      arrayOfBooks.add(bookObject);
    }
    bookCatalogueFile.close();
    String[] stringArray = arrayOfBooks.toArray(new String[0]);
    for (String oneBook : stringArray) {
      System.out.println(oneBook);
    }
  }

  public void writeArrayToFile(){
    int len = arrayOfBooks.size();
    for (int i = 0; i < len; i++) {
      writeToCatalogue.write(arrayOfBooks.get(i) + "\n");
    }
    writeToCatalogue.close();
    }

  public static void donateBook(){
    //add the title to the array
    //overwrite the array with the text file
  }

  public static void checkOutBook(){
    //remove the index of or the title of the checked out book
    //overwrite the array with the text file
  }
}
