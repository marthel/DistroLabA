package BO.Models;

import java.util.ArrayList;

/**
 * Created by Marthin on 2016-09-27.
 */
public class User {
    private String username;
    private String password;
    private String email;
    private  String role;
    private  ArrayList<Order> orders;

    public User(String username, String password, String email, String role, ArrayList<Order> orders) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.orders = orders;
    }

    public User(String username, String password, String email, String role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }
}
