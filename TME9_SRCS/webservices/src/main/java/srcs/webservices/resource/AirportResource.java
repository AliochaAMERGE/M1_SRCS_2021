package srcs.webservices.resource;

import java.io.IOException;
import java.util.List;

import org.restlet.Application;
import org.restlet.data.Status;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

import srcs.webservices.SRCSWebService;
import srcs.webservices.airline.scheme.Airport;
import srcs.webservices.database.AirportsDB;

public class AirportResource extends ServerResource {

    // - POST -> 405
    // - GET -> recupere la liste des aeroport desservis par la compagnie

    @Post("json")
    public void ajouterPost(Representation r) throws IOException {
        // ajouter des aéroports à la base de données

        throw new ResourceException(Status.CLIENT_ERROR_METHOD_NOT_ALLOWED);
    }

    @Get("xml|json")
    public List<Airport> request() {

        Application app = this.getApplication();

        if (!(app instanceof SRCSWebService)) {
            throw new ResourceException(Status.SERVER_ERROR_INTERNAL);
        }

        return AirportsDB.getAirports();
    }

}
