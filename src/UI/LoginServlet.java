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
            auth = new Authentication(user);
        } catch (NamingException e) {
            request.setAttribute("message", "naming error");
        }

        try {
            user = auth.authenticate();
            session.setAttribute("username", user.getUsername());
            session.setAttribute("password", user.getPassword());
            session.setAttribute("role", user.getRole());
            request.setAttribute("message", "inloggad som ");
            request.setAttribute("user", user);
            rd = request.getRequestDispatcher("carshop/news.jsp");
            rd.forward(request, response);
        } catch (DatabaseException e) {
            request.setAttribute("message", e.getMessage());
        }
        rd = request.getRequestDispatcher("carshop/login.jsp");
        rd.include(request, response);
    }
}
