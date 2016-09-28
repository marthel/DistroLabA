package DB.Queries;

/**
 * Created by Marthin on 2016-09-27.
 */
public class CarQueries {
    public static String getAllCars() {
        return "SELECT MANUFACTURER.name as name, CAR.model as model, CAR.year as year, CAR.quantity as quantity, CAR.price as price,  FROM CAR JOIN ROLE ON ROLE.email = USER.email WHERE CAR.manufacturerID = MANUFACTURER.ID";
    }
}
