package DB.Contracts;

import BO.Models.Order;
import DB.DatabaseException;
import java.util.ArrayList;

/**
 * Created by Marthin on 2016-09-27.
 */
public interface OrderContract {

    void createOrder()throws DatabaseException;
    ArrayList<Order> findAllOrders()throws DatabaseException;
    ArrayList<Order> findOrdersByUsername(String username)throws DatabaseException;

}
