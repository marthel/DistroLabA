package UI;

import BO.Authentication;
import BO.CarHandler;
import DB.DatabaseException;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Marthin on 2016-10-02.
 */
@WebServlet(name = "GetCarsServlet", urlPatterns = {"/getCars"})
public class GetCarsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        RequestDispatcher rd;
        CarHandler carHandler = null;
        try {
            carHandler = new CarHandler();
        } catch (NamingException e) {
            request.setAttribute("error", "naming error");
        }

        try {
            request.setAttribute("carList", carHandler.findAllCars());
        } catch (DatabaseException e) {
            request.setAttribute("error", e.getMessage());
        }
    }
}
