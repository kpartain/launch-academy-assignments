public class CastMember extends TeamMember {
  private String role;

  public CastMember(String firstName, String lastName, String role) {
    super(firstName, lastName);
    this.role = role;
  }

  public String getRole() {
    return role;
  }

  public String getCreditLine(){
    StringBuilder builder = new StringBuilder();
    builder.append(getRole() + " " + "-" + " " + getFirstName() + " " + getLastName());
    String theCreditLine = builder.toString();
    return theCreditLine;
  }
}
