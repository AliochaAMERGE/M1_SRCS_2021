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
import srcs.webservices.airline.scheme.Flight;
import srcs.webservices.airline.scheme.Flights;

public class AdminFlightResource extends ServerResource {

    // - POST ou PUT -> ajouter un nouveau vol à la base de données.
    // - GET -> récupérer la liste des vols existant dans la base.

    @Get("xml|json")
    public List<Flight> request() {

        // TODO raffiner la recherche
        // extract.extractQuery()

        return null;
    }

    @Post("json")
    public Representation ajouterPost(Representation r) throws IOException {

        Application app = this.getApplication();

        if (!(app instanceof SRCSWebService)) {
            throw new ResourceException(Status.SERVER_ERROR_INTERNAL);
        }

        SRCSWebService service = (SRCSWebService) app;

        if (this.getRequest().getClientInfo().getPort() != service.getAdminPort()) {
            throw new ResourceException(Status.CLIENT_ERROR_NOT_FOUND);
        }

        JacksonRepresentation<Flight> jr = new JacksonRepresentation<>(r, Flight.class);
        Flight f = jr.getObject();

        if (!Flights.add(f)) {
            throw new ResourceException(Status.CLIENT_ERROR_PRECONDITION_FAILED);
        }

        return r; // todo changer ça
    }

    @Put("json")
    public Representation ajouterPut(Representation r) throws IOException {

        Application app = this.getApplication();

        if (!(app instanceof SRCSWebService)) {
            throw new ResourceException(Status.SERVER_ERROR_INTERNAL);
        }

        SRCSWebService service = (SRCSWebService) app;

        if (this.getRequest().getClientInfo().getPort() != service.getAdminPort()) {
            throw new ResourceException(Status.CLIENT_ERROR_NOT_FOUND);
        }

        JacksonRepresentation<Flight> jr = new JacksonRepresentation<>(r, Flight.class);
        Flight f = jr.getObject();

        if (!Flights.add(f)) {
            throw new ResourceException(Status.CLIENT_ERROR_PRECONDITION_FAILED);
        }

        return r; // todo changer ça
    }

}
