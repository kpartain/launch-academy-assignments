package com.launchacademy.thymeleafViews.repositories;

import org.springframework.data.repository.CrudRepository;

import com.launchacademy.thymeleafViews.models.Trip;

public interface TripRepository extends CrudRepository<Trip, Integer>{

}
