package srcs.webservices.database;

import java.util.ArrayList;
import java.util.List;

import srcs.webservices.airline.scheme.Airport;

public class AirportsDB {

    private static List<Airport> airports = new ArrayList<>();

    public static List<Airport> getAirports() {
        return airports;
    }

    public static void setAirports(List<Airport> a) {
        airports.clear();
        airports.addAll(a);
    }

    public static void addAirports(List<Airport> a) {
        for(Airport air : a ){
            if(!airports.contains(air)){
                airports.add(air);
            }
        }
    }

}