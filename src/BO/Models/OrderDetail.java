package BO.Models;

/**
 * Created by Marthin on 2016-10-03.
 */
public class OrderDetail {
    private int carID;
    private int quantity;

    public OrderDetail() {
    }

    public OrderDetail(int carID, int quantity) {
        this.carID = carID;
        this.quantity = quantity;
    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
