package DB.Contracts;

import BO.Models.User;
import DB.DatabaseException;
import java.util.ArrayList;

/**
 * Created by Marthin on 2016-09-27.
 */
public interface UserContract {

    void addUser() throws DatabaseException;
    ArrayList<User> findAllUsers() throws DatabaseException;
    User findUserByUsername(String username) throws DatabaseException;
    User findUserByUsernameAndPassword(String username,String password) throws DatabaseException;
}
