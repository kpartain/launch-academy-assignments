package com.launchacademy.games;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

@WebServlet(urlPatterns = {"/games/new", "/games", "/"})
public class GamesController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        if(req.getServletPath().equals("/games/new")) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/views/games/new.jsp");
            dispatcher.forward(req, resp);
        }
        else if(req.getServletPath().equals("/") || req.getServletPath().equals("/games")) {
            EntityManager em = getEmf().createEntityManager();
            try {
                GameService gameService = new GameService(em);
                req.setAttribute("games", gameService.findAll());

            }
            finally {
                em.close();
            }

            RequestDispatcher dispatcher = req.getRequestDispatcher("/views/games/index.jsp");
            dispatcher.forward(req, resp);
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if(req.getServletPath().equals("/games")) {
            Game game = new Game();
            try {
                BeanUtils.populate(game, req.getParameterMap());
            }
            catch(IllegalAccessException ex) {
                System.out.println(ex.getMessage());
            }
            catch(InvocationTargetException ex) {
                System.out.println(ex.getMessage());
            }
            EntityManagerFactory emf = getEmf();
            EntityManager em = emf.createEntityManager();

            try {
                em.getTransaction().begin();
                em.persist(game);
                em.getTransaction().commit();
            }
            catch(Exception exc) {
                //an error occurred with the INSERT so return false
                em.getTransaction().rollback();
            }
            resp.sendRedirect("/games");
            em.close();
        }
        else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    private EntityManagerFactory getEmf() {
        return (EntityManagerFactory)this.getServletContext().getAttribute("emf");
    }
}