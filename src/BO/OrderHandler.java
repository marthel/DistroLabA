package BO;

import BO.Models.Order;
import BO.Models.OrderDetail;
import DB.DBM.DbOrder;
import DB.DBM.DbUser;
import DB.DBManager;
import DB.DatabaseException;
import DB.DbConnPool;
import UI.Models.UiCar;
import UI.Models.UiOrder;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Marthin on 2016-10-03.
 */
public class OrderHandler {
    private DBManager dbManager;
    CarHandler carhandler;
    public OrderHandler() throws NamingException {
        dbManager = new DBManager();
        carhandler = new CarHandler();
    }

    public void createOrder(UiOrder order) throws DatabaseException{
        ArrayList<UiCar> cars = order.getCars();
        ArrayList<OrderDetail> orderDetails;

        Connection connection;
        int userID;
        connection = dbManager.getConnection();
        try {
            connection.setAutoCommit(false);
            userID = DbUser.findUserIdbyUsername(connection, order.getUsername());
            orderDetails = getOrderDetails(connection, cars);
            for (OrderDetail od: orderDetails) {
                carhandler.updateCarQuantity(connection, od.getCarID(), -od.getQuantity());
            }
            DbOrder.createOrder(connection,order, userID, orderDetails);
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            throw new DatabaseException();
        } finally {
            DbConnPool.disconnect(connection);
        }

    }

    private ArrayList<OrderDetail> getOrderDetails(Connection connection, ArrayList<UiCar> cars) throws DatabaseException {
        ArrayList<OrderDetail> orderDetails = new ArrayList<>();
        ArrayList<Integer> carIDs = carhandler.getCarIDs(connection, cars);
        for (int i=0; i<carIDs.size();i++) {
            if(!orderDetailsContainsID(orderDetails,carIDs.get(i))) {
                orderDetails.add(new OrderDetail(carIDs.get(i),1));
            }
        }
        return orderDetails;
    }

    private boolean orderDetailsContainsID(ArrayList<OrderDetail> orderDetails, int ID) {
        for (OrderDetail od: orderDetails) {
            if(od.getCarID()== ID){
                od.setQuantity(od.getQuantity()+1);
                return true;
            }
        }
        return false;
    }
    public ArrayList<Order> findAllOrders() throws DatabaseException{
        return dbManager.findAllOrders();
    }

    public void sendOrder(UiOrder order) throws DatabaseException{
        dbManager.sendOrder(order);
    }
}
