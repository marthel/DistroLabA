package DB.Queries;

/**
 * Created by Marthin on 2016-09-27.
 */
public class CarQueries {
    public static String getAllCars() {
        return "SELECT MANUFACTURER.name, CAR.model, CAR.year, CAR.quantity, CAR.price,  FROM CAR, MANUFACTURER WHERE MANUFACTURER.ID = CAR.manufacturerID";
    }
}
