import java.util.ArrayList;
import java.util.LinkedList;

public class Linked {

  public static void main(String[] args) {
    LinkedList<String> readingList = new LinkedList<>();
    readingList.add("On Basilisk Station");
    readingList.add("Hard Magic");
    System.out.println("Currently Reading: " + readingList.peek());
    System.out.println("Finished Reading: " + readingList.poll());
  }
}
