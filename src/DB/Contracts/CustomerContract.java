package DB.Contracts;

import DB.DatabaseException;
import UI.NewSubscriber;

/**
 * Created by Marthin on 2016-09-27.
 */
public interface CustomerContract {

    void addSubscriber(NewSubscriber subscriber) throws DatabaseException;
}
