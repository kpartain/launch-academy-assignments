package com.launchacademy.rosters.controllers;

import com.launchacademy.rosters.models.League;
import com.launchacademy.rosters.models.Player;
import com.launchacademy.rosters.models.Team;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/","teams"})
public class TeamsController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        League league = League.getLeague();
        List<Team> teams = league.getTeams();
        String teamIndex = req.getParameter("teamIndex");
        if(teamIndex != null){
            int teamIndex = Integer.parseInt(teamIndex);
            Team team = teams.get(index);
            req.setAttribute("team", team);
            List<Player> players = team.getPlayers();
            req.setAttribute("players", players);
            RequestDispatcher dispatcher = req.getRequestDispatcher("views/teams/show.jsp");
        } else {
            req.setAttribute("teams", teams);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/views/teams/index.jsp");
            dispatcher.forward(req, resp);
        }

    }
}
