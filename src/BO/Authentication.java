package BO;

import BO.Models.User;
import DB.DatabaseException;
import DB.DBManager;
import UI.Models.UiUser;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.naming.NamingException;

/**
 * Created by Marthin on 2016-10-02.
 */
public class Authentication {
    private UiUser user;
    private DBManager dbManager;
    public Authentication() throws NamingException {

        dbManager = new DBManager();
    }
    public UiUser authenticate(UiUser user) throws DatabaseException {
        User usr;
        this.user = user;
        user.setPassword(digestPassword(user.getPassword()));
        usr = dbManager.findUserByUsernameAndPassword(user.getUsername(),user.getPassword());
        return new UiUser(usr.getUsername(),usr.getPassword(),usr.getEmail(),usr.getRole());
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
