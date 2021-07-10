public class StudentAssistant extends Student {
  private String studentAssistant;
  public StudentAssistant(String firstName, String lastName, String email) {
    super(firstName, lastName, email);
    this.studentAssistant = "(Student Assistant)";
  }

  @Override
  public String getDirectoryEntry() {
    return super.getDirectoryEntry() + ", " + this.studentAssistant;
  }
}
