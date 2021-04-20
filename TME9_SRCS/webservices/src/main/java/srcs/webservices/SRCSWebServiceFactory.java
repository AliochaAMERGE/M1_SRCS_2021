package srcs.webservices;

import org.restlet.Component;
import org.restlet.Restlet;
import org.restlet.data.Protocol;
import org.restlet.routing.Router;

import srcs.webservices.resource.AdminAircraftResource;
import srcs.webservices.resource.AdminAirportResource;
import srcs.webservices.resource.AdminFlightResource;
import srcs.webservices.resource.AdminPassengerResource;
import srcs.webservices.resource.AdminPassengersResource;
import srcs.webservices.resource.AdminPlaceResource;
import srcs.webservices.resource.AircraftsResource;
import srcs.webservices.resource.AirportResource;
import srcs.webservices.resource.FlightsResource;

public class SRCSWebServiceFactory implements SRCSWebService {

    private String name;
    private int portuser;
    private int portadmin;
    private Component c;

    public SRCSWebServiceFactory(String name, int portuser, int portadmin) {
        this.name = name;
        this.portuser = portuser;
        this.portadmin = portadmin;
        this.c = new Component();

    }

    public static SRCSWebService buildAirline(String name, int portuser, int portadmin) {

        return new SRCSWebServiceFactory(name, portuser, portadmin);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void deploy() throws Exception { // permet de DEMARRER le webservice
        // Component c = new Component();
        c.getServers().add(Protocol.HTTP, portuser);
        c.getServers().add(Protocol.HTTP, portadmin);
        c.start(); // démarrage des services

    }

    @Override
    public void undeploy() throws Exception { // permet d’ARRETER le webservice

        c.stop(); // arret des services
    }

    public Restlet createInboundRoot() {

        Router router = new Router();

        // admin's routes
        router.attach("/admin/airports", AdminAirportResource.class);
        router.attach("/admin/aircrafts", AdminAircraftResource.class);
        router.attach("/admin/flights", AdminFlightResource.class);
        router.attach("/admin/flight/{id_vol}/passenger", AdminPassengerResource.class);
        router.attach("/admin/flight/{id_vol}/passengers", AdminPassengersResource.class);
        router.attach("/admin/flight/{id_vol}/place", AdminPlaceResource.class);
        // users' routes
        router.attach("/airports", AirportResource.class);
        router.attach("/aircrafts", AircraftsResource.class);
        router.attach("/flights", FlightsResource.class);

        return router;
    }

}