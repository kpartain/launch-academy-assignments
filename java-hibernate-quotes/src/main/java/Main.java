import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.launchacademy.quotes");
    EntityManager em = emf.createEntityManager();
    List<Quote> quotes = new ArrayList<>();
    quotes.add(new Quote("We must never allow the future to collapse under the burden of memory.",
        "Milan Kundera", "Life"));
    quotes.add(new Quote(
        "I'm the negative-Nancy, curmudgeon, glass-half-empty-with-a-leak-in-it guy - which is basically the fuel that fires me up anyway.",
        "Maynard Keenan", "Humor"));
    quotes.add(new Quote(
        "A sort of catch-22, as in order to think straight I need caffeine, and in order to make that happen I need to think straight.",
        "David Sedaris", "Humor"));
    quotes.add(new Quote("We must accept human error as inevitable - and design around that fact",
        "Donald Berwick", "Career Advice"));
    quotes.add(new Quote("If you are lonely when you're alone, you are in bad company,",
        "Jean-Paul Sartre", "Life"));
    quotes.add(new Quote(
        "Those who were seen dancing were thought to be insane by those who could not hear the music.",
        "Friedrich Nietzsche", "Life"));

    List<Author> authors = new ArrayList<>();
    for (Quote quote : quotes) {
      authors.add(new Author(quote.getAuthor().split(" (?!.* )")[0],
          quote.getAuthor().split(" (?!.* )")[1]));
    }

    try {
      em.getTransaction().begin();
      for (Quote quote : quotes) {
        em.persist(quote);
      }
      for (Author author : authors) {
        em.persist(author);
      }
      em.getTransaction().commit();
    } finally {
      em.close();
      emf.close();
    }
  }
}
