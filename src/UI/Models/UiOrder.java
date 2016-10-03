package UI.Models;

import java.sql.Date;
import java.util.ArrayList;

/**
 * Created by Marthin on 2016-10-02.
 */
public class UiOrder {
    private int ID;
    private Date oDate;
    private Date sDate;
    private String status;
    private ArrayList<UiCar> cars;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private String username;
    public UiOrder() {}

    public UiOrder(int ID, Date oDate, Date sDate, String status, ArrayList<UiCar> cars, String firstName, String lastName, String phone, String address) {
        this.ID = ID;
        this.oDate = oDate;
        this.sDate = sDate;
        this.status = status;
        this.cars = cars;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }
    public UiOrder(Date oDate, ArrayList<UiCar> cars, String firstName, String lastName, String phone, String address, String username) {
        this.username = username;
        this.oDate = oDate;
        this.cars = cars;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Date getoDate() {
        return oDate;
    }

    public void setoDate(Date oDate) {
        this.oDate = oDate;
    }

    public Date getsDate() {
        return sDate;
    }

    public void setsDate(Date sDate) {
        this.sDate = sDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<UiCar> getCars() {
        return cars;
    }

    public void setCars(ArrayList<UiCar> cars) {
        this.cars = cars;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public void addCar(UiCar car) {
        this.cars.add(car);
    }
    public String getUsername() { return this.username; }
}
