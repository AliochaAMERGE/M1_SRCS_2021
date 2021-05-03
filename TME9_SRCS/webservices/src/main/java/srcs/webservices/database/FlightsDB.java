package srcs.webservices.database;

import java.util.ArrayList;
import java.util.List;

import srcs.webservices.airline.scheme.Aircraft;
import srcs.webservices.airline.scheme.Airport;
import srcs.webservices.airline.scheme.Flight;

public class FlightsDB {

    private static List<Flight> flights = new ArrayList<Flight>();

    public static List<Flight> getFlights() {
        return flights;
    }

    public static boolean add(Flight flight) {

        // il existe déjà un vol du même identifiant dans la base
        if (FlightsDB.containsFlight(flight)) {
            return false;
        }
        // l’aéroport de départ n’existe pas ou n’est pas desservi par la compagnie
        // l’aéroport d’arrivée n’existe pas ou n’est pas desservi par la compagnie
        if (!(FlightsDB.airportExist(flight.getTo())) || !(FlightsDB.airportExist(flight.getFrom()))) {
            return false;
        }
        // l’avion est déjà utilisé dans un autre vol dont les horaires entrent en
        // confli

        if (FlightsDB.isInConflict(flight)) {
            return false;
        }

        // l'avion utilisé n'existe pas
        
        if (!(FlightsDB.aircraftExist(flight.getAircraft()))) {
            return false;
        }

        flights.add(flight);

        return true;
    }

    private static boolean aircraftExist(Aircraft aircraft) {

        if (AircraftsDB.getAircrafts().contains(aircraft)) {
            return true;
        }
        return false;
    }

    public static boolean containsFlight(Flight flight) {

        // il existe déjà un vol du même identifiant dans la base

        for (Flight fli : flights) {
            if (fli.equals(flight)) {
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

        // l'avion est deja utilisé dans un autre vol ET les horaires sont en conflit
        Aircraft avion = flight.getAircraft();
        for (Flight fli : flights) {
            if (fli.getAircraft().equals(avion)) {
                if (fli.isInConflict(flight)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static List<Flight> getToFrom(String toCode, String fromCode) {

        List<Flight> res = new ArrayList<Flight>();

        for (Flight fli : flights) {
            if ((fli.getTo().getCodeAITA() == toCode) && (fli.getFrom().getCodeAITA() == fromCode)) {
                res.add(fli);
            }
        }

        return res;
    }

    public static List<Flight> getTo(String toCode) {
        List<Flight> res = new ArrayList<Flight>();
        for (Flight fli : flights) {
            if (fli.getTo().getCodeAITA() == toCode) {
                res.add(fli);
            }
        }
        return res;
    }

    public static List<Flight> getFrom(String fromCode) {
        List<Flight> res = new ArrayList<Flight>();
        for (Flight fli : flights) {
            if (fli.getFrom().getCodeAITA() == fromCode) {
                res.add(fli);
            }
        }
        return res;
    }
}
