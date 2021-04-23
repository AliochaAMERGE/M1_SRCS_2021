package srcs.webservices.resource;

import java.io.IOException;

import org.restlet.Application;
import org.restlet.data.Form;
import org.restlet.data.Status;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

import srcs.webservices.SRCSWebServiceFactory;
import srcs.webservices.airline.scheme.Flight;
import srcs.webservices.airline.scheme.Passenger;
import srcs.webservices.database.FlightsDB;

public class AdminPlaceResource extends ServerResource {

    @Get("xml|json")
    public String request(Representation r) throws IOException {

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

        Form queryParams = getQuery();
        String firstName = queryParams.getFirstValue("firstname");
        String lastName = queryParams.getFirstValue("lastname");

        for (Flight f : FlightsDB.getFlights()) {
            if (f.getId().equals(id_vol)) {
                for (Passenger pa : f.getPassengers()) {
                    if (pa.getFirstName().equals(firstName) && pa.getLastName().equals(lastName)) {
                        System.out.println(f.getPlace(pa));
                        
                        return f.getPlace(pa);
                    }
                }
            }
        }

        throw new ResourceException(Status.CLIENT_ERROR_NOT_FOUND);
    }
}
