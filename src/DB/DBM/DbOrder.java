package DB.DBM;

import BO.Models.Order;
import DB.DatabaseException;
import DB.DbConnPool;
import DB.Queries.OrderQueries;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DbOrder extends Order {


    private DbOrder(ResultSet rs) throws SQLException {
        super(  rs.getInt("ID"),
                rs.getDate("oDate"),
                rs.getDate("sDate"),
                rs.getString("status"),
                rs.getString("model") + " " + rs.getString("name") + " " + rs.getInt("price") + " " + rs.getInt("quantity"),
                rs.getString("firstName"),
                rs.getString("lastName"),
                rs.getString("phone"),
                rs.getString("address"));
    }

    public static void createOrder(Connection connection) throws DatabaseException {
        int userID = DbUser.findUserIdbyUsername(connection, "namn");
    }

    public static ArrayList<Order> findAllOrders(Connection connection) throws DatabaseException {
        PreparedStatement stmnt = null;
        ArrayList<Order> orders = new ArrayList<>();
        try {
            stmnt = connection.prepareStatement(OrderQueries.findAllOrders());
            ResultSet rs = stmnt.executeQuery();
            while (rs.next()) {
                if (!containsOrder(orders, rs)) {
                    orders.add(new DbOrder(rs));
                } else {
                    orders = addOrderDetail(orders, rs);
                }
            }
            if(orders.isEmpty()) {
                throw new DatabaseException("No orders was found.");
            }
            return orders;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new DatabaseException();
        } finally {
            try {
                if(stmnt!=null)
                    stmnt.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            DbConnPool.disconnect(connection);
        }
    }

    public static ArrayList<Order> findOrdersByUsername(Connection connection, String username) throws DatabaseException {
        ArrayList<Order> orders = new ArrayList<>();
        PreparedStatement stmnt = null;
        try {
            stmnt = connection.prepareStatement(OrderQueries.findOrdersByUsername());
            stmnt.setString(1, username);
            ResultSet rs = stmnt.executeQuery();
            while (rs.next()) {
                if (!containsOrder(orders, rs)) {
                    orders.add(new DbOrder(rs));
                } else {
                    orders = addOrderDetail(orders, rs);
                }
            }
            if(orders.isEmpty()) {
                throw new DatabaseException("No orders was found.");
            }
            return orders;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new DatabaseException("User has no orders.");
        } finally {
            try {
                if(stmnt!=null)
                    stmnt.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            DbConnPool.disconnect(connection);
        }


    }

    private static boolean containsOrder(ArrayList<Order> orders, ResultSet rs) throws SQLException {
        for (Order o : orders) {
            if (o.getID() == rs.getInt("ID")) {
                return true;
            }
        }
        return false;
    }

    private static ArrayList<Order> addOrderDetail(ArrayList<Order> orders, ResultSet rs) throws SQLException {
        for (Order o : orders) {
            if (o.getID() == rs.getInt("ID")) {
                o.addCarinfo(rs.getString("model") + " " + rs.getString("name") + " " + rs.getInt("price") + " " + rs.getInt("quantity"));
            }
        }
        return orders;
    }
}
