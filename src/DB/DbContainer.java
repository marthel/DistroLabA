package DB;

import BO.Models.Car;
import DB.Contracts.CarContract;
import DB.Contracts.CustomerContract;
import DB.Contracts.OrderContract;
import DB.DBM.DbCar;
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
    @Override
    public ArrayList<Car> getAllCars() throws DatabaseException {
        return DbCar.getAllCars(getConnection.connect());
    }

    @Override
    public void addSubscriber(NewSubscriber subscriber) throws DatabaseException{
        DbUser.addSubscriber(getConnection.connect(),subscriber);

    }

    @Override
    public void addManufacturer(String manufacturer) throws DatabaseException {
        DbCar.addManufacturer(getConnection.connect(),manufacturer);
    }
}
