package UI;


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
 * Created by Marthin on 2016-10-02.
 */
@WebServlet(name = "AddToCartServlet", urlPatterns = {"/addToCart"})
public class AddToCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        if(session.getAttribute("role")!=null) {
            ArrayList<String> cartItems = new ArrayList<>();
            if (session.getAttribute("cartItems") == null) {
                cartItems.add(request.getParameter("cartItem"));
                session.setAttribute("cartItems", cartItems);
            } else {
                cartItems = (ArrayList<String>) session.getAttribute("cartItems");
                cartItems.add(request.getParameter("cartItem"));
                session.setAttribute("cartItems", cartItems);
            }
            response.sendRedirect("/cars.jsp");
        }
    }
}
