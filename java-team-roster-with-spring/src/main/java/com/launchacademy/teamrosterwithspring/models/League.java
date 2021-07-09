package com.launchacademy.teamrosterwithspring.models;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class League {
  private List<Team> teams;

  public void setTeams(List<Team> teams) {
    this.teams = teams;
  }

  public League() {
    this.teams = new ArrayList<Team>();
  }

  public void addTeam(Team team) {
    teams.add(team);
  }

  public static League getLeague() {
    return theLeague;
  }

  public List<Team> getTeams() {
    return teams;
  }
}

