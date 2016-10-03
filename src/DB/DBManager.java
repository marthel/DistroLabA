package DB;

import BO.Models.Car;
import BO.Models.Order;
import BO.Models.OrderDetail;
import BO.Models.User;
import DB.Contracts.CarContract;
import DB.Contracts.OrderContract;
import DB.Contracts.UserContract;
import DB.DBM.DbCar;
import DB.DBM.DbOrder;
import DB.DBM.DbUser;
import UI.Models.UiOrder;
import UI.Models.UiUser;

import javax.naming.NamingException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Queue;

public class DBManager implements UserContract, CarContract, OrderContract {
    private DbConnPool connPool;

    public DBManager() throws NamingException {
        connPool = new DbConnPool();
    }
    /************** CAR HANDLING **************/
    @Override
    public ArrayList<Car> findAllCars() throws DatabaseException {
        return DbCar.findAllCars(connPool.connect());
    }

    @Override
    public void addCar() throws DatabaseException {
        DbCar.addCar(connPool.connect());
    }

    @Override
    public void addCarDescription(int carID, String description) throws DatabaseException {
        DbCar.addCarDescription(connPool.connect(),carID,description);
    }

    @Override
    public void addManufacturer(String manufacturer) throws DatabaseException {
        DbCar.addManufacturer(connPool.connect(),manufacturer);
    }

    @Override
    public ArrayList<Car> findCarsByManufacturer(String manufacturer) throws DatabaseException {
        return DbCar.findCarsByManufacturer(connPool.connect(), manufacturer);

    }

    @Override
    public Car findCarByModel(String model) throws DatabaseException {
        return DbCar.findCarByModel(connPool.connect(), model);
    }

    /************** USER HANDLING **************/
    @Override
    public void addUser(UiUser user) throws DatabaseException {
        DbUser.addUser(connPool.connect(),user);
    }

    @Override
    public ArrayList<User> findAllUsers() throws DatabaseException {
        return DbUser.findAlUsers(connPool.connect());
    }

    @Override
    public User findUserByUsername(String username) throws DatabaseException {
        return DbUser.findUserByUsername(connPool.connect(),username);
    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) throws DatabaseException {
        return DbUser.findUserByUsernameAndPassword(connPool.connect(),username,password);
    }

    /*************** ORDER HANDLING **************/
    @Override
    public void createOrder(Connection connection, UiOrder order, int userID, ArrayList<OrderDetail> details) throws DatabaseException {
        DbOrder.createOrder(connection, order, userID, details);
    }

    @Override
    public ArrayList<Order> findAllOrders() throws DatabaseException {
        return DbOrder.findAllOrders(connPool.connect());
    }

    @Override
    public ArrayList<Order> findOrdersByUsername(String username) throws DatabaseException {
        return DbOrder.findOrdersByUsername(connPool.connect(),username);
    }

    public Connection getConnection() {
        return connPool.connect();
    }
    @Override
    public Integer findCarIDByModel(Connection connection, String model) throws DatabaseException{
        return DbCar.findCarIDByModel(connection, model);
    }
    @Override
    public void updateCarQuantity(Connection connection, int carID, int quantity) throws DatabaseException {
        DbCar.updateCarQuantity(connection,carID,quantity);
    }
}
