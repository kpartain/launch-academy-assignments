import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.sun.istack.NotNull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Table(name="laser_cannons")
public class LaserCannon {
  @Id
  @SequenceGenerator(name="laser_canon_generator", sequenceName = "laser_canons_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "laser_canon_generator")
  @Column(name="id", nullable = false, unique = true)
  private long id;
  //name string not null
  @NotNull
  @NotBlank
  @Column(name="name", nullable = false)
  private String name;
  //recharge_time not null
  @NotNull
  @Column(name="recharge_time", nullable = false)
  private int rechargeTime;
  //fire_rate int
  @Column(name="fire_rate", nullable = true)
  private int fireRate;
  //attachment string optional
  @Column(name="attachment", nullable = true)
  private String attachment;
  //overload boolean
  @Column(name="overload", nullable = true)
  private boolean overload = false;

  public boolean isOverload() {
    return overload;
  }

  public void setOverload(boolean overload) {
    this.overload = overload;
  }
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getRechargeTime() {
    return rechargeTime;
  }

  public void setRechargeTime(int rechargeTime) {
    this.rechargeTime = rechargeTime;
  }

  public int getFireRate() {
    return fireRate;
  }

  public void setFireRate(int fireRate) {
    this.fireRate = fireRate;
  }

  public String getAttachment() {
    return attachment;
  }

  public void setAttachment(String attachment) {
    this.attachment = attachment;
  }
}
