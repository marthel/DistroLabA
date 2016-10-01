package UI;

/**
 * Created by Scalman on 28/09/16.
 */
public class Subscriber {

    private String user_name;
    private String password;
    private String email;

    public Subscriber(String user_name, String password, String email) {
        this.user_name = user_name;
        this.password = password;
        this.email = email;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
