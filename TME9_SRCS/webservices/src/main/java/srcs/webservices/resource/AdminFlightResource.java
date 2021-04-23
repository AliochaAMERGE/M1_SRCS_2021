package srcs.webservices.resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.restlet.Application;
import org.restlet.data.Form;
import org.restlet.data.Status;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.Put;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

import srcs.webservices.SRCSWebService;
import srcs.webservices.SRCSWebServiceFactory;
import srcs.webservices.airline.scheme.Flight;
import srcs.webservices.database.FlightsDB;

public class AdminFlightResource extends ServerResource {

    // - POST ou PUT -> ajouter un nouveau vol à la base de données.
    // - GET -> récupérer la liste des vols existant dans la base.

    @Get("xml|json")
    public List<Flight> request() {

        Application app = this.getApplication();

        if (!(app instanceof SRCSWebServiceFactory)) {
            throw new ResourceException(Status.SERVER_ERROR_INTERNAL);
        }

        SRCSWebService service = (SRCSWebService) app;
        int port = Integer.parseInt(getHostRef().toString().substring(17));

        if (port != service.getAdminPort()) {
            throw new ResourceException(Status.CLIENT_ERROR_NOT_FOUND);
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

        Application app = this.getApplication();

        if (!(app instanceof SRCSWebServiceFactory)) {
            throw new ResourceException(Status.SERVER_ERROR_INTERNAL);
        }

        SRCSWebService service = (SRCSWebService) app;
        int port = Integer.parseInt(getHostRef().toString().substring(17));

        if (port != service.getAdminPort()) {
            throw new ResourceException(Status.CLIENT_ERROR_NOT_FOUND);
        }

        JacksonRepresentation<Flight> jr = new JacksonRepresentation<>(r, Flight.class);
        Flight f = jr.getObject();

        if (!FlightsDB.add(f)) {
            throw new ResourceException(Status.CLIENT_ERROR_PRECONDITION_FAILED);
        }

    }

    @Put("json")
    public void ajouterPut(Representation r) throws IOException {

        Application app = this.getApplication();

        if (!(app instanceof SRCSWebServiceFactory)) {
            throw new ResourceException(Status.SERVER_ERROR_INTERNAL);
        }

        SRCSWebService service = (SRCSWebService) app;
        int port = Integer.parseInt(getHostRef().toString().substring(17));

        if (port != service.getAdminPort()) {
            throw new ResourceException(Status.CLIENT_ERROR_NOT_FOUND);
        }

        JacksonRepresentation<Flight> jr = new JacksonRepresentation<>(r, Flight.class);
        Flight f = jr.getObject();

        if (!FlightsDB.add(f)) {
            throw new ResourceException(Status.CLIENT_ERROR_PRECONDITION_FAILED);
        }

    }

}
