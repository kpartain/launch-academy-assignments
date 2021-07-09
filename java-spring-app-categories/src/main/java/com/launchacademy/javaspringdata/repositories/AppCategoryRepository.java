package com.launchacademy.javaspringdata.repositories;

import com.launchacademy.javaspringdata.models.AppCategory;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface AppCategoryRepository extends CrudRepository<AppCategory, Integer> {
    public List<AppCategory> findAllByName(String name);
}
