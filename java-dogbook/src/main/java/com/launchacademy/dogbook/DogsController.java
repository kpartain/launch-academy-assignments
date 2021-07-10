package com.launchacademy.dogbook;

import org.apache.commons.beanutils.BeanUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Cookie;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@WebServlet(urlPatterns = {"/dogs/new", "/dogs"})
public class DogsController extends HttpServlet {
    //doGet
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String routeBreed = req.getParameter("breed");
        if (req.getServletPath().equals("/dogs/new")) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/views/dogs/form.jsp");
            dispatcher.forward(req, resp);
        } else if (req.getServletPath().equals("/dogs")) {
            EntityManager em = getEmf().createEntityManager();
            req.setAttribute("dogCookie", req.getSession().getAttribute("dogCookieHere"));
            try {
                DogService service = new DogService(em);
                List<Dog> dogs = service.findAll();
                req.setAttribute("dogs", dogs);
                RequestDispatcher dispatcher = req.getRequestDispatcher("/views/dogs/index.jsp");
                dispatcher.forward(req, resp);
            } finally {
                em.close();
            }
        }
        else if(routeBreed != null) {
                EntityManager em2 = getEmf().createEntityManager();
                String breedFromHeader = req.getParameter("breed");
                String breedCheck = "Select b FROM Breed b WHERE breedName = :breedName";
                Query breedCheckCategoryQuery = em2.createQuery(breedCheck, Breed.class);
                breedCheckCategoryQuery.setParameter("breedName", breedFromHeader);
                List<Dog> allDogsInBreed = breedCheckCategoryQuery.getResultList();
                req.setAttribute("allDogsInBreed", allDogsInBreed);
                RequestDispatcher dispatcher = req.getRequestDispatcher("/views/dogs/show.jsp");
                dispatcher.forward(req, resp);
                em2.close();
            }
            else {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            }
    }
    //doPost
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if (req.getServletPath().equals("/dogs")) {
            Dog dog = new Dog();
            HttpSession session = req.getSession();
            dog.setFirstName(req.getParameter("firstName"));
            dog.setLastName(req.getParameter("lastName"));
            dog.setPhotoUrl(req.getParameter("photoUrl"));
            EntityManager em = getEmf().createEntityManager();
            String breedFromHeaderS = req.getParameter("breed");
            String breedCheck = "Select b FROM Breed b WHERE breedName = :breedName";
            Query breedCheckCategoryQuery = em.createQuery(breedCheck, Breed.class);
            breedCheckCategoryQuery.setParameter("breedName", breedFromHeaderS);
            List<Breed> retrievedBreeds = breedCheckCategoryQuery.getResultList();
            if(retrievedBreeds.size() > 0) {
                dog.setBreed(retrievedBreeds.get(0));
            } else {
                Breed breed = new Breed();
                breed.setBreedName(breedFromHeaderS);
                em.persist(breed);
                dog.setBreed(breed);
            }
            dog.setSex(req.getParameter("sex"));
            session.setAttribute("dogCookieHere", dog.getFirstName());
            DogService service = new DogService(em);
            if (!service.save(dog)) {
                System.out.println("DoPost Error - did not save");
            }
            resp.sendRedirect("/dogs");
            em.close();
        }
    }
    //emf method
    private EntityManagerFactory getEmf(){
        return (EntityManagerFactory)this.getServletContext().getAttribute("emf");
    }
}
