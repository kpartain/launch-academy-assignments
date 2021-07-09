public class Monkey {
  private String firstName;
  private String lastName;
  private String favoriteFood;
  private String favoriteQuote;
  private String getFullName;

  public Monkey(String firstName, String lastName, String favoriteFood, String favoriteQuote) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.favoriteFood = favoriteFood;
    this.favoriteQuote = favoriteQuote;
    this.getFullName = this.getFullName();
  }

  public String getFirstName(){
    return this.firstName;
  }

  public String getLastName(){
    return this.lastName;
  }

  public String getFavoriteFood() {
    return this.favoriteFood;
  }

  public String getFavoriteQuote(){
    return this.favoriteQuote;
  }

  public String getFullName(){
    StringBuilder builder = new StringBuilder();
    builder.append(this.firstName);
    builder.append(" ");
    builder.append(this.lastName);
    this.getFullName = builder.toString();
    return builder.toString();
  }
}
