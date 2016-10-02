package BO;

import DB.DatabaseException;
import DB.DBManager;
import UI.Models.UiUser;

import javax.naming.NamingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class RegisterUser {
    private UiUser user;
    private DBManager dbManager;
    public RegisterUser() throws NamingException {
        dbManager = new DBManager();
    }
    public void register(UiUser user) throws DatabaseException {
        this.user = user;
        user.setPassword(digestPassword(user.getPassword()));
        dbManager.addUser(user);
    }
    private String digestPassword(String password) throws DatabaseException{
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new DatabaseException("Could not digest password.");
        }
        messageDigest.update(password.getBytes());
        return new String(messageDigest.digest());
    }

}
