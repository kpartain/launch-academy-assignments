package com.launchacademy.dogbook;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="breeds")
public class Breed {
    public Breed() {
    }
    @Id
    @SequenceGenerator(name = "breed_generator", sequenceName = "breeds_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "breed_generator")
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;

    @Column(name="breed_name", nullable = false, unique = true)
    private String breedName;

    @OneToMany(mappedBy = "breed")
    private List<Dog> dogs = new ArrayList<Dog>();

    public List<Dog> getDog() {
        return dogs;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBreedName() {
        return breedName;
    }

    public void setBreedName(String breedName) {
        this.breedName = breedName;
    }
}
