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
    private ArrayList<String> carInfo;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    public UiOrder() {}

    public UiOrder(int ID, Date oDate, Date sDate, String status, String carInfo, String firstName, String lastName, String phone, String address) {
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

    public ArrayList<String> getCarInfo() {
        return carInfo;
    }

    public void setCarInfo(ArrayList<String> carInfo) {
        this.carInfo = carInfo;
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
    public void addCarinfo(String carInfo) {
        this.carInfo.add(carInfo);
    }
}
