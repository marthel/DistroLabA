package BO;

import BO.Models.Car;
import DB.DatabaseException;
import DB.DBManager;
import UI.Models.UiCar;

import javax.naming.NamingException;
import java.sql.Connection;
import java.util.ArrayList;

/**
 * Created by Marthin on 2016-10-02.
 */
public class CarHandler {
    private DBManager dbManager;
    public CarHandler() throws NamingException {
        dbManager = new DBManager();
    }

    public ArrayList<UiCar> findAllCars() throws DatabaseException {
        ArrayList<UiCar> cars = new ArrayList<>();
        ArrayList<Car> crs = dbManager.findAllCars();
        for (Car c: crs) {
            cars.add(new UiCar(c));
        }
        return cars;
    }

    public ArrayList<UiCar> getCartItems(ArrayList<String> cart) throws DatabaseException {
        ArrayList<UiCar> cars = new ArrayList<>();
        ArrayList<Car> crs = new ArrayList<>();

        for (String s: cart) {
            crs.add(dbManager.findCarByModel(s));
        }

        for (Car c: crs) {
            cars.add(new UiCar(c));
        }
        return cars;
    }
    public ArrayList<Integer> getCarIDs(Connection connection, ArrayList<UiCar> cars) throws DatabaseException {
        ArrayList<Integer> carIDs = new ArrayList<>();

        for (UiCar car: cars) {
            carIDs.add(dbManager.findCarIDByModel(connection, car.getModel()));
        }
        return carIDs;
    }

    public void updateCarQuantity(Connection connection, int carID, int quantity) throws DatabaseException{
        dbManager.updateCarQuantity(connection,carID,quantity);
    }
}
