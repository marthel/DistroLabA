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
 * Created by Scalman on 03/10/16.
 */
@WebServlet(name = "GetCartItemsServlet", urlPatterns = {"/getCartItems"})
public class GetCartItemsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        CarHandler carHandler = null;
        HttpSession session = request.getSession();
        ArrayList<UiCar> cars = new ArrayList<>();



        if (session.getAttribute("cartItems") == null){
            request.setAttribute("error","No Items in Cart");
            request.getRequestDispatcher("/cart.jsp").include(request,response);
        }

        try {
            carHandler = new CarHandler();
            cars = carHandler.getCartItems((ArrayList<String>) session.getAttribute("cartItems"));
        } catch (NamingException e) {
            request.setAttribute("error","naming error");
        } catch (DatabaseException e) {
            request.setAttribute("error",e.getMessage());
        }

        request.setAttribute("cItems",cars);
        session.setAttribute("sCars",cars);
        request.getRequestDispatcher("/cart.jsp").include(request,response);


    }
}
