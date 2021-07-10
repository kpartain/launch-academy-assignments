import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class Main {

  public static void main(String[] args) {
    EntityManagerFactory emf =
        Persistence.createEntityManagerFactory("com.launchacademy.movies");
    EntityManager em = emf.createEntityManager();

    try {
      em.getTransaction().begin();
      Query updateQuery = em.createQuery("UPDATE Movie SET rating = :newRating WHERE title = 'Tequila Mockingbird'");
      updateQuery.setParameter("newRating", 400);
      int updateCount = updateQuery.executeUpdate();
      em.getTransaction().commit();
    }
    finally {
      em.close();
      emf.close();
    }
  }
}