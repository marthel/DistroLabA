package DB.Contracts;

import BO.Models.Car;
import DB.DatabaseException;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Marthin on 2016-09-27.
 */
public interface CarContract {
    public ArrayList<Car> getAllCars() throws DatabaseException;
}
