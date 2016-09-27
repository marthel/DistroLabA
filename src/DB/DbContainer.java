package DB;

import DB.Contracts.CarContract;
import DB.Contracts.CustomerContract;
import DB.Contracts.OrderContract;

import javax.naming.NamingException;

/**
 * Created by Marthin on 2016-09-27.
 */
public class DbContainer implements CustomerContract,CarContract,OrderContract {
    private DbConnPool getConnection;

    public DbContainer() throws NamingException {
        getConnection = new DbConnPool();
    }
}
