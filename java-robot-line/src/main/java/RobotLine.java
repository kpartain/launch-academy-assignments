import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class RobotLine {

  public static void main(String[] args) {
    String content = new String();
    File file = new File("initial-line.txt");
    LinkedList<String> list = new LinkedList<String>();

    try {
      Scanner sc = new Scanner(new FileInputStream(file));
      while (sc.hasNextLine()){
        content = sc.nextLine();
        list.add(content);
      }
      sc.close();
    }catch(FileNotFoundException fnf){
      fnf.printStackTrace();
    }
    catch (Exception e) {
      e.printStackTrace();
      System.out.println("\nProgram terminated Safely...");
    }

    // Load initial-line.txt to reflect who's in line first, in order.
    // The first person in the text file should be first in line.
    System.out.println("Original list: "  + list);

    //add Jim, Joan, Lisa, to the front of the list
    list.addFirst("Lisa");
    list.addFirst("Joan");
    list.addFirst("Jim");
    System.out.println("add three to the front: " + list);

    //add Fran to the front of the list
    list.addFirst("Fran");
    System.out.println("Add Fran: " + list);

    // remove Jim & Fran
    list.remove("Jim");
    list.remove("Fran");
    System.out.println("Remove Jim & Fran: " + list);

    //poll the first 5 people, sout <name> is so lucky!
    for(int i=0; i<5; i++) {
      String sayName = list.poll();
      //you could use pollFirst() here to be more clear - pollFirst allows null head
      System.out.println(sayName + " is the lucky winner");
    }

    //remove the last three people
    for(int i=0; i<3; i++){
      list.pollLast();
    }
    System.out.println("Remove last three " + list);

    //Output the length of the queue
    System.out.println("Size of queue " + list.size());

    //remove Alex from queue
    list.remove("Alex");
    System.out.println("Remove Alex " + list);

    //Output the first person in the queue
    System.out.println("The first person is " + list.peek());
  }
}
