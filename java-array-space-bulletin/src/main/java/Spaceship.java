import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Spaceship {

  public static final String THE_CREW = "crewManifest.txt";
  public static final String CAPTAIN_FILE = "captainMsg.txt";

  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    String strLine = "";
    List<String> list = new ArrayList<String>();
      BufferedReader br = new BufferedReader(new FileReader("crewManifest.txt"));
      while (strLine != null) {
        list.add(br.readLine());
        strLine = br.readLine();
        sb.append(strLine);
        sb.append(System.lineSeparator());
        strLine = br.readLine();
        if (strLine == null) {
          break;
        }
        list.add(strLine);
      }
      System.out.println(Arrays.toString(list.toArray()));
      br.close();

    for(int i = 0; i < list.size(); i++) {
      if(list.get(i).contains("Captain")) {
        System.out.println("Welcome aboard! I am " + list.get(i) + "and we'll be on our way shortly. Here's our crew");
      } else {
        System.out.println(list.get(i));
      }
    }

    Scanner captainPrompt = new Scanner(System.in);
    File captainFile = new File(CAPTAIN_FILE);
    if (captainFile.exists()) {
      System.out.println("Advice from the prior missions:" + getFileContent(captainFile));
    }
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