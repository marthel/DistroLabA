package DB.DBM;

import BO.Models.Car;
import DB.DatabaseException;
import DB.DbConnPool;
import DB.Queries.CarQueries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Marthin on 2016-09-27.
 */
public class DbCar extends Car{

    private DbCar(ResultSet rs) throws SQLException {
        super(rs.getString("name"),rs.getString("model"),rs.getString("year"),rs.getInt("quantity"),rs.getInt("price"));
    }

    public static ArrayList<Car> getAllCars(Connection connection) throws DatabaseException {
        ArrayList<Car> cars = new ArrayList<>();
        try {
            PreparedStatement stmnt = connection.prepareStatement(CarQueries.getAllCars());
            ResultSet rs = stmnt.executeQuery();
            while (rs.next()) {
                cars.add(new DbCar(rs));
            }
            stmnt.close();
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            throw new DatabaseException();
        }finally {
            DbConnPool.disconnect(connection);
        }

        return cars;
    }
    public static ArrayList<Car> findCarsByManufacturer(Connection connection,String manufacturer) throws DatabaseException {
        ArrayList<Car> cars = new ArrayList<>();
        try {
            PreparedStatement stmnt = connection.prepareStatement(CarQueries.findCarsByManufacturer());
            stmnt.setString(1,manufacturer);
            ResultSet rs = stmnt.executeQuery();
            while (rs.next()) {
                cars.add(new DbCar(rs));
            }
            stmnt.close();
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            throw new DatabaseException();
        }finally {
            DbConnPool.disconnect(connection);
        }
        return cars;
    }

    public static void addManufacturer(Connection connection,String manufacturer)throws DatabaseException{

        try {
            PreparedStatement stmnt = connection.prepareStatement(CarQueries.admin_AddNewManufacturer());
            stmnt.setString(1,manufacturer);
            stmnt.execute();
            stmnt.close();
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            throw new DatabaseException("Manufacturer Already Exist");
        }finally {
            DbConnPool.disconnect(connection);
        }
    }

    //TODO make carID and Description as an Object
    public static void addCarDescription(Connection connection,int carID,String description) throws DatabaseException {

        try {
            PreparedStatement stmnt = connection.prepareStatement(CarQueries.admin_AddCarDescription());
            stmnt.setInt(1,carID);
            stmnt.setString(2,description);
            stmnt.execute();
            stmnt.close();
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            throw new DatabaseException("Description Already Exist");
        }finally {
            DbConnPool.disconnect(connection);
        }
    }
}
