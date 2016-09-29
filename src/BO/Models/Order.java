package BO.Models;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Marthin on 2016-09-27.
 */
public class Order {
    private Date oDate;
    private Date sDate;
    private String status;
    private ArrayList<Car> cars;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    public Order(Date oDate, Date sDate, String status, String firstName, String lastName, String phone, String address) {
        this.oDate = oDate;
        this.sDate = sDate;
        this.status = status;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }
    public Order(Date oDate, Date sDate, String status,ArrayList<Car> cars, String firstName, String lastName, String phone, String address) {
        this.oDate = oDate;
        this.sDate = sDate;
        this.status = status;
        this.firstName = firstName;
        this.cars = cars;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    public Order() {
    }

    public Date getoDate() { return oDate; }

    public Date getsDate() {
        return sDate;
    }

    public String getStatus() {
        return status;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }
}
