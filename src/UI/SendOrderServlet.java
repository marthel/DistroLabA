package UI;

import BO.Models.Order;
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
@WebServlet(name = "SendOrderServlet", urlPatterns = {"/sendOrder"})
public class SendOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        RequestDispatcher rd;
        HttpSession session = request.getSession();
        OrderHandler orderHandler = null;
        UiOrder order;
        if(session.getAttribute("role").equals("employee")) {

            Calendar calendar = Calendar.getInstance();
            Date sDate = new Date(calendar.getTime().getTime());
            String status = "skickad";
            int ID = Integer.parseInt(request.getParameter("orderID"));
            order = new UiOrder(ID,sDate,status);
            try {
                orderHandler = new OrderHandler();
            } catch (NamingException e) {
                request.setAttribute("error", "naming error");
            }

            try {
                orderHandler.sendOrder(order);
                response.sendRedirect("/orders.jsp");
            } catch (DatabaseException e) {
                request.setAttribute("error", e.getMessage());
           }
        }
    }
}
