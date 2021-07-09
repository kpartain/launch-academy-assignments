import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;

public class Calculator {

  public static final String PROBLEM_FILE = "./problem.txt";
  public static final String RESULTS_FILE = "./results.txt";

  public static void main(String[] args) throws IOException {
    file resultFile = newFile(RESULTS_FILE);
    resultFile.createNewFile();

    file readProblem = new File(PROBLEM_FILE);
    String allContent = new Scanner(readProblem).useDelimiter("\\z").next();
    String[] arrayOfChars = allContent.split("\\n");

    int theAnswer;

    if (arrayOfChars[0].equals('-')) {
      theAnswer = Integer.parseInt(allContent[1]) - Integer.parseInt(allContent[2]);
    } else if (arrayOfChars[0].equals('+')) {
      theAnswer = Integer.parseInt(allContent[1]) + Integer.parseInt(allContent[2]);
    }
    System.out.println(theAnswer);
  }

}