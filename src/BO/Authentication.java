package BO;

import BO.Models.User;
import DB.DatabaseException;
import DB.DbManager;
import UI.Models.UiUser;

import javax.naming.NamingException;

/**
 * Created by Marthin on 2016-10-02.
 */
public class Authentication {
    private UiUser user;
    private DbManager dbManager;
    public Authentication(UiUser user) throws NamingException {
        this.user = user;
        dbManager = new DbManager();
    }
    public UiUser authenticate() throws DatabaseException {
        User usr;
        usr = dbManager.findUserByUsernameAndPassword(user.getUsername(),user.getPassword());
        return new UiUser(usr.getUsername(),usr.getPassword(),usr.getEmail(),usr.getRole());
    }
}
