import java.util.ArrayList;

public class CreditReelRunner {
  public static void main(String[] args) {

    CastMember castMember1 = new CastMember("Molly", "Parker", "Maureen Robinson");
    CastMember castMember2 = new CastMember("Toby", "Stephens","John Robinson");
    CastMember castMember3 = new CastMember("Maxwell", "Jenkins", "Will Robinson");
    Producer producer1 = new Producer("Neil Marshall");
    Producer producer2 = new Producer("Zack Estrin");
    ArrayList<TeamMember> members = new ArrayList<TeamMember>();
    members.add(castMember1);
    members.add(castMember2);
    members.add(castMember3);
    members.add(producer1);
    members.add(producer2);

    for(TeamMember member : members) {
      //Output each team members credit line
      System.out.println(member.getCreditLine());
    }
  }

}
