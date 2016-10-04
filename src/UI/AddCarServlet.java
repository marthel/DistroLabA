package UI;

import BO.CarHandler;
import DB.DatabaseException;
import UI.Models.UiCar;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Scalman on 04/10/16.
 */

@WebServlet(name = "AddCarServlet", urlPatterns = {"/addCars"})
public class AddCarServlet extends HttpServlet{


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        if (request.getParameter("add_year").isEmpty() || request.getParameter("add_quantity").isEmpty() ||
                request.getParameter("add_price").isEmpty() || request.getParameter("add_price").isEmpty()){
            response.sendRedirect("/cars.jsp");
        }

        try {
            CarHandler ch = new CarHandler();

            ch.addCar(new UiCar(request.getParameter("add_manufacturer").toUpperCase(),request.getParameter("add_carModel"),
                    request.getParameter("add_year"),Integer.parseInt(request.getParameter("add_quantity")),
                    Integer.parseInt(request.getParameter("add_price"))));
            response.sendRedirect("/cars.jsp");
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (DatabaseException e) {
            e.printStackTrace();
        }


    }
}
