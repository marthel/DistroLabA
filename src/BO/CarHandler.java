package BO;

import BO.Models.Car;
import DB.DatabaseException;
import DB.DbManager;
import UI.Models.UiCar;

import javax.naming.NamingException;
import java.util.ArrayList;

/**
 * Created by Marthin on 2016-10-02.
 */
public class CarHandler {
    private DbManager dbManager;
    public CarHandler() throws NamingException {
        dbManager = new DbManager();
    }

    public ArrayList<UiCar> findAllCars() throws DatabaseException {
        ArrayList<UiCar> cars = new ArrayList<>();
        ArrayList<Car> crs = dbManager.findAllCars();
        for (Car c: crs) {
            cars.add(new UiCar(c));
        }
        return cars;
    }
}