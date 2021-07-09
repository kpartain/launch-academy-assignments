import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="studios")
public class Studio {

  @Id
  @SequenceGenerator(name="studio_generator", sequenceName="studio_id_seq", allocationSize = 1)
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="studio_generator")
  @Column(name = "id", nullable = false, unique = true)
  private Long id;
  public Long getId() {
    return id;
  }
  public void setId(long id) {
    this.id = id;
  }

  @NotNull
  @Column(name="name", nullable=false, unique = true)
  private String name;
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  @Column(name="created_at")
  private Timestamp createdAt;
  public Timestamp getCreatedAt() {
    return createdAt;
  }
  public void setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
  }

  @Column(name="updated_at")
  private Timestamp updatedAt;
  public Timestamp getUpdatedAt() {
    return updatedAt;
  }
  public void setUpdatedAt(Timestamp updatedAt) {
    this.updatedAt = updatedAt;
  }

}
