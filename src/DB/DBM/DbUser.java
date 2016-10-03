package DB.DBM;

import BO.Models.User;
import DB.DatabaseException;
import DB.DbConnPool;
import DB.Queries.UserQueries;
import UI.Models.UiUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class DbUser extends User {

    private DbUser(ResultSet rs) throws SQLException {
        super(rs.getString("username"),rs.getString("password"),rs.getString("email"),
                rs.getString("role"));
    }


    public static void addUser(Connection connection, UiUser user) throws DatabaseException {
        PreparedStatement stmnt = null;
        try {
            stmnt = connection.prepareStatement(UserQueries.addUser());
            stmnt.setString(1,user.getUsername());
            stmnt.setString(2,user.getEmail());
            stmnt.setString(3,user.getPassword());
            stmnt.executeUpdate();
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            throw new DatabaseException("Username already taken.");
        }finally {
            try {
                if(stmnt!=null)
                    stmnt.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            DbConnPool.disconnect(connection);
        }
    }

    public static ArrayList<User> findAlUsers(Connection connection) throws DatabaseException {
        PreparedStatement stmnt = null;
        ArrayList<User> users = new ArrayList<>();
        try {
            stmnt = connection.prepareStatement(UserQueries.findAllUsers());
            ResultSet rs = stmnt.executeQuery();
            while (rs.next()) {
                users.add(new DbUser(rs));
            }
            if(users.isEmpty()) {
                throw new DatabaseException("No users was found.");
            }
            return users;
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            throw new DatabaseException();
        }finally {
            try {
                if(stmnt!=null)
                    stmnt.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            DbConnPool.disconnect(connection);
        }
    }

    public static User findUserByUsername(Connection connection, String username) throws DatabaseException {
        PreparedStatement stmnt = null;
        try {
            stmnt = connection.prepareStatement(UserQueries.findUserByUsername());
            stmnt.setString(1,username);
            ResultSet rs = stmnt.executeQuery();
            if(rs.next()) {
                return new DbUser(rs);
            } else {
                throw new DatabaseException("No user by that name was found.");
            }
        } catch (SQLException ex){
            throw new DatabaseException();
        }finally {
            try {
                if(stmnt!=null)
                    stmnt.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            //DbConnPool.disconnect(connection);
        }
    }
    public static int findUserIdbyUsername(Connection connection, String username) throws DatabaseException {
        PreparedStatement stmnt = null;
        try {
            stmnt = connection.prepareStatement(UserQueries.findUserIdbyUsername());
            stmnt.setString(1,username);
            ResultSet rs = stmnt.executeQuery();
            if(rs.next()) {
                return rs.getInt("ID");
            } else {
                throw new DatabaseException("Could not find user.");
            }
        } catch (SQLException ex){
            throw new DatabaseException();
        }finally {
            try {
                if(stmnt!=null)
                    stmnt.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            //DbConnPool.disconnect(connection);
        }
    }
    public static User findUserByUsernameAndPassword(Connection connection, String username, String password) throws DatabaseException {
        PreparedStatement stmnt = null;
        try {
            stmnt = connection.prepareStatement(UserQueries.findUserByUsernameAndPassword());
            stmnt.setString(1,username);
            stmnt.setString(2,password);
            ResultSet rs = stmnt.executeQuery();
            if(rs.next()) {
                return new DbUser(rs);
            } else {
                throw new DatabaseException("Wrong user or password.");
            }
        } catch (SQLException ex){
            throw new DatabaseException();
        }finally {
            try {
                if(stmnt!=null)
                    stmnt.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            DbConnPool.disconnect(connection);
        }
    }

}
