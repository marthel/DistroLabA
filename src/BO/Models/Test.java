package BO.Models;

import BO.Models.Car;
import BO.Models.Order;
import DB.DatabaseException;
import DB.DbContainer;
import UI.NewSubscriber;

import javax.naming.NamingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

/**
 * Created by Marthin on 2016-09-28.
 */
public class Test {
    public Test() {
    }
    public void getAllCars() throws NamingException {

        DbContainer db = new DbContainer();

        System.out.println("<Add New Subscriber>");
        try {
            db.addSubscriber(new NewSubscriber("Abdulla","haha","jagärsämst@alban.com"));
                System.out.println("Success, new user added");
        } catch (DatabaseException e) {
            System.out.println("!User Already Exist!");
        }

        try {
            ArrayList<Car> cars = db.getAllCars();
            System.out.println("<Bring All Cars>");
        } catch (DatabaseException e) {
            System.out.println("!Could Not Bring Any Cars!");
        }

        System.out.println("<Add New Manufacturer>");
        try {
            db.addManufacturer("Lambo");
        } catch (DatabaseException e) {
            System.out.println("!Could Not Add Manufacturer!");
        }

        System.out.println("<Add New Description>");
        try {
            db.addCarDescription(1,"Den är snygg som fan");
        } catch (DatabaseException e) {
            e.printStackTrace();
        }


        try {
            ArrayList<Car> items = new ArrayList<>();
            items.add(new Car("Marcedes","audi","1991",50,999999));
            ArrayList<Order> orders = new ArrayList<>();
            orders.add(new Order(new Date(),new Date(),"Working",items,"Marthin","Abdullson","00300303","world trade center"));

            db.createOrder(orders);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }
    }
}
