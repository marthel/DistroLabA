package DB.DBM;

import BO.Models.Order;
import BO.Models.OrderDetail;
import DB.DatabaseException;
import DB.DbConnPool;
import DB.Queries.OrderQueries;
import UI.Models.UiOrder;

import java.sql.*;
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

    public static void createOrder(Connection connection, UiOrder order, int userID, ArrayList<OrderDetail> orderDetails) throws DatabaseException {
        PreparedStatement stmnt = null;
        int orderID =0;
        try {

            //adds the order to CARODER table
            stmnt = connection.prepareStatement(OrderQueries.createOrder(), Statement.RETURN_GENERATED_KEYS);
            stmnt.setDate(1,order.getoDate());
            stmnt.setInt(2,userID);
            stmnt.setString(3, order.getFirstName());
            stmnt.setString(4, order.getLastName());
            stmnt.setString(5, order.getPhone());
            stmnt.setString(6, order.getAddress());
            stmnt.executeUpdate();
            ResultSet rs = stmnt.getGeneratedKeys();
            if(rs.next()){
                orderID = rs.getInt(1);
            }
            //adds details to ORDERDETAILS table
            for (OrderDetail od: orderDetails) {
                stmnt = connection.prepareStatement(OrderQueries.createOrderDetails());
                stmnt.setInt(1,orderID);
                stmnt.setInt(2,od.getCarID());
                stmnt.setInt(3,od.getQuantity());
                stmnt.executeUpdate();
            }
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
        }

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
