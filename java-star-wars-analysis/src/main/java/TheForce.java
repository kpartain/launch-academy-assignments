import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class TheForce {

  public static void main(String[] args) throws IOException {
    //Create an array list of names using the information in characters.txt. Output the list
    File charactersDotTxt = new File("src/main/resources/characters.txt");
    List<String> charactersArray = new ArrayList<String>();
    Scanner characterScanner = new Scanner(charactersDotTxt);
    while(characterScanner.hasNextLine()) {
      charactersArray.add(characterScanner.nextLine());
    }
    System.out.println("The List: " + charactersArray);
    //Add Biggs, and Wedge to the characters array
    charactersArray.addAll(Arrays.asList("Biggs", "Wedge"));
    //Add Darth Vader to the list between Luke and Leia
    int indexOfLuke = charactersArray.indexOf("Luke") + 1;
    charactersArray.add(indexOfLuke, "Darth Vader");
    //Remove Han from the list
    charactersArray.remove("Han");
    //Output the updated list
    System.out.println("The Updated List: " + charactersArray);
    //Create a HashMap for characters and their last names
    //Use the existing list you've made above to populate the keys
    //Set each last name to "Unknown" to start
    Map<String, String> charactersHashMap = new HashMap<>();
    for(String firstName : charactersArray) {
      charactersHashMap.put(firstName, "Unknown");
    }
    //Output the hashmap
    System.out.println("The Hashmap: " + charactersHashMap);
    //You should use the last-names.json file to populate your list. Using the keys from your hash
    // of characters update the value for each using the value from the last-names.json Output it.
    byte[] jsonMapData = Files.readAllBytes(Paths.get("src/main/resources/last-names.json"));
    Map charactersMapFromJson = new HashMap<String, String>();
    ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);;
    charactersMapFromJson = mapper.readValue(jsonMapData, HashMap.class);
    System.out.println("Characters hashmap from JSON: " + charactersMapFromJson);
    for(String characterFirstName : charactersHashMap.keySet()) {
      charactersHashMap.replace(characterFirstName, charactersMapFromJson.get(characterFirstName).toString());
    }
    System.out.println("Update unknown to last name: " + charactersHashMap);
    //Remove "Obi-Wan Kenobi" from the character HashMap
    charactersHashMap.remove("Obi-Wan");
    //Output the updated HashMap
    System.out.println("Oops Vader did it again: " + charactersHashMap);
    //Using your HashMap output the last names for only the characters whose first names contain an L
    for(String character : charactersHashMap.keySet()) {
      if(character.contains("L")) {
        System.out.println(charactersHashMap.get(character) + "'s first name contains the letter L");
      }
    }
    //Using your HashMap output only the key for "Antilles"
    for (Entry<String, String> character : charactersHashMap.entrySet()) {
      if (character.getValue().equals("Antilles")) {
        System.out.println(character.getKey());
      }
    }
    //hashmap of hex codes
    File hexCodes = new File("src/main/resources/hex-colors.json");
    Map hexCodeMap = new HashMap<String, String>();
    hexCodeMap = mapper.readValue(hexCodes, HashMap.class);
    //array of hashmaps of character details
    File detailedCharactersFile = new File("src/main/resources/characters.json");
    List<HashMap<String, String>> detailedCharactersArray = new ArrayList<HashMap<String, String>>();
    detailedCharactersArray = mapper.readValue(detailedCharactersFile, ArrayList.class);
    //Create an array list of names based on characters.json who have blue eyes, NOT blue-gray
    //Output the list
    List<String> blueEyedCharacters = new ArrayList<>();
    for(Map<String, String> character : detailedCharactersArray) {
      if(character.get("eye_color").equals("blue")){
        blueEyedCharacters.add(character.get("name"));
      }
    }
    System.out.println("Blue eyed characters: " + blueEyedCharacters);
    //Using the character's name as key, store their correlating birth year in a HashMap. Output it.
    Map<String, String> nameKeyYearValue = new HashMap<>();
    for(Map<String, String> character : detailedCharactersArray) {
      String firstName = character.get("name");
      String birthYear = character.get("birth_year");
      nameKeyYearValue.put(firstName, birthYear);
    }
    System.out.println("Name as key, birthyear value: " + nameKeyYearValue);
    //Using the HashMap, output Biggs Darklighter's birth year.
    System.out.println("Biggs Darklighter's birthyear is " + nameKeyYearValue.get("Biggs Darklighter"));
  //output a count of characters per gender in the list. Should resemble male: N \n n/a: N \n female: N
    int males = 0;
    int genderIsASocialConstruct = 0;
    int females = 0;
    for(Map<String, String> character : detailedCharactersArray) {
      if(character.get("gender").equals("male")){
        males += 1;
      } else if (character.get("gender").equals("female")) {
        females += 1;
      } else if (character.get("gender").equals("n/a")){
        genderIsASocialConstruct += 1;
      }
    }
    System.out.println("male: " + males);
    System.out.println("n/a: " + genderIsASocialConstruct);
    System.out.println("female: " + females);
    //Use hex-colors.json to add a eye_color_hex_value key to each character's HashMap.
    for(Map<String, String> character : detailedCharactersArray) {
      String eyeColor = character.get("eye_color");
      character.put("eye_color_hex_value", hexCodeMap.get(eyeColor).toString());
    }
    //Write the new JSON, including the eye_color_hex_value to modified_characters.json
    File modifiedCharacters = new File("src/main/resources/modified_characters.json");
    mapper.writeValue(modifiedCharacters, detailedCharactersArray);
  }
}
