package UI;

import BO.CarHandler;
import BO.OrderHandler;
import DB.DatabaseException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "GetOrdersServlet", urlPatterns = {"/getOrders"})
public class GetOrdersServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        OrderHandler orderHandler = null;
        HttpSession session = request.getSession();
        if(session.getAttribute("role").equals("employee")) {
            try {
                orderHandler = new OrderHandler();
            } catch (NamingException e) {
                request.setAttribute("error", "naming error");
            }
            try {
                request.setAttribute("orderList", orderHandler.findAllOrders());
            } catch (DatabaseException e) {
                request.setAttribute("error", e.getMessage());
            }
        }
    }
}
