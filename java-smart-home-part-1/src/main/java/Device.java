public class Device {
  public String deviceName;
  public Boolean powerStatus;
  public static final String LIGHT = "Non-dimmable light";
  public static final String DIMMABLE_LIGHT = "Dimmable light";
  public static final String TV = "Television";
  public static final String STEREO = "Stereo";

  public Device(String deviceName) {
    this.deviceName = deviceName;
    this.powerStatus = false;
  }

  public String getDeviceName() {
    return deviceName;
  }

  public Boolean getPowerStatus() {
    return powerStatus;
  }

  public void setPowerStatus(Boolean powerStatus) {
    this.powerStatus = powerStatus;
  }

  public void powerOn(){
    this.powerStatus = !this.powerStatus;
  }
}
