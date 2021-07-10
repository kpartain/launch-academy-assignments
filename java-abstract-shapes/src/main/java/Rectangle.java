public class Rectangle extends Shape{
  private double height;
  private double width;

  public Rectangle(double height, double width) {
    this.height = height;
    this.width = width;
  }

  @Override
  public double perimeter(){
    return 2*this.height + 2*this.width;
  }

  @Override
  public double area(){
    return this.height*this.width;
  }
}
