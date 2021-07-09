package com.launchacademy.teamrosterwithspring.seeders;

import com.launchacademy.teamrosterwithspring.models.League;
import com.launchacademy.teamrosterwithspring.models.Player;
import com.launchacademy.teamrosterwithspring.models.Position;
import com.launchacademy.teamrosterwithspring.models.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class LeagueSeeder implements CommandLineRunner {
    private LeagueRepository leagueRepository;
    private TeamRepository teamRepository;
    private PlayerRepository playerRepository;
    private PositionsRepository positionsRepository;

    @Autowired
    public LeagueSeeder(LeagueRepository leagueRepository, TeamRepository teamRepository, PlayerRepository playerRepository, PositionsRepository positionsRepository) {
        this.leagueRepository = leagueRepository;
        this.teamRepository = teamRepository;
        this.playerRepository = playerRepository;
        this.positionsRepository = positionsRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        //1: create the positions
        Position skip = new Position();
        skip.setName("Skip");
        Position third = new Position();
        third.setName("Third");
        Position second = new Position();
        second.setName("Second");
        Position lead = new Position();
        lead.setName("Lead");
        Position alternate = new Position();
        alternate.setName("Alternate");

        List<Position> positionsObjects = new ArrayList<Position>();
        positionsObjects.add(skip);
        positionsObjects.add(third);
        positionsObjects.add(second);
        positionsObjects.add(lead);
        positionsObjects.add(alternate);
        for(Position positionObject : positionObjects) {
            List<Position> positionsInDB = positionsRepository.findAll();
            if(!positionsInDB.contains(positionObject)) {
                positionsRepository.save(positionObject);
            }
        }

        //2. create the players (player name, point to a position object
        //3: create the teams (country names, blank list of player objects)
//        norway
        Team norway = new Team();
        norway.setTeamName("Norway");
        //players
        Player nw1 = new Player();
        nw1.setName("Thomas Ulsrud");
        nw1.setPosition(skip);
        Player nw2 = new Player();
        nw2.setName("Torger Nergård");
        nw2.setPosition(third);
        Player nw3 = new Player();
        nw1.setName("Christoffer Svae");
        nw2.setPosition(second);
        Player nw4 = new Player();
        nw4.setName("Håvard Vad Petersson");
        nw2.setPosition(lead);
        Player nw5 = new Player();
        nw5.setName("Markus Høiberg");
        nw2.setPosition(alternate);
        List<Player> nwPlayers = Arrays.asList(nw1, nw2, nw3, nw4, nw5);
        norway.setPlayers(nwPlayers);
//        south korea
        Team southKorea = new Team();
        southKorea.setTeamName("South Korea");
        //players
        Player sk1 = new Player();
        sk1.setName("Kim Chang-min");
        sk1.setPosition(skip);
        Player sk2 = new Player();
        sk2.setName("Seong Se-hyeon");
        sk2.setPosition(third);
        Player sk3 = new Player();
        sk3.setName("Oh Eun-su");
        sk3.setPosition(second);
        Player sk4 = new Player();
        sk4.setName("Lee Ki-bok");
        sk4.setPosition(lead);
        Player sk5 = new Player();
        sk5.setName("Kim Min-chan");
        sk5.setPosition(alternate);
        List<Player> skPlayers = Arrays.asList(sk1, sk2, sk3, sk4, sk5);
        southKorea.setPlayers(skPlayers);
//        sweden
        Team sweden = new Team();
        sweden.setTeamName("Sweden");
        //players
        Player sw1 = new Player();
        sw1.setName("Niklas Edin");
        sw1.setPosition(skip);
        Player sw2 = new Player();
        sw2.setName("Oskar Eriksson");
        sw2.setPosition(third);
        Player sw3 = new Player();
        sw3.setName("Rasmus Wranå");
        sw3.setPosition(second);
        Player sw4 = new Player();
        sw4.setName("Christoffer Sundgren");
        sw4.setPosition(lead);
        Player sw5 = new Player();
        sw5.setName("Henrik Leek");
        sw5.setPosition(alternate);
        List<Player> swPlayers = Arrays.asList(sw1, sw2, sw3, sw4, sw5);
        sweden.setPlayers(swPlayers);
//        switzerland
        Team switzerland = new Team();
        switzerland.setTeamName("Switzerland");
        //players
        Player sz1 = new Player();
        sz1.setName("Benoît Schwarz");
        sz1.setPosition(skip);
        Player sz2 = new Player();
        sz2.setName("Claudio Pätz");
        sz2.setPosition(third);
        Player sz3 = new Player();
        sz3.setName("Peter de Cruz");
        sz3.setPosition(second);
        Player sz4 = new Player();
        sz4.setName("Valentin Tanner");
        sz4.setPosition(lead);
        Player sz5 = new Player();
        sz5.setName("Dominik Märki");
        sz5.setPosition(alternate);
        List<Player> szPlayers = Arrays.asList(sz1, sz2, sz3, sz4, sz5);
        switzerland.setPlayers(szPlayers);
//        united states
        Team unitedStates = new Team();
        unitedStates.setTeamName("UnitedStates");
        //players
        Player us1 = new Player();
        us1.setName("John Shuster");
        us1.setPosition(skip);
        Player us2 = new Player();
        us2.setName("Tyler George");
        us2.setPosition(third);
        Player us3 = new Player();
        us3.setName("Matt Hamilton");
        us3.setPosition(second);
        Player us4 = new Player();
        us4.setName("John Landsteiner");
        us4.setPosition(lead);
        Player us5 = new Player();
        us5.setName("Joe Polo");
        us5.setPosition(alternate);
        List<Player> usPlayers = Arrays.asList(us1, us2, us3, us4, us5);
        unitedStates.setPlayers(usPlayers);
//       array of teals
        List<Team> listOfAllTeams = Arrays.asList(norway, southKorea, sweden, switzerland, unitedStates);
//       create a league of teams (league name, blank list of team objects)
        League league = new League();
        league.setTeams(listOfAllTeams);
    }





}
