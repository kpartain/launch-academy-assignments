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
//What titles were released in 2001?
      TypedQuery<Movie> query2001 = em.createQuery("SELECT m FROM Movie m WHERE year = 2005", Movie.class);
      List<Movie> standalone = query2001.getResultList();
      for(Movie object : standalone){
        System.out.println(object.getTitle());
      }

//What titles were released in 2002 and had a rating higher than 90?
      TypedQuery<Movie> query2002 = em.createQuery("SELECT m FROM Movie m WHERE year = 2005 AND rating > 90", Movie.class);
      List<Movie> standalone2002 = query2002.getResultList();
      for(Movie object : standalone2002){
        System.out.println(object.getTitle());
      }

//What actors have the last name of Wilson?
      TypedQuery<Actor> queryWilson = em.createQuery("SELECT a FROM Actor a WHERE name LIKE '% Wilson'", Actor.class);
      List<Actor> standaloneWilson = queryWilson.getResultList();
      for(Actor object : standaloneWilson){
        System.out.println(object.getName());
      }

//What actors have the first name of Owen?
      TypedQuery<Actor> queryOwen = em.createQuery("SELECT a FROM Actor a WHERE name LIKE 'Owen %'", Actor.class);
      List<Actor> standaloneOwen = queryOwen.getResultList();
      for(Actor object : standaloneOwen){
        System.out.println(object.getName());
      }

//What studios start with "Fox"?
      TypedQuery<Studio> queryFox = em.createQuery("SELECT s FROM Studio s WHERE name LIKE 'Fox%'", Studio.class);
      List<Studio> standaloneFox = queryFox.getResultList();
      for(Studio object : standaloneFox){
        System.out.println(object.getName());
      }


//What studios involve Disney?
      TypedQuery<Studio> queryDisney = em.createQuery("SELECT s FROM Studio s WHERE name LIKE '%Disney%'", Studio.class);
      List<Studio> standaloneDisney = queryDisney.getResultList();
      for(Studio object : standaloneDisney){
        System.out.println(object.getName());
      }


//What were the top 5 rated movies in 2004?
      TypedQuery<Movie> query2004 = em.createQuery("SELECT m FROM Movie m WHERE year = 2004 ORDER BY rating DESC", Movie.class);
      List<Movie> standalone2004 = query2004.getResultList();
      for(int i = 0; i < 5; i++) {
          System.out.println(standalone2004.get(i).getTitle());
        }

//What were the worst 10 movie titles and their ratings in 2003?
      TypedQuery<Movie> query2003bad = em.createQuery("SELECT m FROM Movie m WHERE year = 2003 ORDER BY rating ASC", Movie.class);
      List<Movie> standalone2003bad = query2003bad.getResultList();
      for(int i = 0; i < 10; i++) {
          System.out.println(standalone2003bad.get(i).getTitle() + " rating: " + standalone2003bad.get(i).getRating());
        }

    }
    finally {
      em.close();
      emf.close();
    }
  }
}