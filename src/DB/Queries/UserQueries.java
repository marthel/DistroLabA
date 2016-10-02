package DB.Queries;

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

    public static String findUserIdbyUsername() {
        return "SELECT "
                + "USER.ID as ID "
                + "FROM USER "
                + "WHERE USER.username = ? ";
    }
}
