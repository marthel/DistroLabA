package UI;

import BO.CarHandler;
import DB.DatabaseException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Scalman on 03/10/16.
 */
@WebServlet(name = "RemoveCars", urlPatterns = {"/removeCar"})
public class RemoveCars extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        if(session.getAttribute("role").equals("admin")) {
            try {
                CarHandler carHandler = new CarHandler();
                carHandler.removeCar(request.getParameter("carModel"));

            } catch (NamingException e) {
                request.setAttribute("error", "Already removed");
            } catch (DatabaseException e) {
                request.setAttribute("error", e.getMessage());
            }

            response.sendRedirect("/cars.jsp");

        }
    }
}
