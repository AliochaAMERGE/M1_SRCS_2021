package srcs.webservices;

import org.restlet.Application;
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

public class SRCSWebServiceFactory extends Application implements SRCSWebService {

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
    public Restlet createInboundRoot() {

        Router router = new Router();

        router.attach("/airports", AirportResource.class);
        router.attach("/admin/airports", AdminAirportResource.class);

        router.attach("/admin/aircrafts", AdminAircraftResource.class);
        router.attach("/aircrafts", AircraftsResource.class);

        router.attach("/admin/flights", AdminFlightResource.class);
        router.attach("/admin/flights?from={from}", AdminFlightResource.class);
        router.attach("/admin/flights?to={to}", AdminFlightResource.class);
        router.attach("/admin/flights?from={from}&to={to}", AdminFlightResource.class);

        router.attach("/flights", FlightsResource.class);
        router.attach("/flights?from={from}", FlightsResource.class);
        router.attach("/flights?to={to}", FlightsResource.class);
        router.attach("/flights?from={from}&to={to}", FlightsResource.class);

        router.attach("/admin/flight/{id_vol}/passenger", AdminPassengerResource.class);
        router.attach("/admin/flight/{id_vol}/passenger?place={place}", AdminPassengerResource.class);
        // /admin/flight/"+f.getId()+"/passenger?place=P"+j
        // /admin/flight/"+f.getId()+"/passenger?place=PlaceToto
        router.attach("/admin/flight/{id_vol}/passengers", AdminPassengersResource.class);



        router.attach("/admin/flight/{id_vol}/place", AdminPlaceResource.class);
        router.attach("/admin/flight/{id_vol}/place?firstname={firstname}&lastname={lastname}", AdminPlaceResource.class);
        // /admin/flight/"+f.getId()+"/place?firstname="+p.getFirstName()+"&lastname="+p.getLastName()

        router.setDefaultMatchingQuery(true); // ! a verifier si ca fonctionne sans cette ligne
        return router;
    }

    @Override
    public void deploy() throws Exception {
        c.getServers().add(Protocol.HTTP, portadmin);
        c.getServers().add(Protocol.HTTP, portuser);
        c.getDefaultHost().attach(this);
        c.start();
    }

    @Override
    public void undeploy() throws Exception { // permet d’ARRETER le webservice
        c.stop(); // arret des services
    }

    @Override
    public int getAdminPort() {
        return portadmin;
    }

    @Override
    public int getUserPort() {
        return portuser;
    }

}