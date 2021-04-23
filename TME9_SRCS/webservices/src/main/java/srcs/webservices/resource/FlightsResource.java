package srcs.webservices.resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.restlet.Application;
import org.restlet.data.Form;
import org.restlet.data.Status;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

import srcs.webservices.SRCSWebServiceFactory;
import srcs.webservices.airline.scheme.Flight;
import srcs.webservices.database.FlightsDB;

public class FlightsResource extends ServerResource {

    @Get("xml|json")
    public List<Flight> request() {

        Application app = this.getApplication();

        if (!(app instanceof SRCSWebServiceFactory)) {
            throw new ResourceException(Status.SERVER_ERROR_INTERNAL);
        }

        Form queryParams = getQuery();
        String from = queryParams.getFirstValue("from");
        String to = queryParams.getFirstValue("to");

        List<Flight> fl = new ArrayList<Flight>();
        if (from != null) {
            if (to != null) {
                for (Flight f : FlightsDB.getFlights()) {
                    if (f.getFrom().getCodeAITA().equals(from) && f.getTo().getCodeAITA().equals(to)) {
                        fl.add(f);
                    }
                }

                return fl;
            }
            for (Flight f : FlightsDB.getFlights()) {
                if (f.getFrom().getCodeAITA().equals(from)) {
                    fl.add(f);
                }
            }
            return fl;
        } else if (to != null) {
            for (Flight f : FlightsDB.getFlights()) {
                if (f.getTo().getCodeAITA().equals(to)) {
                    fl.add(f);
                }
            }
            return fl;
        }
        return FlightsDB.getFlights();
    }

    @Post("json")
    public void ajouterPost(Representation r) throws IOException {
        throw new ResourceException(Status.CLIENT_ERROR_METHOD_NOT_ALLOWED);
    }

}
