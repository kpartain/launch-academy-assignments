package com.launchacademy.launchrpg.repositories;

import com.launchacademy.launchrpg.models.Archetype;
import com.launchacademy.launchrpg.models.PlayerCharacter;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArchetypeRepository extends CrudRepository<Archetype, Integer> {
    List<Archetype> findAll();
}
