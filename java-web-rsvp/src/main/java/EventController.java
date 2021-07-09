import org.apache.commons.beanutils.BeanUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet(urlPatterns = {"/rsvps/new"})
public class EventController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getServletPath().equals("/rsvps/new")) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/views/form.jsp");

        Event event = new Event();
        try {
            BeanUtils.populate(event, req.getParameterMap());
        } catch (IllegalAccessException err) {
            err.printStackTrace();
        } catch (InvocationTargetException err) {
            err.printStackTrace();
        }
        EntityManagerFactory emf = getEmf();
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(event);
            em.getTransaction().commit();
        } catch (Error e) {
            System.out.println(e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
        resp.sendRedirect("/rsvps/new");
        dispatcher.forward(req, resp);
        }
    }
    private EntityManagerFactory getEmf() {
        return (EntityManagerFactory)this.getServletContext().getAttribute("emf");
    }
}
