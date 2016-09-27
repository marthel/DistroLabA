package BO.Models;

import java.awt.*;

/**
 * Created by Marthin on 2016-09-27.
 */
public class Car {
    private String model;
    private String year;
    private String manufacturer;
    private int quantity;
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
}
