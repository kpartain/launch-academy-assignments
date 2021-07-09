import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Seeder {
private static final String FILE_PATH = "src/main/resources/catalog.json";
  public static void main(String[] args) throws IOException {
    List<Product> products = new ArrayList<>();
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.launchacademy.products");
    EntityManager em = emf.createEntityManager();
    try{
      try {
        File mapData = new File(FILE_PATH);
        ObjectMapper mapper = new ObjectMapper();
        products = mapper.readValue(mapData, new TypeReference<List<Product>>() {
        });
      }catch (IOException io) {
        io.printStackTrace();
      }
      em.getTransaction().begin();
      for (Product product : products) {
        em.persist(product);
      }
      em.getTransaction().commit();
    }finally {
      em.close();
      emf.close();
    }
  }
}
