package DB.Queries;

/**
 * Created by Marthin on 2016-09-27.
 */
public class OrderQueries {

    public static String createOrder(){
        return "INSERT INTO CARORDER(oDate,sDate,status,userID,firstName,lastName,phone,street)" +
                "VALUES(?,?,?,?,?,?,?,?)";
    }

    public static String getAllOrders() {
        return "SELECT "
                + "USER.ID,"
                + "CARORDER.oDate,CARORDER.sDate,"+
                  "CARORDER.status,CARORDER.userID,"+
                  "CARORDER.firstName,CARORDER.lastName,"+
                  "CARORDER.phone,CARORDER.street "
                + "FROM "
                + "USER,"
                + "CARORDER "
                + "WHERE USER.ID = CARORDER.userID";
    }
}
