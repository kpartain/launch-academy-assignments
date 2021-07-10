package com.launchacademy.dogbook;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;

@Entity
@Table(name="dogs")
public class Dog {
  public Dog(){

  }
  @Id
  @SequenceGenerator(name="dog_generator", sequenceName = "dogs_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="dog_generator")
  @Column(name="id", nullable=false, unique=true)
  private Long id;

//  @NotEmpty
  @Column(name="first_name", nullable=false)
  private String firstName;

//  @NotEmpty
  @Column(name="last_name", nullable=false)
  private String lastName;
//
//  @NotNull
//  @URL
  @Column(name="photo_url", nullable=false)
  private String photoUrl;

//  @NotEmpty
  @ManyToOne
  @JoinColumn(name="breed", nullable=false)
  private Breed breed;

//  @NotEmpty
  @Column(name="sex", nullable=false)
  private String sex;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getPhotoUrl() {
    return photoUrl;
  }

  public void setPhotoUrl(String photoUrl) {
    this.photoUrl = photoUrl;
  }

  public Breed getBreed() {
    return breed;
  }

  public void setBreed(Breed breed) {
    this.breed = breed;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }
}