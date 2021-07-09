public class Stereo extends Device implements Volume {
  private int volume;

  public Stereo(String deviceName) {
    super(deviceName);
    this.deviceName = deviceName;
    this.setPowerStatus(false);
    this.volume = 25;
  }


  @Override
  public int currentVolume() {
    return this.volume;
  }

  @Override
  public void changeVolume(int newVolume) {
    this.volume = newVolume;
  }

  @Override
  public void mute() {
    this.volume = 0;
  }
}
