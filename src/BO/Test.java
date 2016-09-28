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
    public Test() throws NamingException, DatabaseException {
        DbContainer db = new DbContainer();
        System.out.println("TEST");
        ArrayList<Car> cars = db.getAllCars();
    }
}
