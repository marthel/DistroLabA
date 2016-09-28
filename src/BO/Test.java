package BO;

import BO.Models.Car;
import DB.DatabaseException;
import DB.DbContainer;

import javax.naming.NamingException;
import java.util.ArrayList;

/**
 * Created by Marthin on 2016-09-28.
 */
public class Test {
    public Test() {
    }
    public void getAllCars() throws NamingException, DatabaseException {
        System.out.println("hämtar alla bilar");
        DbContainer db = new DbContainer();
        ArrayList<Car> cars = db.getAllCars();
    }
}
