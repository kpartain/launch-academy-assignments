public class Truck extends Automobile {
  private int bedLength;
  private int bedWidth;
  private int containerHeightFeet;
  private int currentLoadCubicFeet;

  public Truck(String type, String model, String make, int mpg, int fuelCapacity, int bedLength, int bedWidth) {
    super(type, model, make, mpg, fuelCapacity);
    this.bedLength = bedLength;
    this.bedWidth = bedWidth;
    this.containerHeightFeet = 3;
    this.currentLoadCubicFeet = 0;
  }
  //optional parameter via method overload
  public Truck(String type, String model, String make, int mpg, int fuelCapacity, int bedLength, int bedWidth, int containerHeightFeet) {
    super(type, model, make, mpg, fuelCapacity);
    this.bedLength = bedLength;
    this.bedWidth = bedWidth;
    this.containerHeightFeet = containerHeightFeet;
    this.currentLoadCubicFeet = 0;
  }

  public int volumeCapacity(){
    return this.bedLength * this.bedWidth * this.containerHeightFeet;
  }

  public boolean addCargo(int cargoVolume) {
    if(this.currentLoadCubicFeet + cargoVolume <= this.volumeCapacity()) {
      this.currentLoadCubicFeet += cargoVolume;
    }
    return false;
  }
}
