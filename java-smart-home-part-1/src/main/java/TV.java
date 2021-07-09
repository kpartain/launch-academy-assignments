public class TV extends Device implements Volume {
    private int channel;
    private int volume;

    public Stereo(String deviceName) {
      super(deviceName);
      this.deviceName = deviceName;
      this.setPowerStatus(false);
      this.channel = 1;
      this.volume = 25;
    }

  public TV(String deviceName) {
    super(deviceName);
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

  public void changeChannel(int newChannel){
      if (newChannel >= 1 && 999 >= newChannel) {
        this.channel = newChannel;
      }
  }
}
