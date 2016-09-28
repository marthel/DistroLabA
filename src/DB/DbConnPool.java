package DB;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Marthin on 2016-09-27.
 */
public class DbConnPool {

    private Connection connection = null;
    private DataSource dbPool;
    //private final String datasourceName = "java:/comp/env/jdbc/carshop";
    private final String datasourceName = "java:comp/env/jdbc/mysql://localhost:3306/carshop";
    public DbConnPool() throws NamingException{
        dbPool = (DataSource) new InitialContext().lookup(datasourceName);
    }

    public Connection connect() {
        if (connection == null) {
            try {
                connection = dbPool.getConnection();
            }  catch (SQLException ex) {
                System.out.println(ex.getMessage());
                return null;
            }
        }
        return connection;
    }
    public static boolean disconnect(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

}
