import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Spaceship {

  public static final String THE_CREW = "crewManifest.txt";
  public static final String CAPTAIN_FILE = "captainMsg.txt";

  public static void main(String[] args) throws IOException {
    List<String> listOfCaptains = new ArrayList<String>();


    File captainFile = new File(CAPTAIN_FILE);
    if (captainFile.exists()) {
      System.out.println("Advice from the prior missions:" + getFileContent(captainFile));
    }
    System.out.println("This mission's crew:" + "\n" + getFileContent(new File(THE_CREW)));
    Scanner captainPrompt = new Scanner(System.in);
    System.out.println("Welcome back - what advice do you have for the next mission?");
    StringBuilder captainMsg = new StringBuilder(captainPrompt.nextLine());
   while (captainPrompt.hasNextLine() == false) {
     String captainReply = captainPrompt.nextLine();
      captainMsg.append("\n").append(captainReply);
     if (captainReply.isBlank()) {
       break;
     }
   }
   captainPrompt.close();
    FileWriter fw = new FileWriter(captainFile, true);
    fw.write(captainMsg.toString());
    fw.close();
  }

  private static String getFileContent(File file) throws IOException {
    return new Scanner(file).useDelimiter("\\z").next();
  }
}