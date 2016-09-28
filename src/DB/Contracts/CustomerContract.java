package DB.Contracts;

import DB.DatabaseException;
import UI.NewSubscriber;

/**
 * Created by Marthin on 2016-09-27.
 */
public interface CustomerContract {

    public boolean addSubscriber(NewSubscriber subscriber) throws DatabaseException;
}
