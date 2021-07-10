package com.launchacademy.dogbook;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class DogService {
    private EntityManager em;

    public DogService(EntityManager em) {
        this.em = em;
    }
    //list all
    public List<Dog> findAll() {
        TypedQuery<Dog> query = em.createQuery("Select d from Dog d ORDER BY lastName, firstName ASC", Dog.class);
        List<Dog> dogs = query.getResultList();
        return dogs;
    }
    //save one dog
    public boolean save(Dog dog) {
        try {
            em.getTransaction().begin();
            em.persist(dog);
            em.getTransaction().commit();
            return true;
        } catch (Exception exception){
            em.getTransaction().rollback();
            return false;
        }
    }

}
