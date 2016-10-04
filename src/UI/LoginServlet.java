package UI;

import BO.Authentication;
import DB.DatabaseException;
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

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        response.setContentType("text/html");
        HttpSession session = request.getSession();
        RequestDispatcher rd;
        UiUser user = new UiUser(request.getParameter("username"), request.getParameter("password"));

        Authentication auth = null;
        try {
            auth = new Authentication();
        } catch (NamingException e) {
            request.setAttribute("error", "naming error");
        }
        try {
            user = auth.authenticate(user);
            session.setAttribute("username", user.getUsername());
            session.setAttribute("password", user.getPassword());
            session.setAttribute("role", user.getRole());
            if(user.getRole().equals("employee")){
                response.sendRedirect("/orders.jsp");
            } else {
                response.sendRedirect("/cars.jsp");
            }

        } catch (DatabaseException e) {
            request.setAttribute("error", e.getMessage());
        }
        rd = request.getRequestDispatcher("/login.jsp");
        rd.include(request, response);
    }
}
