package srcs.webservices.resource;

import java.io.IOException;
import java.util.List;

import org.restlet.Application;
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
//String toCodeValue = getQueryValue("to"); 
        if (getQuery().contains("to")) {
            String toCode = getQuery().getValues("to");
            if (getQuery().contains("from")) {
                String fromCode = getQuery().getValues("from");
                return FlightsDB.getToFrom(toCode, fromCode);
            }
            return FlightsDB.getTo(toCode);
        } else // query contenant seulement from
        if (getQuery().contains("from")) {
            String fromCode = getQuery().getValues("from");
            return FlightsDB.getFrom(fromCode);
        }
        return FlightsDB.getFlights();
    }

    @Post("json")
    public Representation ajouterPost(Representation r) throws IOException {

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

        return r;
    }

    @Put("json")
    public Representation ajouterPut(Representation r) throws IOException {

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

        return r;
    }

}
