package BO.Models;

import java.sql.Date;
import java.util.ArrayList;


/**
 * Created by Marthin on 2016-09-27.
 */
public class Order {
    private int ID;
    private Date oDate;
    private Date sDate;
    private String status;
    private ArrayList<String> carInfo = new ArrayList<>();
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    protected Order() {}

    protected Order(int ID, Date oDate, Date sDate, String status, String carInfo, String firstName, String lastName, String phone, String address) {
        this.ID = ID;
        this.oDate = oDate;
        this.sDate = sDate;
        this.status = status;
        this.carInfo.add(carInfo);
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    public int getID() { return ID; }

    public void addCarinfo(String carInfo) {
        this.carInfo.add(carInfo);
    }

    public Date getoDate() {
        return oDate;
    }

    public Date getsDate() {
        return sDate;
    }

    public String getStatus() {
        return status;
    }

    public ArrayList<String> getCarInfo() {
        return carInfo;
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

    @Override
    public String toString() {
        return "Order{" + ID +
                ", order date: " + oDate +
                ", shipped date: " + sDate +
                ", status: " + status +
                ", first name:" + firstName +
                ", last name: " + lastName +
                ", phone: " + phone +
                ", address: " + address + "}   " +
                "Order details: " + carInfo;
    }
}
