public class TeamMember {
  private String firstName;
  private String lastName;
  private String fullName;

  public TeamMember(String fullName) {
    this.fullName = fullName;
  }
  public TeamMember(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getFullName(){
    return fullName;
  }
  public String getCreditLine() {
    throw new Error("Override this method");
  }

}
