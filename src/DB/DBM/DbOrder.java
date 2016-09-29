package DB.DBM;

import BO.Models.Car;
import BO.Models.Order;
import DB.DatabaseException;
import DB.DbConnPool;
import DB.Queries.CarQueries;
import DB.Queries.OrderQueries;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Marthin on 2016-09-27.
 */
public class DbOrder extends Order {


    private DbOrder(ResultSet rs) throws SQLException{
        super(rs.getDate("oDate"),rs.getDate("sDate"), rs.getString("status"),
                rs.getString("firstName"), rs.getString("lastName"),
                rs.getString("phone"), rs.getString("street"));
    }

    public static void createOrders(Connection connection, ArrayList<Order> orders) throws DatabaseException {

        //Todo Lägg till en transaktion och att hämta user ID innan köp.
        for (Order o : orders) {

            try {
                PreparedStatement stmnt = connection.prepareStatement(OrderQueries.createOrder());
                stmnt.setDate(1, new java.sql.Date(o.getoDate().getTime()));
                stmnt.setDate(2, new java.sql.Date(o.getsDate().getTime()));
                stmnt.setString(3, o.getStatus());
                //Todo fixa så att usrId kan kommas åt. satte den till 5 tmp;
                stmnt.setInt(4, 5);
                stmnt.setString(5, o.getFirstName());
                stmnt.setString(6, o.getLastName());
                stmnt.setString(7, o.getPhone());
                stmnt.setString(8, o.getAddress());

                stmnt.execute();
                stmnt.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                throw new DatabaseException("Could Not Add Order");
            } finally {
                DbConnPool.disconnect(connection);
            }
        }
    }

    public static ArrayList<Order> getOrders(Connection connection) throws DatabaseException {

        ArrayList<Order> orders = new ArrayList<>();
        try {
            PreparedStatement stmnt = connection.prepareStatement(OrderQueries.getAllOrders());
            ResultSet rs = stmnt.executeQuery();
            while (rs.next()) {
                orders.add(new DbOrder(rs));
            }
            stmnt.close();
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            throw new DatabaseException();
        }finally {
            DbConnPool.disconnect(connection);
        }

        return orders;
    }
}
