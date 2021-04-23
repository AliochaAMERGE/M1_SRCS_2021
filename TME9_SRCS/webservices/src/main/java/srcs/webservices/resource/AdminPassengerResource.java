package srcs.webservices.resource;

import java.io.IOException;

import org.restlet.Application;
import org.restlet.data.Form;
import org.restlet.data.Status;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Post;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

import srcs.webservices.SRCSWebServiceFactory;
import srcs.webservices.airline.scheme.Flight;
import srcs.webservices.airline.scheme.Passenger;
import srcs.webservices.database.FlightsDB;

public class AdminPassengerResource extends ServerResource {

    @Post("json")
    public boolean ajouterPost(Representation r) throws IOException {

        Application app = this.getApplication();

        if (!(app instanceof SRCSWebServiceFactory)) {
            throw new ResourceException(Status.SERVER_ERROR_INTERNAL);
        }

        SRCSWebServiceFactory service = (SRCSWebServiceFactory) app;

        int port = Integer.parseInt(getHostRef().toString().substring(17));

        if (port != service.getAdminPort()) {
            throw new ResourceException(Status.CLIENT_ERROR_NOT_FOUND);
        }

        JacksonRepresentation<Passenger> jr = new JacksonRepresentation<>(r, Passenger.class);
        Passenger p = jr.getObject();

        String id_vol = (String) getRequest().getAttributes().get("id_vol");

        Form queryParams = getQuery();
        String place = queryParams.getFirstValue("place");

        for (Flight f : FlightsDB.getFlights()) {
            if (f.getId().equals(id_vol)) {
                if (!f.full()) {
                    f.addPassenger(p, place);
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
}
