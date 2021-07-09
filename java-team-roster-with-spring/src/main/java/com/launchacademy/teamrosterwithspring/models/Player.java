package com.launchacademy.teamrosterwithspring.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Component
@Table(name="players")
public class Player {
  @Id
  @SequenceGenerator(name = "players_generator", sequenceName = "players_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "players_generator")
  @Column(name = "id", nullable = false, unique = true)
  private Integer id;

  @Column(name = "name", nullable = false)
  private String name;

  //create join to position instead of string
  @Column(name = "position", nullable = false)
  private Position position;


}

