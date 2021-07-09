package com.launchacademy.javaspringdata.seeders;

import com.launchacademy.javaspringdata.models.AppCategory;
import com.launchacademy.javaspringdata.repositories.AppCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AppCategorySeeder implements CommandLineRunner {
    private AppCategoryRepository appCategoryRepository;


    @Autowired
    public AppCategorySeeder(AppCategoryRepository appCategoryRepository) {
        this.appCategoryRepository = appCategoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<String> seedList = new ArrayList<String>();
        seedList.add("Social Media");
        seedList.add("Productivity");
        seedList.add("Games");
        seedList.add("Self Help");
        for(String name : seedList) {
            List<AppCategory> allCategories = appCategoryRepository.findAllByName(name);
            if(allCategories.isEmpty()) {
                AppCategory appCategory = new AppCategory();
                appCategory.setName(name);
                appCategoryRepository.save(appCategory);
            }
        }
    }
}
