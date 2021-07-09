
import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JProgressBar;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class Menu {

  public static final String ADD_A_PRODUCT = "Add a Product";
  public static final String LIST_ALL_PRODUCTS = "Display all products";
  public static final String QUIT_TEXT = "Quit";

  public enum MenuOption {
    a(ADD_A_PRODUCT),
    b(LIST_ALL_PRODUCTS),
    c(QUIT_TEXT);

    private final String optionText;

    MenuOption(String optionText) {
      this.optionText = optionText;
    }

    public String toString() {
      return this.name() + ". " + this.optionText;
    }
  }

  @Override
  public String toString() {
    String output = "";
    for (MenuOption option : MenuOption.values()) {
      output += option.toString() + "\n";
    }
    return output;
  }

  public void promptUntilDone() {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.launchacademy.wishlist");
    EntityManager em = emf.createEntityManager();

    //do while for adding uncategorized so it instantiates immediately and places at ID 1?
    Category uncategorized = new Category();
    uncategorized.setName("uncategorized");
    em.getTransaction().begin();
    em.persist(uncategorized);
    em.getTransaction().commit();
    //close do while

    MenuOption input = null;
    Scanner scanner = new Scanner(System.in);
    do {
      System.out.println(this.toString());
      System.out.print("> ");
      try {
        input = MenuOption.valueOf(scanner.nextLine());
      } catch (IllegalArgumentException error) {
        System.out.println("Please choose a valid option.");
      }

      if (input == MenuOption.a) {
        Product newProduct = new Product();
        System.out.println("What is the name of the product?");
        String productName = scanner.nextLine().trim();
        newProduct.setName(productName);
        System.out.println("What is the price?");
        BigDecimal productPrice = new BigDecimal(scanner.nextLine());
        newProduct.setPrice(productPrice);
        System.out.println("What is the url?");
        String productUrl = scanner.nextLine().trim();
        newProduct.setUrl(productUrl);
        System.out.println("Do you want to add a category?");
        if(scanner.nextLine().trim().equalsIgnoreCase("yes")) {
          System.out.println("What category is " + productName + "?");
          String categoryName = scanner.nextLine().trim();
          //see if it exists in category table, if it does return the id
          //if it doesn't, add it to the category table and return the id
          //ultimately store the id here since we want the foreign key
        } else if (scanner.nextLine().trim().equalsIgnoreCase("no")) {
          //set the category to default "uncategorized" which instantiates first and has long ID 1
          newProduct.setCategoryID(1L);
        }
      // create and persist the product
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Product>> violations = validator.validate(newProduct);
        if(violations.size() > 0) {
          for (ConstraintViolation<Product> violation : violations) {
            System.out.println(violation.getPropertyPath() + ": " + violation.getMessage());
          }
        }
        if(violations.isEmpty()) {
          em.getTransaction().begin();
          em.persist(newProduct);
          em.getTransaction().commit();
          System.out.println(newProduct.getId());
        }
      } else if (input == MenuOption.b) {
      // retrieve a list of all products
        TypedQuery<Product> query = em.createQuery("Select p from Product p", Product.class);
        List<Product> products = query.getResultList();
        if(products.size() > 0) {
          for(Product product : products) {
            System.out.println("Product: " + product.getName());
            System.out.println("Price: $" + product.getPrice());
            System.out.println("URL: " + product.getUrl());
            //need to eventually filter category
          }
        } else {
          System.out.println("No records found");
        }
      }
    } while (input != MenuOption.c);
    em.close();
    emf.close();
    System.out.println("Thanks! Come back soon ya hear!");
  }
}
