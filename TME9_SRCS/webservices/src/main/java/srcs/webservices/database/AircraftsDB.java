package srcs.webservices.database;

import java.util.ArrayList;
import java.util.List;

import srcs.webservices.airline.scheme.Aircraft;

public class AircraftsDB {

    private static List<Aircraft> aircrafts = new ArrayList<Aircraft>();

    public static List<Aircraft> getAircrafts() {
        return aircrafts;
    }

    public static void setAircrafts(List<Aircraft> a) {
        aircrafts.clear();
        aircrafts.addAll(a);
    }

    public static void addAircrafts(List<Aircraft> a) {
        aircrafts.addAll(a);

    }

    public static void addAircrafts(Aircraft a) {
        aircrafts.add(a);
    }

    public static void clearAircrafts() {
        aircrafts.clear();
    }

}
