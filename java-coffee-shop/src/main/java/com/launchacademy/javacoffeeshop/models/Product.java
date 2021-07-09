package com.launchacademy.javacoffeeshop.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class Product {
  @Getter @Setter private Integer id;
  @Getter @Setter private String name;
  @Getter @Setter private String description;
  @Getter @Setter private Double price;
  @Getter @Setter private Integer caffeineRating;
}
