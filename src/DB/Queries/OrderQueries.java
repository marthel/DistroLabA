package DB.Queries;

/**
 * Created by Marthin on 2016-09-27.
 */
public class OrderQueries {

    public static String createOrder(){
        return "INSERT INTO CARORDER(oDate,sDate,status,userID,firstName,lastName,phone,street)" +
                "VALUES(?,?,?,?,?,?,?,?)";
    }
}
