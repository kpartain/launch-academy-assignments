public class Producer extends TeamMember {
  public Producer(String fullName) {
    super(fullName);
  }

  public String getCreditLine(){
    StringBuilder builder = new StringBuilder();
    builder.append("Producer " + "- " + getFullName());
    String theCreditLine = builder.toString();
    return theCreditLine;
  }

}
