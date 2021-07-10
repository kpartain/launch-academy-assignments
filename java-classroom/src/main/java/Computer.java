public class Computer{

  public int availableMemoryMb;
  public int availableDiskSpaceMb;
  public Student currentStudent;

  public Computer(int availableMemoryMb, int availableDiskSpaceMb) {
    this.availableMemoryMb = availableMemoryMb;
    this.availableDiskSpaceMb = availableDiskSpaceMb;
    this.currentStudent = null;
  }

  public int getAvailableMemoryMb() {
    return this.availableMemoryMb;
  }

  public int getAvailableDiskSpaceMb() {

    return this.availableDiskSpaceMb;
  }

  public Student getCurrentStudent() {
    return this.currentStudent;
  }

  public void setCurrentStudent(Student currentStudent) {
    this.currentStudent = currentStudent;
  }

  public boolean isEmpty() {
    boolean returnStatement = false;
    if (this.currentStudent == null) {
      returnStatement = true;
    }
    return returnStatement;
  }

  public void assignTo(Student student) {
    this.currentStudent = student;
  }
}
