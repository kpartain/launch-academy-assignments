import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
  public static final String ADD_DEVICE = "Add a device";
  public static final String MANAGE_DEVICES = "Manage devices";
  public static final String HOUSE_STATUS = "View all devices in home";
  public static final String TURN_ON = "Turn all devices on";
  public static final String TURN_OFF = "Turn all devices off";
  public static final String EXIT = "All done?";
  private List<Device> devices;

  Menu() {

    this.devices = new ArrayList<Device>();
  }

  public enum MenuOption {
    a(ADD_DEVICE),
    b(MANAGE_DEVICES),
    c(HOUSE_STATUS),
    d(TURN_ON),
    e(TURN_OFF),
    f(EXIT);

    private String optionText;

    MenuOption(String optionText) {
      this.optionText = optionText;
    }

    public String toString() {
      return this.name() + ". " + this.optionText;
    }
  }

  @Override
  public String toString() {
    String output = "";
    for(MenuOption option : MenuOption.values()) {
      output += option.toString() + "\n";
    }
    return output;
  }

  public void promptMenu(){
    System.out.println(this.toString());
    MenuOption input = null;
    Scanner alexa = new Scanner(System.in);
    do {
      System.out.println("How can I help?");
      try {
        input = MenuOption.valueOf(alexa.next());
      } catch(IllegalArgumentException error) {
        System.out.println("Hmm, I'm not sure how to help with that. Do you want me to do something else?");
      }
      if(input == MenuOption.a) {
        //public static final String ADD_DEVICE = "Add a device";
        //when I add a device, I must specify the name and it creates
        //need to specify here if the light is dimmable or not
        //defaults to powered off, added to global list of devices
      }
      else if(input == MenuOption.b) {
        //  public static final String MANAGE_DEVICES = "Manage devices";
        //when I click manage devices, I get a list of all devices
        //ArrayList<Device>
        //select them - toggle power
        //if I manage a light, I can turn it off
        //if the light is dimmable, I can turn on or off OR specify % of light
      }
      else if(input == MenuOption.c) {
        //for loop
        //  public static final String HOUSE_STATUS = "View all devices in home";
        //When I select house status, every device and their status is printed
        //if poweredOn = true, display "powered on"
        //if poweredOn = true && isDimmable = true, display on + x%
      }
      else if(input == MenuOption.d) {
        //for loop
        //  public static final String TURN_ON = "Turn all devices on";
        //when I select turn on, all lights are set to 100
      }
      else if(input == MenuOption.d) {
        //for loop
        //  public static final String TURN_OFF = "Turn all devices off";
        //when I select turn off, all lights are set to off, dimmable to 0
      }
    } while(input != MenuOption.f);
    System.out.println("Alexa has switched to inactive and is not listening.");
    alexa.close();
  }

}

this.isRunning == true ? this.isRunning = false : this.isRunning = true;