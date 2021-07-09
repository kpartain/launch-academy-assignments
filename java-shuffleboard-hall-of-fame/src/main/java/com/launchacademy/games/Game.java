package com.launchacademy.games;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="games")
//@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class) but you need maven depdency
public class Game {
    public Game () {

    }
    @Id
    @SequenceGenerator(name="game_generator", sequenceName="games_id_seq", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="game_generator")
    @Column(name="id", nullable=false, unique=true)
    private Long id;

    @Column(name="red_team_player_1", nullable=false)
    private String redTeamPlayerOne;

    @Column(name="red_team_player_2", nullable=false)
    private String redTeamPlayerTwo;

    @Column(name="red_team_score", nullable=false)
    private int redTeamScore;

    @Column(name="blue_team_player_1", nullable=false)
    private String blueTeamPlayerOne;

    @Column(name="blue_team_player_2", nullable=false)
    private String blueTeamPlayerTwo;

    @Column(name="blue_team_score", nullable=false)
    private int blueTeamScore;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRedTeamPlayerOne() {
        return redTeamPlayerOne;
    }

    public void setRedTeamPlayerOne(String redTeamPlayerOne) {
        this.redTeamPlayerOne = redTeamPlayerOne;
    }

    public String getRedTeamPlayerTwo() {
        return redTeamPlayerTwo;
    }

    public void setRedTeamPlayerTwo(String redTeamPlayerTwo) {
        this.redTeamPlayerTwo = redTeamPlayerTwo;
    }

    public int getRedTeamScore() {
        return redTeamScore;
    }

    public void setRedTeamScore(int redTeamScore) {
        this.redTeamScore = redTeamScore;
    }

    public String getBlueTeamPlayerOne() {
        return blueTeamPlayerOne;
    }

    public void setBlueTeamPlayerOne(String blueTeamPlayerOne) {
        this.blueTeamPlayerOne = blueTeamPlayerOne;
    }

    public String getBlueTeamPlayerTwo() {
        return blueTeamPlayerTwo;
    }

    public void setBlueTeamPlayerTwo(String blueTeamPlayerTwo) {
        this.blueTeamPlayerTwo = blueTeamPlayerTwo;
    }

    public int getBlueTeamScore() {
        return blueTeamScore;
    }

    public void setBlueTeamScore(int blueTeamScore) {
        this.blueTeamScore = blueTeamScore;
    }
}
