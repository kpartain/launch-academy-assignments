package com.launchacademy.javaspringdata.repositories;

import com.launchacademy.javaspringdata.models.Idea;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface IdeaRepository extends CrudRepository<Idea, Integer> {
  public List<Idea> findAllByName(String name);

//  Return all Ideas
  public List<Idea> findAll();

//  Return a specific Idea by id
  public Idea findById(int id);

//  Return a specific Idea by name
  public Idea findByName(String name);

//  Return an Idea which doesn't contain the word "Facebook"
  public Idea findByNameNotContainingFacebook();

//  Return all Ideas that start with "Cat"
  public List<Idea> findAllByNameStartingWithCat();

//  For an extra challenge figure out how to make this work with "Cat" or "cat" using a JPA query-method
  public List<Idea> findAllByNameStartWithCatIgnoreCase();

//  Return all Ideas that end with "book"
  public List<Idea> findAllByNameEndingWithBook();


//  @Query("SELECT i from Idea i where i.name like :namePrefix%")
//  public Idea whereNameStartsWith(@Param("namePrefix") String namePrefix);

}