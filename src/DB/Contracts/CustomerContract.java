package DB.Contracts;

import BO.Models.User;
import DB.DatabaseException;
import UI.Subscriber;

/**
 * Created by Marthin on 2016-09-27.
 */
public interface CustomerContract {

    void addSubscriber(Subscriber subscriber) throws DatabaseException;
    User getSubscriber(Subscriber subscriber)throws DatabaseException;
}
