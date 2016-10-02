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

    public static ArrayList<Car> findAllCars(Connection connection) throws DatabaseException {
        ArrayList<Car> cars = new ArrayList<>();
        PreparedStatement stmnt = null;
        try {
           stmnt = connection.prepareStatement(CarQueries.findAllCars());
            ResultSet rs = stmnt.executeQuery();
            while (rs.next()) {
                cars.add(new DbCar(rs));
            }
            if(cars == null) {
                throw new DatabaseException("No cars was found.");
            }
            return cars;
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            throw new DatabaseException();
        }finally {
            try {
                stmnt.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            DbConnPool.disconnect(connection);
        }
    }
    public static ArrayList<Car> findCarsByManufacturer(Connection connection,String manufacturer) throws DatabaseException {
        ArrayList<Car> cars = new ArrayList<>();
        PreparedStatement stmnt = null;
        try {
            stmnt = connection.prepareStatement(CarQueries.findCarsByManufacturer());
            stmnt.setString(1,manufacturer);
            ResultSet rs = stmnt.executeQuery();
            while (rs.next()) {
                cars.add(new DbCar(rs));
            }
            if(cars.isEmpty()){
                throw new DatabaseException("No manufacturer by that name was found.");
            }
            return cars;
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            throw new DatabaseException();
        }finally {
            try {
                stmnt.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            DbConnPool.disconnect(connection);
        }
    }
    public static Car findCarByModel(Connection connection, String model) throws DatabaseException {
        PreparedStatement stmnt = null;
        try {
            stmnt = connection.prepareStatement(CarQueries.findCarByModel());
            stmnt.setString(1,model);
            ResultSet rs = stmnt.executeQuery();
            if(rs.next()) {
                return new DbCar(rs);
            } else {
                throw new DatabaseException("Car model was not found.");
            }
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            throw new DatabaseException();
        }finally {
            try {
                stmnt.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            DbConnPool.disconnect(connection);
        }
    }

    public static void addCar(Connection connection) throws DatabaseException {

    }

    public static void addCarDescription(Connection connection, int carID, String description) throws DatabaseException {
    }

    public static void addManufacturer(Connection connection, String manufacturer) throws DatabaseException {
    }
}
