import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.OneToMany;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.URL;


@Entity
@Table(name = "products")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Product {
  @Id
  @SequenceGenerator(name="product_generator", sequenceName="products_id_seq", allocationSize = 1)
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="product_generator")

  @Column(name="id", nullable=false, unique=true)
  private Long id;

  @NotNull(message = "can't be blank")
  @NotBlank
  @Column(name="name", nullable = false, unique = true)
  private String name;

  @NotNull(message = "can't be blank")
  @NotBlank
  @DecimalMin(value = "0.00", inclusive = false)
  @Column(name="price", nullable = false)
  private BigDecimal price;

  @NotNull(message = "can't be blank")
  @Pattern(regexp="^(http|https|ftp)://.*$")
  @URL(protocol = "http")
  @Column(name="url")
  private String url;

  @Column(name="category_id", nullable=false, insertable = false, updatable = true)
  private Long categoryId;
  public void setCategoryID(Long id) { this.categoryId = id; }
  //we will have the first category be "uncategorized" so ID is always 1
  @OneToMany(mappedBy = "product")
  private List<Category> categories = new ArrayList<Category>();
  public List<Category> getCategories() { return categories; }

  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }

  public String getName() { return name; }
  public void setName(String name) { this.name = name; }

  public BigDecimal getPrice() { return price; }
  public void setPrice(BigDecimal price) { this.price = price; }

  public String getUrl() { return url; }
  public void setUrl(String url) { this.url = url; }

}
