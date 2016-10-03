package DB.Contracts;

import BO.Models.Car;
import DB.DatabaseException;

import java.sql.Connection;
import java.util.ArrayList;

/**
 * Created by Marthin on 2016-09-27.
 */
public interface CarContract {
    ArrayList<Car> findAllCars() throws DatabaseException;
    void addManufacturer(String manufacturer)throws DatabaseException;
    void addCarDescription(int carID, String description)throws DatabaseException;
    void addCar()throws DatabaseException;
    ArrayList<Car> findCarsByManufacturer(String manufacturer)throws DatabaseException;
    Car findCarByModel(String model) throws DatabaseException;
    Integer findCarIDByModel(Connection connection, String model) throws DatabaseException;
    public void updateCarQuantity(Connection connection, int carID, int quantity) throws DatabaseException;
}
