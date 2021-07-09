package com.launchacademy.orders.controllers;

import com.launchacademy.orders.models.Order;
import com.launchacademy.orders.services.OrderService;
import org.apache.commons.beanutils.BeanUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@WebServlet(urlPatterns = {"/orders/new", "/orders"})
public class OrdersController extends HttpServlet {
        @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException{
        String orderIndex = req.getParameter("orderId");
        if(req.getServletPath().equals("/orders/new")) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/views/orders/form.jsp");
            dispatcher.forward(req, resp);
        }
        if (req.getServletPath().equals("/orders")) {
            EntityManagerFactory emf = getEmf();
            EntityManager em = emf.createEntityManager();
            try {
                OrderService orderService = new OrderService(em);
                List<Order> orders = orderService.findAll();
                if (orders.isEmpty()) {
                    resp.sendError(HttpServletResponse.SC_NOT_FOUND);
                } else {
                    req.setAttribute("orders", orders);
                    RequestDispatcher dispatcher = req.getRequestDispatcher("/views/orders/index.jsp");
                    dispatcher.forward(req, resp);
                }
            }
            finally {
                em.close();
                emf.close();
            }
        }
        if(orderIndex != null) {
            Long longIndex = Long.parseLong(orderIndex);
            EntityManagerFactory emf = getEmf();
            EntityManager em = emf.createEntityManager();
            try {
                OrderService orderService = new OrderService(em);
                Order order = orderService.findById(longIndex);
                if(order == null) {
                    resp.sendError(HttpServletResponse.SC_NOT_FOUND);
                } else {
                    req.setAttribute("orders", order);
                    RequestDispatcher dispatcher = req.getRequestDispatcher("/views/orders/show.jsp");
                    dispatcher.forward(req, resp);
                }
            }
            finally{
                em.close();
                emf.close();
            }
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if (req.getServletPath().equals("/orders/new")) {
            Order order = new Order();
            try {
                BeanUtils.populate(order, req.getParameterMap());
            } catch (IllegalAccessException ex) {
                System.out.println(ex.getMessage());
            } catch (InvocationTargetException ex) {
                System.out.println(ex.getMessage());
            }
            EntityManagerFactory emf = getEmf();
            EntityManager em = emf.createEntityManager();
            try {
                OrderService service = new OrderService(em);
                if (service.save(order)) {
                    resp.sendRedirect("/orders/new");
                } else {
                    resp.sendError(HttpServletResponse.SC);
                }
            } finally {
                em.close();
                emf.close();
            }
        }
    }

    private EntityManagerFactory getEmf() {
        return (EntityManagerFactory)this.getServletContext().getAttribute("emf");
    }
}
