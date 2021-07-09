package com.launchacademy.javaspringdata.models;

import javax.persistence.*;

@Entity
@Table(name = "app_categories")
public class AppCategory {
    @Id
    @SequenceGenerator(name = "app_categories_generator", sequenceName = "app_categories_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="app_categories_generator")
    @Column(name = "id", nullable = false, unique=true)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
