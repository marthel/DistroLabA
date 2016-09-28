package DB.Queries;

/**
 * Created by Marthin on 2016-09-27.
 */
public class CustomerQueries {


    public static String addUser() {
        return "INSERT INTO USER(username,email,password)" +
                "VALUES(?,?,?)";
    }
}
