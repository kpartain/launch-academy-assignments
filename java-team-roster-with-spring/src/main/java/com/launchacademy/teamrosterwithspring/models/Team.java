package com.launchacademy.teamrosterwithspring.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.launchacademy.teamrosterwithspring.models.Player;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Component
@Table(name = "teams")
public class Team {
    @Id
    @SequenceGenerator(name = "teams_generator", sequenceName = "teams_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teams_generator")
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;

    @Column(name = "team_name", nullable = false)
    private String teamName;

    private List<Player> players;

    public Team() {

        this.players = new ArrayList<Player>();
    }


    public void addPlayer(Player player) {
        this.players.add(player);
    }
}

