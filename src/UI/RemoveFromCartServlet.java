package UI;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Marthin on 2016-10-05.
 */
@WebServlet(name = "RemoveFromCartServlet", urlPatterns = {"/removeFromCart"})
public class RemoveFromCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        if(session.getAttribute("role")!=null) {
            ArrayList<String> cartItems = (ArrayList<String>) session.getAttribute("cartItems");
            cartItems.remove(request.getParameter("itemToRemove"));
            if(cartItems.isEmpty()){
                session.removeAttribute("cartItems");
            } else {
                session.setAttribute("cartItems", cartItems);
            }
            response.sendRedirect("/getCartItems");
        }
    }
}
