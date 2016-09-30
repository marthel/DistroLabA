package DB.DBM;

import BO.Models.Car;
import BO.Models.User;
import DB.DatabaseException;
import DB.DbConnPool;
import DB.Queries.CarQueries;
import DB.Queries.CustomerQueries;
import UI.Subscriber;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Marthin on 2016-09-27.
 */
public class DbUser extends User {

    private DbUser(ResultSet rs) throws SQLException {
        super(rs.getString("username"),rs.getString("password"),rs.getString("email"),
                rs.getString("role"));
    }

    public static void addSubscriber(Connection connection, Subscriber subscriber) throws DatabaseException {
        System.out.println("DB-USER");

        try {
            System.out.println("3333333");
            PreparedStatement stmnt = connection.prepareStatement(CustomerQueries.addSubscriber());
            System.out.println("444444");
            stmnt.setString(1,subscriber.getUser_name());
            System.out.println("555555");
            stmnt.setString(2,subscriber.getEmail());
            stmnt.setString(3,subscriber.getPassword());
            stmnt.execute();

            stmnt.close();
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            throw new DatabaseException("Could not add user, Already Exist");
        }finally {
            DbConnPool.disconnect(connection);
        }

    }

    /**
     * Checks if the subscriber exists.
     * Lite fult men den hämtar skiten även om lösen är fel men jämför lösenorden i koden.
     * while loopen är kanske inte nödvändig eftersom vi bara hämtar en sak.
     * @param connection
     * @param subscriber
     * @throws DatabaseException
     */
    public static User getSubscriber(Connection connection, Subscriber subscriber) throws DatabaseException{

        User user = null;
        try {
            PreparedStatement stmnt = connection.prepareStatement(CustomerQueries.getSubscriber());
            stmnt.setString(1,subscriber.getUser_name());
            ResultSet rs = stmnt.executeQuery();
            while (rs.next()) {
                user = new DbUser(rs);
            }
            stmnt.close();
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            throw new DatabaseException();
        }finally {
            DbConnPool.disconnect(connection);
        }

        return user;

    }
}
