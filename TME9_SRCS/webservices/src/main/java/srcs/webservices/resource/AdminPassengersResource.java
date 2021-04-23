package srcs.webservices.resource;

import java.io.IOException;
import java.util.Set;

import org.restlet.Application;
import org.restlet.data.Status;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

import srcs.webservices.SRCSWebServiceFactory;
import srcs.webservices.airline.scheme.Flight;
import srcs.webservices.airline.scheme.Passenger;
import srcs.webservices.database.FlightsDB;

public class AdminPassengersResource extends ServerResource {

    @Get("xml|json")
    public Set<Passenger> request(Representation r) throws IOException {

        Application app = this.getApplication();

        if (!(app instanceof SRCSWebServiceFactory)) {
            throw new ResourceException(Status.SERVER_ERROR_INTERNAL);
        }

        SRCSWebServiceFactory service = (SRCSWebServiceFactory) app;

        int port = Integer.parseInt(getHostRef().toString().substring(17));

        if (port != service.getAdminPort()) {
            throw new ResourceException(Status.CLIENT_ERROR_NOT_FOUND);
        }

        String id_vol = (String) getRequest().getAttributes().get("id_vol");

        for (Flight f : FlightsDB.getFlights()) {
            if (f.getId().equals(id_vol)) {
                return f.getPassengers();
            }
        }
        // vol non identifier; retourne un ensemble vide
        return null;
    }
}
