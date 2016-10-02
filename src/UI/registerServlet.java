package UI;

import BO.RegisterUser;
import DB.DatabaseException;
import UI.Models.UiUser;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        RequestDispatcher rd;
        RegisterUser regusr = null;
        UiUser user = new UiUser(request.getParameter("username"), request.getParameter("password"),request.getParameter("email"));
        try {
            regusr = new RegisterUser();
        } catch (NamingException e) {
            request.setAttribute("message", "naming error");
        }
        try {
            regusr.register(user);
            rd = request.getRequestDispatcher("carshop/login.jsp");
            rd.forward(request, response);
        } catch (DatabaseException e) {
            request.setAttribute("message", e.getMessage());
        }
        rd = request.getRequestDispatcher("carshop/register.jsp");
        rd.include(request, response);
    }
}
