package UI;

import BO.CarHandler;
import DB.DatabaseException;
import UI.Models.UiCar;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * Created by Scalman on 03/10/16.
 */

@WebServlet(name = "UpdateShopServlet", urlPatterns = {"/updateShop"})
public class UpdateShopServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();

        if(session.getAttribute("role").equals("admin")) {
            if (request.getParameter("year").isEmpty() || request.getParameter("quantity").isEmpty() ||
                    request.getParameter("price").isEmpty() || request.getParameter("price").isEmpty()) {
                response.sendRedirect("/cars.jsp");
            }

            //System.out.println(request.getParameter("oldModel") + "     " + request.getParameter("carModel"));

            try {
                CarHandler ch = new CarHandler();
                ch.updateCar(new UiCar(request.getParameter("manufacturer"), request.getParameter("carModel"),
                        request.getParameter("year"), Integer.parseInt(request.getParameter("quantity")),
                        Integer.parseInt(request.getParameter("price")), request.getParameter("oldModel")));

            } catch (NamingException e) {
                e.printStackTrace();
            } catch (DatabaseException e) {
                e.printStackTrace();
            }

            response.sendRedirect("/cars.jsp");


        }
    }
}
