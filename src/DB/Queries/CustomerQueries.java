package DB.Queries;

/**
 * Created by Marthin on 2016-09-27.
 */
public class CustomerQueries {


    public static String addSubscriber() {
        return "INSERT INTO USER(username,email,password)" +
                "VALUES(?,?,?)";
    }

    public static String getSubscriber(){
        return "SELECT USER.username," +
                "USER.email,USER.password," +
                "USER.role " +
                "FROM USER WHERE USER.username = ?";
    }
}
