import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="quotes")
public class Quote {
  public Quote (String quote, String author, String subject){
    this.quote = quote;
    this.author = author;
    this.subject = subject;
  }
  @Id
  @SequenceGenerator(name="quote_generator", sequenceName="quotes_id_seq", allocationSize = 1)
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="quote_generator")
  @Column(name="id", nullable=false, unique=true)
  private long id;

  @Column(name="quote", nullable=false, length=256)
  private String quote;

  @Column(name="author", nullable=false, length=256)
  private String author;

  @Column(name="subject", nullable=false, length=256)
  private String subject;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getQuote() {
    return quote;
  }

  public void setQuote(String quote) {
    this.quote = quote;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

}
