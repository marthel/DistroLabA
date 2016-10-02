package DB.Queries;

/**
 * Created by Marthin on 2016-09-27.
 */
public class CarQueries {

    public static String findAllCars() {
        return "SELECT "
                + "MANUFACTURER.name as name, "
                + "CAR.model as model, "
                + "CAR.year as year, "
                + "CAR.quantity as quantity, "
                + "CAR.price as price  "
                + "FROM CAR, MANUFACTURER "
                + "WHERE MANUFACTURER.ID = CAR.manufacturerID";
    }
    public static String findCarsByManufacturer() {
        return "SELECT "
                + "MANUFACTURER.name as name, "
                + "CAR.model as model, "
                + "CAR.year as year, "
                + "CAR.quantity as quantity, "
                + "CAR.price as price  "
                + "FROM CAR, MANUFACTURER "
                + "WHERE MANUFACTURER.ID = CAR.manufacturerID "
                + "AND "
                + "MANUFACTURER.name = ?;";
    }

    public static String findCarByModel() {
        return "SELECT "
                + "MANUFACTURER.name as name, "
                + "CAR.model as model, "
                + "CAR.year as year, "
                + "CAR.quantity as quantity, "
                + "CAR.price as price  "
                + "FROM CAR, MANUFACTURER "
                + "WHERE MANUFACTURER.ID = CAR.manufacturerID "
                + "AND "
                + "CAR.model = ?;";
    }

    //----------------------INSERTION----------------------\\
    public static String addNCar() {
        return "INSERT INTO CAR(model,year,quantity,price)" +
                "VALUES(?,?,?,?)";
    }
    public static String addManufacturer(){
        return "INSERT INTO MANUFACTURER(name)" +
                "VALUES(?)";
    }
    public static String addCarDescription(){
        return "INSERT INTO CARDESCRIPTION(carID,description)" +
                "VALUES(?,?)";
    }




}
