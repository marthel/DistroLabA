package BO.Models;


/**
 * Created by Marthin on 2016-09-27.
 */
public class Car {
    private String model;
    private String year;
    private String manufacturer;
    private int quantity;
    private int price;
    private String description;
    private byte[] carImage;
    protected  Car()
    {

    }
    protected Car(String model, String year, String manufacturer, int quantity, String description, byte[] carImage) {
        this.model = model;
        this.year = year;
        this.manufacturer = manufacturer;
        this.quantity = quantity;
        this.description = description;
        this.carImage = carImage;
    }
    protected Car(String manufacturer, String model, String year, int quantity, int price) {
        this.model = model;
        this.year = year;
        this.manufacturer = manufacturer;
        this.quantity = quantity;
        this.price = price;
    }
    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public String getYear() {
        return year;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public byte[] getCarImage() {
        return carImage;
    }
}
