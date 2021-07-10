import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class Main {
  private static String ADD_CAR = "Add a Car";
  private static String LIST_CARS = "List Cars";
  private static String SEARCH_CARS = "Search for a Car";
  private static String EXIT = "Exit";

  private static Scanner inputScanner;

  public static void main(String[] args) {
    List<String> options = new ArrayList<String>();
    options.add(ADD_CAR);
    options.add(LIST_CARS);
//    options.add(SEARCH_CARS);
    options.add(EXIT);

    String menuChoice = "";
    while(menuChoice != EXIT) {
      System.out.println("CARS! CARS! CARS!");
      System.out.println("***");
      System.out.println("Coffee is for closers.\n");

      int menuIndex = 1;
      for(String option : options) {
        System.out.println(menuIndex + ". " + option);
        menuIndex++;
      }

      System.out.println("\nWhat would you like to do?");
      inputScanner = new Scanner(System.in);

      int selectedOption = inputScanner.nextInt();
      menuChoice = options.get(selectedOption - 1);
      if(menuChoice == ADD_CAR) {
        //add car logic - need nextLine() to move scanner past nextInt from menu to static method
        inputScanner.nextLine();
        addCar();
      }
      else if(menuChoice == LIST_CARS) {
        //list car logic
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.launchacademy.carDealership");
        EntityManager em = emf.createEntityManager();
        //Cars should be listed by price in descending order (highest priced cars first)
        TypedQuery<Car> query = em.createQuery("SELECT c from Car c ORDER BY price DESC", Car.class);
        List<Car> listOfCars = query.getResultList();
        for(Car eachCar : listOfCars) {
          //For each car, I should see the VIN, make, model, year, and asking price
          System.out.println("VIN: " + eachCar.getVin() +
              ", make: " + eachCar.getMake() +
              ", model: " + eachCar.getModel() +
              ", year: " + eachCar.getYear() +
              ", asking price: $" + eachCar.getPrice());
        }
        em.close();
        emf.close();
      }
    }
  }
  private static void addCar(){
    Car carToAdd = new Car();
    System.out.println("What is the VIN?");
    String addVin = inputScanner.nextLine();

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.launchacademy.carDealership");
    EntityManager em = emf.createEntityManager();
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();

    String vinCheck = "Select c from Car c WHERE vin = :vin";
    Query vinCheckQuery = em.createQuery(vinCheck, Car.class);
    vinCheckQuery.setParameter("vin", addVin);
    List<Car> matchingVinFoundList = vinCheckQuery.getResultList();
//if the VIN does not already exist in database, allow the user to continue to provide information
    if(matchingVinFoundList.isEmpty()){
      System.out.println("What is the year?");
      int addYear = inputScanner.nextInt();
      inputScanner.nextLine();

      System.out.println("What is the make?");
      String addMake = inputScanner.nextLine();

      System.out.println("What is the asking price?");
      int addPrice= inputScanner.nextInt();
      inputScanner.nextLine();

      System.out.println("What is the model?");
      String addModel = inputScanner.nextLine();

      carToAdd.setVin(addVin);
      carToAdd.setYear(addYear);
      carToAdd.setMake(addMake);
      carToAdd.setPrice(addPrice);
      carToAdd.setModel(addModel);
  //validate
      Set<ConstraintViolation<Car>> violationSet = validator.validate(carToAdd);
      if(!violationSet.isEmpty()){
  //if there are any violations for the input, list them all and return to main menu
        for(ConstraintViolation eachViolation : violationSet) {
          System.out.println(eachViolation.getPropertyPath() + ": " + eachViolation.getMessage());
        }
        return;
      } else {
  //if there are no violations, persist the new vehicle
        em.getTransaction().begin();
        em.persist(carToAdd);
        em.getTransaction().commit();
        em.close();
        emf.close();
      }
//If the VIN exists in database, do not prompt for addl info, return to main menu
    } else {
      System.out.println("This vehicle is already listed. You will be returned to the main menu.");
      return;
    }
  }
}
