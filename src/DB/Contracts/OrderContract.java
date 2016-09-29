package DB.Contracts;

import BO.Models.Order;
import DB.DatabaseException;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.ArrayList;

/**
 * Created by Marthin on 2016-09-27.
 */
public interface OrderContract {

    void createOrder(ArrayList<Order> orders)throws DatabaseException;



}
