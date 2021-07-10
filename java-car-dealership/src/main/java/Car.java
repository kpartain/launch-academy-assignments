import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(name="car_dealership")
public class Car {
  @Id
  @SequenceGenerator(name="car_dealership_generator", sequenceName = "car_dealership_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_dealership_generator")
//id
  @Column(name="id", nullable=false, unique=true)
  private int id;
//  VIN, required, non-duplicated arbitrary string between 5 and 20 characters.
  @NotNull(message="you must enter a VIN")
  @Size(min=5, max=20)
  @Column(name="vin", nullable=false, unique=true)
  private String vin;
//  year, required  integer  greater than 1980 and less than 2030
  @NotNull(message="you must enter the model year")
  @Range(min = 1981, max = 2029)
  @Column(name="year", nullable=false, unique=false)
  private int year;
//  make, required string
  @NotNull(message="you must enter the vehicle make")
  @NotBlank
  @Column(name="make", nullable=false, unique=false)
  private String make;
//  asking price required  integer between 500 and 50,000
  @NotNull(message="you must enter the vehicle asking price")
  @Range(min = 500, max = 50000)
  @Column(name="price", nullable=false, unique=false)
  private int price;
  //  model required string
  @NotNull(message="you must enter the vehicle model")
  @NotBlank
  @Column(name="model", nullable=false, unique=false)
  private String model;
//getters & setters
  public String getVin() {
    return vin;
  }

  public void setVin(String vin) {
    this.vin = vin;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public String getMake() {
    return make;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }
}
