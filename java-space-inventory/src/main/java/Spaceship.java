import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Spaceship {

  private static final String CREW_FILE = "crewManifest.json";
  private static final String INVENTORY_FILE = "inventory.json";
  private static final String REMOVE_INVENTORY_FILE = "removeinventory.json";
  private static final String CAPTAIN = "Captain";

  public static void main(String[] args) throws IOException {

    System.out.println("Crew: \n-----------");
    File jsonFil = new File(CREW_FILE);
    JsonFactory factor = new JsonFactory();
    JsonParser parse = factor.createParser(jsonFil);
    parse.nextToken();
    while (parse.nextToken() != JsonToken.END_OBJECT) {
      String fiel = parse.getCurrentName();
      JsonToken valu = parse.nextToken();
      System.out.println("Rank: " + fiel + ", Name: " + parse.getText());
    }

    File jsonFi = new File(REMOVE_INVENTORY_FILE);
    JsonFactory facto = new JsonFactory();
    JsonParser pars = facto.createParser(jsonFi);
    pars.nextToken();
    HashMap<String, Integer> removeMe = new HashMap<String, Integer>();
    while (pars.nextToken() != JsonToken.END_OBJECT) {
      String field = pars.getCurrentName();
      JsonToken value = pars.nextToken();
      int keyValue = pars.getValueAsInt();
      removeMe.put(field, keyValue);
    }

    File jsonFile = new File(INVENTORY_FILE);
    JsonFactory factory = new JsonFactory();
    JsonParser parser = factory.createParser(jsonFile);
    parser.nextToken();
    HashMap<String, Integer> inventoryList = new HashMap<String, Integer>();
    while (parser.nextToken() != JsonToken.END_OBJECT) {
      String field = parser.getCurrentName();
      JsonToken val = parser.nextToken();
      int keysValue = parser.getValueAsInt();
      inventoryList.put(field, keysValue);
    }

    for (Map.Entry<String, Integer> inventoryItem : removeMe.entrySet()) {
      String object = inventoryItem.getKey();
      if (inventoryList.containsKey(object)) {
        Integer newQuantity = (inventoryList.get(object) - inventoryItem.getValue());
        inventoryList.replace(object, newQuantity);
      }
    }
    System.out.println("INVENTORY(after removal) \n--------");
    for (Map.Entry<String, Integer> inventoryItem : inventoryList.entrySet()) {
      if (inventoryItem.getValue() > 0) {
        System.out
            .println("Item: " + inventoryItem.getKey() + " Count: " + inventoryItem.getValue());
      }
    }
  }
}