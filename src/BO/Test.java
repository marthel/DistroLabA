package BO;

import BO.Models.Car;
import DB.DatabaseException;
import DB.DbContainer;
import UI.NewSubscriber;

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


        try {
            if (db.addSubscriber(new NewSubscriber("Marthin","haha","jagärsämst@alban.com"))){
                System.out.println("Success, new user added");
            }else {
                System.out.println("User Already exists");
            }
        } catch (DatabaseException e) {
            e.printStackTrace();
        }


        System.out.println("hämtar alla bilar");
        try {
            ArrayList<Car> cars = db.getAllCars();
        } catch (DatabaseException e) {
            e.printStackTrace();
        }


    }
}
