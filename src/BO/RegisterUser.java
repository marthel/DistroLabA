package BO;

import BO.Models.User;
import DB.DatabaseException;
import DB.DbManager;
import UI.Models.UiUser;

import javax.naming.NamingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Marthin on 2016-10-02.
 */
public class RegisterUser {
    private UiUser user;
    private DbManager dbManager;
    public RegisterUser() throws NamingException {
        dbManager = new DbManager();
    }
    public void register(UiUser user) throws DatabaseException {
        this.user = user;
        user.setPassword(digestPassword(user.getPassword()));
        System.out.println(user.getPassword());
        dbManager.addUser(user);
    }
    public String digestPassword(String password) throws DatabaseException{
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new DatabaseException("Could not digest password.");
        }
        messageDigest.update(password.getBytes());
        return new String(messageDigest.digest());
    }

}
