import java.util.Scanner;

public class Light extends Device {
  private Boolean isDimmable;
  private int lightPercent;

  public Light(String deviceName) {
    super(deviceName);
    this.deviceName = deviceName;
    this.setPowerStatus(false);
    this.isDimmable = false;
    this.lightPercent = 0;
  }

  public String getDeviceName() {
    return deviceName;
  }

  public Boolean getPowerStatus() {
    return powerStatus;
  }

  public Boolean getDimmable() {
    return isDimmable;
  }

  public int getLightPercent() {
    return lightPercent;
  }

  public void setLightPercent(int lightPercent) {
    this.lightPercent = lightPercent;
  }

  public void setPowerStatus(Boolean powerStatus) {
    this.powerStatus = powerStatus;
  }

  public String togglePower() {
    this.powerOn();
    String returnStatement = " ";
    if(this.isDimmable) {
      if (this.getPowerStatus() == false) {
        setPowerStatus(true);
        returnStatement = getDeviceName() + " is powered on.";
      } else {
        setPowerStatus(false);
        returnStatement = getDeviceName() + " is powered off.";
      }
    }
    else if (this.isDimmable == false) {
      Scanner dimScanner = new Scanner(System.in);
      System.out.println("What brightness should I set " + this.deviceName + "to?");
      String stringInput = dimScanner.nextLine();
      int userInput = Integer.parseInt(stringInput);
      if(userInput == 100) {
        setPowerStatus(true);
        setLightPercent(100);
        returnStatement = this.getDeviceName() + " is powered on.";
      } else if (userInput == 0) {
        setPowerStatus(false);
        setLightPercent(0);
        returnStatement = this.getDeviceName() + " is powered off.";
      } else if(userInput >= 1 && 100 >= userInput) {
        setPowerStatus(true);
        setLightPercent(userInput);
        returnStatement = this.getDeviceName() + " is set to " + userInput + "% brightness."
      } else {
        returnStatement = "That's not a valid brightness amount.";
      }
    }

    return returnStatement;
  }

  public void setDimmable(Boolean dimmable) {
    isDimmable = dimmable;
  }

  public String becomeDimmable() {
    setDimmable(true);
    return getDeviceName() + " is saved as a dimmable light.";
  }
}
