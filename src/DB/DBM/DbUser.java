package DB.DBM;

import BO.Models.Car;
import BO.Models.User;
import DB.DatabaseException;
import DB.DbConnPool;
import DB.Queries.CarQueries;
import DB.Queries.CustomerQueries;
import UI.NewSubscriber;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Marthin on 2016-09-27.
 */
public class DbUser extends User {


    public static void addSubscriber(Connection connection, NewSubscriber subscriber) throws DatabaseException {
        System.out.println("DB-USER");

        try {
            PreparedStatement stmnt = connection.prepareStatement(CustomerQueries.addUser());
            stmnt.setString(1,subscriber.getUser_name());
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
}
