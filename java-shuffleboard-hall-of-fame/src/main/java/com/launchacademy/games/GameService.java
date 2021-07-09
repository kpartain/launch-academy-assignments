package com.launchacademy.games;

import javax.persistence.EntityManager;
import java.util.List;
import javax.persistence.TypedQuery;

public class GameService {
    private EntityManager em;

    public GameService(EntityManager em) {
        this.em = em;
    }

    public boolean save(Game game) {
        try {
            em.getTransaction().begin();
            em.persist(game);
            em.getTransaction().commit();
            return true;
        }
        catch(Exception exc) {
            //an error occurred with the INSERT so return false
            em.getTransaction().rollback();
            return false;
        }
    }
    public List<Game> findAll() {
        TypedQuery<Game> query = em.createQuery("SELECT g FROM Game g", Game.class);
        return query.getResultList();
    }
}