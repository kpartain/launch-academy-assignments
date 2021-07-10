import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Teachers {

  public static void main(String[] args) throws IOException {
    File teachersJSON = new File("src/main/resources/arrayOfObjectsJSON.json");
    List<HashMap<String, String>> teachers;
    ObjectMapper instanceOfAOM = new ObjectMapper();
    teachers = instanceOfAOM.readValue(teachersJSON, ArrayList.class);
    System.out.println(teachers);

  }
}
