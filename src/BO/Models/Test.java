package BO.Models;

import DB.DatabaseException;
import DB.DbContainer;
import UI.Subscriber;

import javax.naming.NamingException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Marthin on 2016-09-28.
 */
public class Test {

    private DbContainer db;
    public Test() throws NamingException {
        db = new DbContainer();
    }



    public void getCars() throws NamingException {


        System.out.println("<Add New Subscriber>");
        try {
            db.addSubscriber(new Subscriber("Abdulla","haha","jagärsämst@alban.com"));
                System.out.println("Success, new user added");
        } catch (DatabaseException e) {
            System.out.println("!User Already Exist!");
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

        System.out.println("<Create New Orders>");
        try {
            ArrayList<Car> items = new ArrayList<>();
            items.add(new Car("Marcedes","audi","1991",50,999999));
            ArrayList<Order> orders = new ArrayList<>();
            orders.add(new Order(new Date(),new Date(),"Working",items,"Marthin","Abdullson","00300303","world trade center"));

            db.createOrder(orders);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }

        System.out.println("<Get Users Orders>");
        try {

            for (Order o: db.getOrders()) {
                System.out.println(o.getAddress() + " " + o.getsDate());
            }

        } catch (DatabaseException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Car> getAllCars(){

        ArrayList<Car> cars = null;
        try {
            cars = db.getAllCars();
            System.out.println("<Bring All Cars>");
        } catch (DatabaseException e) {
            System.out.println("!Could Not Bring Any Cars!");
        }
        return cars;
    }

    public void addNewUser(String usr,String password,String confirmPass) throws DatabaseException {

        System.out.println("<Add New Subscriber>");
        try {
            System.out.println("11111111");
            db.addSubscriber(new Subscriber(usr,password,confirmPass));
            System.out.println("Success, new user added");
        } catch (DatabaseException e) {
            System.out.println("!User Already Exist!");
        }

    }

    public void getUserWithReqName(Subscriber subscriber){

        User user = null;
        try {
            user = db.getSubscriber(subscriber);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }
        if (!user.equals("null"))
            System.out.println("USER FOUND: " + user.getUsername() + user.getPassword());

    }
}
