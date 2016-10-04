package DB.Contracts;

import BO.Models.Car;
import DB.DatabaseException;
import UI.Models.UiCar;


import java.sql.Connection;
import java.util.ArrayList;

/**
 * Created by Marthin on 2016-09-27.
 */
public interface CarContract {
    ArrayList<Car> findAllCars() throws DatabaseException;
    void addManufacturer(String manufacturer)throws DatabaseException;
    void addCarDescription(int carID, String description)throws DatabaseException;
    void addCar(UiCar car, int id)throws DatabaseException;
    ArrayList<Car> findCarsByManufacturer(String manufacturer)throws DatabaseException;
    Car findCarByModel(String model) throws DatabaseException;
    Integer findCarIDByModel(Connection connection, String model) throws DatabaseException;
    void updateCarQuantity(Connection connection, int carID, int quantity) throws DatabaseException;
    void removeCar(String model) throws DatabaseException;
    void updateCar(UiCar car)throws DatabaseException;
    int getManufacturerID(String manufacturer)throws DatabaseException;
    void addCarFromPrevAddedManu(UiCar car) throws DatabaseException;
}
