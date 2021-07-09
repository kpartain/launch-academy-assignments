import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

@WebServlet(urlPatterns = "/hello")
public class MyFirstServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    String firstName = req.getParameter("first_name");
    String lastName = req.getParameter("last_name");
    String fullName = firstName + " " + lastName;
    String greeting = "Hello from a servlet backed JSP";
    if(req.getParameter("lang")  == null || req.getParameter("lang") == "en" || req.getParameter("lang").isBlank() || req.getParameter("lang").isEmpty() ) {
      greeting = "Hello from a servlet backed JSP";
    }
    else if(req.getParameter("lang").equals("fr")) {
      greeting = "Bounjour from a servlet backed JSP";
    }
    else if(req.getParameter("lang").equals("es")) {
      greeting = "Hola from a servlet backed JSP";
    }


    if(firstName != null && lastName != null) {
      greeting += ", " + fullName;
    } else if (firstName != null && lastName == null ) {
      greeting += ", " + firstName;
    } else {
      greeting += ".";
    }

    RequestDispatcher dispatcher = req.getRequestDispatcher("/views/greetings/show.jsp");
    req.setAttribute("greeting", greeting);
    dispatcher.forward(req, resp);
  }
}