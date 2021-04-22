package srcs.webservices.database;

import java.util.ArrayList;
import java.util.List;

import srcs.webservices.airline.scheme.Airport;

public class AirportsDB {

    private static List<Airport> airports = new ArrayList<>();

    public static List<Airport> getAirports() {
        System.out.println("---------------- "+airports.size());
        return airports;
    }

    public static void setAirports(List<Airport> a) {
        airports.clear();
        airports.addAll(a);
    }

    public static void addAirports(List<Airport> a) {
        System.out.println("hello #####################################################");
        airports.addAll(a);
        
        System.out.println("############ "+airports.size() );
    }

    public static void addAirports(Airport a) {
        airports.add(a);
    }

    public static void clearAirports() {
        airports.clear();
    }

}