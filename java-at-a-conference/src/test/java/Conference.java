import java.util.ArrayList;

public class Conference {
  private String name;
  private int maxRegistrants;
  private ArrayList<Person> attendees;
  private ArrayList<Session> sessions;

  public Conference(String name, int maxRegistrants) {
    this.name = name;
    this.maxRegistrants = maxRegistrants;
    this.attendees = new ArrayList<Person>(this.maxRegistrants);
    this.sessions = new ArrayList<Session>();
  }

  public int getMaxRegistrants() {
    return maxRegistrants;
  }

  public String getName() {
    return name;
  }

  public ArrayList getAttendees(){
    return this.attendees;
  }

  public ArrayList getSessions() {
    return this.sessions;
  }

  public boolean register(Person person) {
    String checkForThisEmail = person.getEmail();
    Boolean isAlreadyRegistered = false;
    Boolean returnThis = false;
    for (Person registrant : attendees) {
      String checkRegisteredEmail = registrant.getEmail();
      if (checkRegisteredEmail == checkForThisEmail) {
        isAlreadyRegistered = true;
        returnThis = false;
      }
    }
    if (this.maxRegistrants > this.attendees.size() && isAlreadyRegistered == false) {
      this.attendees.add(person);
      returnThis = true;
    } else if(this.maxRegistrants == this.attendees.size()){
      returnThis = false;
    }
    return returnThis;
  }

  public boolean addSession(Session session) {
    int startingLength = this.sessions.size();
    this.sessions.add(session);
    if(this.sessions.size() == startingLength + 1) {
      return true;
    } else {
      return false;
    }
  }

  public boolean size(){
    Boolean returnMe = false;
    if(this.maxRegistrants == this.attendees.size()) {
      returnMe = true;
    } else {
      returnMe = false;
    }
    return returnMe;
  }

  public String getSummary() {
    StringBuilder builder = new StringBuilder();
    builder.append(this.getName());
    builder.append("Number of Attendees: " + this.getSessions().size() + " ");
    for(Person registeredPerson : this.attendees) {
      builder.append(registeredPerson.getFirstName() + " " + registeredPerson.getLastName() + " ");
    }
    for(Session scheduledSessions : this.sessions) {
      builder.append(scheduledSessions.getName() + ", facilitated by " + scheduledSessions.getFacilitator().getFirstName() + " " + scheduledSessions.getFacilitator().getLastName());
    }
    String conferenceSummary = builder.toString();
    return conferenceSummary;
  }
}
