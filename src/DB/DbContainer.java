package DB;

import BO.Models.Car;
import BO.Models.Order;
import DB.Contracts.CarContract;
import DB.Contracts.CustomerContract;
import DB.Contracts.OrderContract;
import DB.DBM.DbCar;
import DB.DBM.DbOrder;
import DB.DBM.DbUser;
import UI.NewSubscriber;

import javax.naming.NamingException;
import java.util.ArrayList;

/**
 * Created by Marthin on 2016-09-27.
 */
public class DbContainer implements CustomerContract,CarContract,OrderContract {
    private DbConnPool getConnection;
    public DbContainer() throws NamingException {
        getConnection = new DbConnPool();
    }

    //----------------------DbCar---------------------
    @Override
    public ArrayList<Car> getAllCars() throws DatabaseException {
        return DbCar.getAllCars(getConnection.connect());
    }
    @Override
    public void addManufacturer(String manufacturer) throws DatabaseException {
        DbCar.addManufacturer(getConnection.connect(),manufacturer);
    }

    @Override
    public void addCarDescription(int carID,String description) throws DatabaseException {
        DbCar.addCarDescription(getConnection.connect(),carID,description);
    }
    @Override
    public ArrayList<Car> findCarsByManufacturer(String manufacturer) throws DatabaseException {
        return DbCar.findCarsByManufacturer(getConnection.connect(),manufacturer);
    }

    @Override
    public Car getCarByModel(String model) throws DatabaseException {
        return null;
    }

    //----------------------DbUser---------------------
    @Override
    public void addSubscriber(NewSubscriber subscriber) throws DatabaseException{
        DbUser.addSubscriber(getConnection.connect(),subscriber);
    }
    //TODO Get subscriber men måste typ göra en session eller något så att vi vet vem som är vem
    //----------------------DbOrder---------------------
    @Override
    public void createOrder(ArrayList<Order> orders) throws DatabaseException {
        DbOrder.createOrders(getConnection.connect(),orders);
    }

    public ArrayList<Order> getOrders()throws DatabaseException{
        return DbOrder.getOrders(getConnection.connect());
    }
}
