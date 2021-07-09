package com.launchacademy.orders.services;

import com.launchacademy.orders.models.Order;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class OrderService {
    private EntityManager em;

    public OrderService(EntityManager em) {
        this.em = em;
    }

    public boolean save(Order order) {
        try {
            em.getTransaction().begin();
            em.persist(order);
            em.getTransaction().commit();
            return true;
        }
        catch(Exception exc) {
            em.getTransaction().rollback();
            return false;
        }
    }
    public List<Order> findAll() {
        TypedQuery<Order> query = em.createQuery("SELECT o FROM Order o", Order.class);
        return query.getResultList();
    }
    public Order findById(Long orderId){
        String queryString = "SELECT o FROM Order o WHERE id = :id";
        TypedQuery<Order> query = em.createQuery(queryString, Order.class);
        query.setParameter("id", orderId);
        Order order = null;
        try {
            order = query.getSingleResult();
        } catch (Exception exception){
            System.out.println("No matching record");
            order = null;
        }
        return order;
    }
}
