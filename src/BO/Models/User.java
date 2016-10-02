package BO.Models;

/**
 * Created by Marthin on 2016-09-27.
 */
public class User {
    private String username;
    private String password;
    private String email;
    private  String role;

    protected User(){}

    protected User(String username, String password, String email, String role) {
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
}
