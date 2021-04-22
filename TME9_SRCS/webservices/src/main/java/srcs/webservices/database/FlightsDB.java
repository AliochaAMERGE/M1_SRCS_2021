package srcs.webservices.database;

import java.util.ArrayList;
import java.util.List;

import srcs.webservices.airline.scheme.Airport;
import srcs.webservices.airline.scheme.Flight;

public class FlightsDB {

    private static List<Flight> flights = new ArrayList<>();

    public static boolean add(Flight flight) {

        // il existe déjà un vol du même identifiant dans la base
        if (FlightsDB.containsId(flight)) {
            System.out.println("containsID");
            return false;
        }
        // l’aéroport de départ n’existe pas ou n’est pas desservi par la compagnie
        // l’aéroport d’arrivée n’existe pas ou n’est pas desservi par la compagnie
        if (!(FlightsDB.airportExist(flight.getTo())) || !(FlightsDB.airportExist(flight.getFrom()))) {
            System.out.println("aiportExist");
            return false;
        }
        // l’avion est déjà utilisé dans un autre vol dont les horaires entrent en
        // confli

        if (FlightsDB.isInConflict(flight)) {
            System.out.println("isInConflict");
            return false;
        }

        flights.add(flight);

        return true;
    }

    public static boolean contains(Flight flight) {

        return flights.contains(flight);
    }

    public static boolean containsId(Flight flight) {

        // il existe déjà un vol du même identifiant dans la base

        for (Flight fli : flights) {
            if (fli.getId() == flight.getId()) {
                return true;
            }
        }
        return false;
    }

    public static boolean airportExist(Airport airport) {
        return AirportsDB.getAirports().contains(airport);
    }

    public static List<Flight> getTo(Airport to) {

        List<Flight> res = new ArrayList<Flight>();
        for (Flight flight : flights) {
            if (flight.getTo().equals(to)) {
                res.add(flight);
            }
        }
        return res;
    }

    public static List<Flight> getFrom(Airport from) {

        List<Flight> res = new ArrayList<Flight>();
        for (Flight flight : flights) {
            if (flight.getFrom().equals(from)) {
                res.add(flight);
            }
        }
        return res;
    }

    public static boolean isInConflict(Flight flight) {

        // si deux vols sont en conflits

        for (Flight fli : flights) {
            if (fli.isInConflict(flight)) {
                return true;
            }
        }
        return false;
    }

}
