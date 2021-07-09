public class Car extends Automobile{
  private int capacity;
  private int numPassengers;

  public Car(String make, int mpg, int fuelCapacity, int capacity, int numPassengers) {
    super(make, mpg, fuelCapacity, running);
    this.capacity = capacity;
    this.numPassengers = numPassengers;
    this.setRunning(false);
  }

  public boolean addPassengers(int numNewPassengers) {
    if(this.numPassengers + numNewPassengers <= this.capacity) {
      this.numPassengers += numNewPassengers;
    }
    return false;
  }

  public void exitPassengers(int numberOfPassengerExit) {
    this.numPassengers = Math.max(this.numPassengers - numberOfPassengerExit, 0);
  }

  public int getCapacity() {
    return capacity;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  public int getNumPassengers() {
    return numPassengers;
  }

  public void setNumPassengers(int numPassengers) {
    this.numPassengers = numPassengers;
  }
}
