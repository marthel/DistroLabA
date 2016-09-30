package UI;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by Scalman on 30/09/16.
 */
@WebServlet(description = "login", urlPatterns = {"/ServletContainer"})
public class ServletContainer extends HttpServlet implements javax.servlet.Servlet{


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("User: " + req.getParameter("password"));
        //req.setAttribute();
        //req.getRequestDispatcher("apa.jsp").forward(req,resp);

    }
}
