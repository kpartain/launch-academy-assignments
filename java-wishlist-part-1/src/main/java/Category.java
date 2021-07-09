import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
//do we need to create a validator set for this since it's a persistance error not validation error??
@Table(name = "categories", uniqueConstraints={@UniqueConstraint(columnNames={"name"})})
public class Category {
  @Id
  @SequenceGenerator(name="category_generator", sequenceName="categories_id_seq", allocationSize = 1)
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="category_generator")

  @Column(name="id", nullable=false, unique=true)
  private Long id;

  @NotNull
  @NotBlank
  @Column(name="name", nullable = false, unique = true)
  private String name;

  @ManyToOne
  @JoinColumn(name="product_id", nullable=false)
  private Product product;

  public Product getProduct() { return product; }

  public void setProduct(Product newProduct) { product = newProduct; }
  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }

  public String getName() { return name; }
  public void setName(String name) { this.name = name; }

}