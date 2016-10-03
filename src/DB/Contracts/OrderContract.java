package DB.Contracts;

import BO.Models.Order;
import BO.Models.OrderDetail;
import DB.DatabaseException;
import UI.Models.UiOrder;

import java.sql.Connection;
import java.util.ArrayList;

/**
 * Created by Marthin on 2016-09-27.
 */
public interface OrderContract {

    void createOrder(Connection connection, UiOrder order, int userID, ArrayList<OrderDetail> details)throws DatabaseException;
    ArrayList<Order> findAllOrders()throws DatabaseException;
    ArrayList<Order> findOrdersByUsername(String username)throws DatabaseException;

}
