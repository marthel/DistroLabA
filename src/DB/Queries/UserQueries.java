package DB.Queries;

/**
 * Created by Marthin on 2016-09-27.
 */
public class UserQueries {


    public static String addUser() {
        return "INSERT INTO USER(username,email,password,role)" +
                "VALUES(?,?,?,'customer')";
    }
    public static String findAllUsers() {
        return "SELECT "
                + "USER.username as username, "
                + "USER.password as password, "
                + "USER.role as role, "
                + "USER.email as email "
                + "FROM USER;";
    }
    public static String findUserByUsername() {
        return "SELECT "
                + "USER.username as username, "
                + "USER.password as password, "
                + "USER.role as role, "
                + "USER.email as email "
                + "FROM USER "
                + "WHERE USER.name = ?;";
    }
    public static String findUserByUsernameAndPassword() {
        return "SELECT "
                + "USER.username as username, "
                + "USER.password as password, "
                + "USER.role as role, "
                + "USER.email as email "
                + "FROM USER "
                + "WHERE USER.username = ? "
                + "AND USER.password = ?;";
    }
}
