package DB.Queries;

/**
 * Created by Marthin on 2016-09-27.
 */
public class OrderQueries {

    public static String createOrder() {
        return "INSERT INTO CARORDER(oDate,sDate,status,userID,firstName,lastName,phone,address)" +
                "VALUES(?,?,?,?,?,?,?,?)";
    }

    public static String findAllOrders() {
        return "SELECT "
                + "CARORDER.ID as ID, "
                + "CARORDER.firstName as firstName, "
                + "CARORDER.lastName as lastName, "
                + "CARORDER.phone as phone, "
                + "CARORDER.address as address, "
                + "CARORDER.street as street, "
                + "CARORDER.oDate as oDate, "
                + "CARORDER.sDate as sDate, "
                + "CARORDER.status as status, "
                + "CAR.model as model, "
                + "MANUFACTURER.name as name, "
                + "CAR.price as price, "
                + "ORDERDETAIL.quantity as quantity "
                + "FROM CARORDER, ORDERDETAIL, USER, CAR, MANUFACTURER "
                + "WHERE USER.ID = CARORDER.userID "
                + "AND "
                + "CARORDER.ID = ORDERDETAIL.orderID "
                + "AND "
                + "CAR.ID = ORDERDETAIL.carID "
                + "AND "
                + "MANUFACTURER.ID = CAR.manufacturerID;";
    }

    public static String findOrdersByUsername() {
        return "SELECT "
                + "CARORDER.ID as ID, "
                + "CARORDER.firstName as firstName, "
                + "CARORDER.lastName as lastName, "
                + "CARORDER.phone as phone, "
                + "CARORDER.address as address, "
                + "CARORDER.street as street, "
                + "CARORDER.oDate as oDate, "
                + "CARORDER.sDate as sDate, "
                + "CARORDER.status as status, "
                + "CAR.model as model, "
                + "MANUFACTURER.name as name, "
                + "CAR.price as price, "
                + "ORDERDETAIL.quantity as quantity "
                + "FROM CARORDER, ORDERDETAIL, USER, CAR, MANUFACTURER "
                + "WHERE USER.ID = CARORDER.userID "
                + "AND "
                + "CARORDER.ID = ORDERDETAIL.orderID "
                + "AND "
                + "CAR.ID = ORDERDETAIL.carID "
                + "AND "
                + "MANUFACTURER.ID = CAR.manufacturerID "
                + "AND "
                + "USER.username = ?;";
    }
}
