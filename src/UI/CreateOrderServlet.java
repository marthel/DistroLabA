package UI;

import BO.OrderHandler;
import BO.RegisterUser;
import DB.DatabaseException;
import UI.Models.UiCar;
import UI.Models.UiOrder;
import UI.Models.UiUser;

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
import java.sql.Date;
import java.util.Calendar;

/**
 * Created by Marthin on 2016-10-03.
 */
@WebServlet(name = "CreateOrderServlet", urlPatterns = {"/createOrder"})
public class CreateOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        RequestDispatcher rd;
        HttpSession session = request.getSession();
        OrderHandler orderHandler = null;
        UiOrder order;
        if(session.getAttribute("role")!=null) {
            ArrayList<UiCar> cars = (ArrayList<UiCar>) session.getAttribute("sCars");
            request.getSession().removeAttribute("sCars");

            String username = (String) session.getAttribute("username");
            Calendar calendar = Calendar.getInstance();
            Date oDate = new Date(calendar.getTime().getTime());
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");
            order = new UiOrder(oDate, cars, firstName, lastName, phone, address, username);

            try {
                orderHandler = new OrderHandler();
            } catch (NamingException e) {
                request.setAttribute("error", "naming error");
            }

            try {
                orderHandler.createOrder(order);
                session.removeAttribute("cartItems");
            } catch (DatabaseException e) {
                request.setAttribute("error", e.getMessage());
            }
        }
    }
}
