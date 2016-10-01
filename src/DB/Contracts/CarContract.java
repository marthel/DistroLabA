package DB.Contracts;

import BO.Models.Car;
import DB.DatabaseException;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Marthin on 2016-09-27.
 */
public interface CarContract {
    ArrayList<Car> getAllCars() throws DatabaseException;
    void addManufacturer(String manufacturer)throws DatabaseException;
    void addCarDescription(int carID,String description)throws DatabaseException;
    ArrayList<Car> findCarsByManufacturer(String manufacturer)throws DatabaseException;
    Car getCarByModel(String model) throws DatabaseException;
}
