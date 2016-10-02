package UI.Models;

import BO.Models.Car;

import java.util.Arrays;

/**
 * Created by Marthin on 2016-10-02.
 */
public class UiCar {
    private String model;
    private String year;
    private String manufacturer;
    private int quantity;
    private int price;
    private String description;
    private byte[] carImage;

    public  UiCar() {}

    public UiCar(String model, String year, String manufacturer, int quantity, String description, byte[] carImage) {
        this.model = model;
        this.year = year;
        this.manufacturer = manufacturer;
        this.quantity = quantity;
        this.description = description;
        this.carImage = carImage;
    }
    public UiCar(String manufacturer, String model, String year, int quantity, int price) {
        this.model = model;
        this.year = year;
        this.manufacturer = manufacturer;
        this.quantity = quantity;
        this.price = price;
    }
    public UiCar(Car car) {
        this.model = car.getModel();
        this.year = car.getYear();
        this.manufacturer = car.getManufacturer();
        this.quantity = car.getQuantity();
        this.price = car.getPrice();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getCarImage() {
        return carImage;
    }

    public void setCarImage(byte[] carImage) {
        this.carImage = carImage;
    }

    @Override
    public String toString() {
        return  " manufacturer " +
                ", " + model +
                ", year=" + year +
                ", quantity=" + quantity +
                ", price=" + price
                ;
    }
}
