public class Automobile {
  private String make;
  private int mpg;
  private int fuelCapacity;
  private boolean running;

  public Automobile(String make, int mpg, int fuelCapacity, boolean running) {
    this.make = make;
    this.mpg = mpg;
    this.fuelCapacity = fuelCapacity;
    this.running = true;
  }

  public void toggleEngine() {
    this.running = true;
  }

  public String getMake() {
    return make;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public int getMpg() {
    return mpg;
  }

  public void setMpg(int mpg) {
    this.mpg = mpg;
  }

  public int getFuelCapacity() {
    return fuelCapacity;
  }

  public void setFuelCapacity(int fuelCapacity) {
    this.fuelCapacity = fuelCapacity;
  }

  public boolean isRunning() {
    return running;
  }

  public void setRunning(boolean running) {
    this.running = running;
  }
}
