package DB;

/**
 * Created by Marthin on 2016-09-28.
 */
public class DatabaseException extends Exception{
    public DatabaseException(String message) {
        super(message);
    }
    public DatabaseException() {
        super("Database connectivity error.");
    }
    public String getMessage(){
        return super.getMessage();
    }
}
