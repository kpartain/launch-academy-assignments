// MyFirstServlet.java
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

    String greeting = "Hello from a servlet backed JSP";
    String firstName = req.getParameter("first_name");
    if(firstName != null && firstName != "") {
      greeting += ", " + firstName;
    }

    RequestDispatcher dispatcher = req.getRequestDispatcher("/views/greetings/show.jsp");
    req.setAttribute("greeting", greeting);
    dispatcher.forward(req, resp);
  }
}