import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
//  id SERIAL PRIMARY KEY,
//  name VARCHAR(255),
//  description TEXT,
//  price VARCHAR(255),
//  featured BOOLEAN,
//  category_name VARCHAR(255)
@Entity
@Table(name="products")
public class Product {
  public Product (){

  }
  public Product (String name, String description, String price, boolean featured, String categoryName){
    this.name = name;
    this.description = description;
    this.price = price;
    this.featured = featured;
    this.category_name = categoryName;
  }
  @Id
  @SequenceGenerator(name="product_generator", sequenceName="products_id_seq", allocationSize = 1)
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="product_generator")

  @Column(name="id", nullable=false, unique=true)
  private long id;
  @Column(name="name", nullable=false, length=256)
  private String name;
  @Column(name="description", nullable=false, length=256)
  private String description;
  @Column(name="price", nullable=false, length=256)
  private String price;
  @Column(name="featured", nullable = false)
  private boolean featured;
  @Column(name="category_name", nullable=false, length=256)
  private String category_name;

  public long getId() { return id; }
  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  public boolean isFeatured() {
    return featured;
  }

  public void setFeatured(boolean featured) {
    this.featured = featured;
  }

  public String isCategory_name() {
    return category_name;
  }

  public void setCategory_name(String category_name) {
    this.category_name = category_name;
  }
}