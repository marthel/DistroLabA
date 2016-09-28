package DB;

import BO.Models.Car;
import DB.Contracts.CarContract;
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
        super(rs.getString("name"),rs.getString("model"),rs.getString("year"),rs.getInt("quantity"));
    }
    public static ArrayList<Car> getAllCars(Connection connection) throws DatabaseException {
        System.out.println("dbCAR");
        ArrayList<Car> cars = new ArrayList<>();
        try {
            PreparedStatement stmnt = connection.prepareStatement(CarQueries.getAllCars());
            ResultSet rs = stmnt.executeQuery();
            while (rs.next()) {
                cars.add(new DbCar(rs));
            }
            stmnt.close();
        } catch (SQLException ex){
            throw new DatabaseException();
        }finally {
            DbConnPool.disconnect(connection);
        }
        for (Car car: cars) {
            System.out.println(car.getManufacturer()+" "+car.getModel());
        }
        return cars;
    }
}
