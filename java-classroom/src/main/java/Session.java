import java.util.ArrayList;
import java.util.List;

public class Session {

  private String name;
  private String subject;
  private List<Object> studentRoster;
  private List<Computer> computers;

  public Session(String name, String subject) {
    this.name = name;
    this.subject = subject;
    this.studentRoster = new ArrayList<Object>();
    this.computers = new ArrayList<Computer>();
    for (int i = 0; i < 10; i++) {
      if (i < 4) {
        computers.add(new Mac(i + 1, i + 1));
      } else {
        computers.add(new PC(i + 1, i + 1));
      }
    }
  }

  public List<Computer> getUnassignedComputers() {
    List<Computer> unassignedComputers = new ArrayList<Computer>();
    for (Computer eachComputer : this.computers) {
      if (eachComputer instanceof Mac) {
        if (((Mac) eachComputer).getCurrentStudent() == null) {
          unassignedComputers.add(eachComputer);
        }
      }
      if (eachComputer instanceof PC) {
        if (((PC) eachComputer).getCurrentStudent() == null) {
          unassignedComputers.add(eachComputer);
        }
      }
    }
    return unassignedComputers;
  }

  public String getName() {
    return name;
  }

  public String getSubject() {
    return subject;
  }

  public List<Object> getStudentRoster() {
    return studentRoster;
  }

  public void enroll(Object newStudent) {
    if (newStudent instanceof Student) {
      if (!this.studentRoster.contains(newStudent)) {
        this.studentRoster.add((Student) newStudent);
      }
    }
    if (newStudent instanceof StudentAssistant) {
      if (!this.studentRoster.contains(newStudent)) {
        this.studentRoster.add((StudentAssistant) newStudent);
      }
    }
  }


  public String getDirectory() {
    String returnStatement = " ";
    for (Object eachStudent : this.studentRoster) {
      if (eachStudent instanceof Student) {
        returnStatement += ((Student) eachStudent).getDirectoryEntry() + "\n";
      }
      if (eachStudent instanceof StudentAssistant) {
        returnStatement += ((StudentAssistant) eachStudent).getDirectoryEntry() + "\n";
      }
    }
    return returnStatement;
  }

  public List<Computer> getComputers() {
    return computers;
  }
}
