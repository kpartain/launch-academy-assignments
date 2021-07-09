public class Person {
  private String firstName;
  private String lastName;
  public static final String DEFAULT_LANGUAGE = "en";

  public Person(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String greet() {
    return this.greet(DEFAULT_LANGUAGE);
  }

  public String greet(String language) {
    StringBuilder builder = new StringBuilder();
    if(language.equals("en")) {
      builder.append("Hi, ");
    }
    else if(language.equals("es")) {
      builder.append("Hola, ");
    }
    else if(language.equals("fr")) {
      builder.append("Bonjour, ");
    }
    else {
      throw new Error("Language not supported");
    }
    builder.append(firstName);
    return builder.toString();
  }

  public static void main(String[] args) {
    Person dan = new Person("Dan", "Smith");
    Person susan = new Person("Susan", "Doe");

    System.out.println(dan.greet());
    System.out.println(susan.greet("es"));
  }
}