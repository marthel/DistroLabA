package DB;

import BO.Models.Car;
import BO.Models.Order;
import BO.Models.User;
import DB.Contracts.CarContract;
import DB.Contracts.OrderContract;
import DB.Contracts.UserContract;
import DB.DBM.DbCar;
import DB.DBM.DbOrder;
import DB.DBM.DbUser;
import UI.Models.UiUser;

import javax.naming.NamingException;
import java.util.ArrayList;

public class DbManager implements UserContract, CarContract, OrderContract {
    private DbConnPool getConnection;

    public DbManager() throws NamingException {
        getConnection = new DbConnPool();
    }
    /************** CAR HANDLING **************/
    @Override
    public ArrayList<Car> findAllCars() throws DatabaseException {
        return DbCar.findAllCars(getConnection.connect());
    }

    @Override
    public void addCar() throws DatabaseException {
        DbCar.addCar(getConnection.connect());
    }

    @Override
    public void addCarDescription(int carID, String description) throws DatabaseException {
        DbCar.addCarDescription(getConnection.connect(),carID,description);
    }

    @Override
    public void addManufacturer(String manufacturer) throws DatabaseException {
        DbCar.addManufacturer(getConnection.connect(),manufacturer);
    }

    @Override
    public ArrayList<Car> findCarsByManufacturer(String manufacturer) throws DatabaseException {
        return DbCar.findCarsByManufacturer(getConnection.connect(), manufacturer);

    }

    @Override
    public Car findCarByModel(String model) throws DatabaseException {
        return DbCar.findCarByModel(getConnection.connect(), model);
    }

    /************** USER HANDLING **************/
    @Override
    public void addUser(UiUser user) throws DatabaseException {
        DbUser.addUser(getConnection.connect(),user);
    }

    @Override
    public ArrayList<User> findAllUsers() throws DatabaseException {
        return DbUser.findAlUsers(getConnection.connect());
    }

    @Override
    public User findUserByUsername(String username) throws DatabaseException {
        return DbUser.findUserByUsername(getConnection.connect(),username);
    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) throws DatabaseException {
        return DbUser.findUserByUsernameAndPassword(getConnection.connect(),username,password);
    }

    /*************** ORDER HANDLING **************/
    @Override
    public void createOrder() throws DatabaseException {
        DbOrder.createOrder(getConnection.connect());
    }

    @Override
    public ArrayList<Order> findAllOrders() throws DatabaseException {
        return DbOrder.findAllOrders(getConnection.connect());
    }

    @Override
    public ArrayList<Order> findOrdersByUsername(String username) throws DatabaseException {
        return DbOrder.findOrdersByUsername(getConnection.connect(),username);
    }


}
