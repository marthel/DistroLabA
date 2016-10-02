package BO;

import DB.DbManager;

import javax.naming.NamingException;

/**
 * Created by Marthin on 2016-09-28.
 */
public class Test {

    private DbManager db;
    public Test() throws NamingException {
        db = new DbManager();
    }
}
