package UI;

import BO.Models.Test;
import DB.DatabaseException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by Scalman on 30/09/16.
 */
@WebServlet(description = "Login", urlPatterns = {"/AuthenticationServlet"})
public class AuthenticationServlet extends HttpServlet implements javax.servlet.Servlet{

    Test test;

    public AuthenticationServlet() throws NamingException {
        test = new Test();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){

        //Adds new user
        /*try {
            test.addNewUser(req.getParameter("usr-name"),req.getParameter("password"),req.getParameter("confirm-password"));
        } catch (DatabaseException e) {
            e.printStackTrace();
        }*/

        //Checks if user exist
         test.getUserWithReqName(new Subscriber(req.getParameter("usr-name"),
                req.getParameter("password"),req.getParameter("confirm-password")));
        //req.setAttribute();
        //req.getRequestDispatcher("apa.jsp").forward(req,resp);

    }

}
