package com.launchacademy.teamrosterwithspring.controller;

import com.launchacademy.teamrosterwithspring.models.League;
import com.launchacademy.teamrosterwithspring.models.Player;
import com.launchacademy.teamrosterwithspring.models.Team;
import com.launchacademy.teamrosterwithspring.services.TeamService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequestMapping("/")
public class LeagueController {
    TeamService teamService;

    @Autowired
    public LeagueController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("teams")
    public String getAllTeams(Model model) {
        League league = League.getLeague();
        model.addAttribute("teams", league.getTeams());
        return "teams/index.html";
    }

    @GetMapping("teams/{index}")
    public String getTeamByIndex(@PathVariable Integer index, Model model) {
        League league = League.getLeague();
        if (index <= league.getTeams().size() && index >= 0) {
            model.addAttribute("team", league.getTeams().get(index));
            return "teams/show.html";
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "index out of bounds"
            );
        }
    }

    @GetMapping("positions")
    private String getAllPositions(Model model) {
        List<Player> players = League.getLeague().getTeams().get(0).getPlayers();
        List<String> positions = new ArrayList<String>();
        for (Player player : players) {
            positions.add(player.getPosition());
        }
        model.addAttribute("positions", positions);
        return "positions/index.html";
    }

    @GetMapping("positions/{position}")
    private String getPositionByName(@PathVariable String position, Model model) {
        List<Team> teams = League.getLeague().getTeams();
        List<Player> allPlayers = new ArrayList<>();
        for (Team team : teams) {
            List<Player> players = team.getPlayers();
            for (Player player : players) {
                if (player.getPosition().toLowerCase().equals(position.toLowerCase()))
                    allPlayers.add(player);
            }
        }
        model.addAttribute("teams", teams);
        model.addAttribute("players", allPlayers);
        return "positions/show.html";
    }

    @GetMapping("fantasy/teams/new")
    private String addTeamForm(@ModelAttribute Team team) {

        return "teams/new";
    }

    @PostMapping
    public String addTeamPost(@ModelAttribute Team team) {
        teamService.addToList(team);
        return "teams/show";
    }

    @GetMapping("/fantasy/teams")
    public String getFantasyTeams(Model model) {
        List<Team> fantasyTeams = teamService.getList();
        model.addAttribute("teams", fantasyTeams);
        return "fantasy/index";
    }

    @GetMapping("/fantasy/teams/{index}")
    public String getFantasyTeam(@PathVariable Integer index, Model model) {
        Team team = teamService.getList().get(index);
        model.addAttribute("team", team);
        return "teams/show";
    }

}