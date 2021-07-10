import java.util.ArrayList;

public class ForLoopExample {
  public static void main(String[] args) {
    ArrayList<String> names = new ArrayList<String>();
    names.add("Sam");
    names.add("Shawna");
    names.add("Brianna");

    for(String name : names) {
      System.out.println(name);
    }
  }
}