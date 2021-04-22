package srcs.webservices.resource;

import java.io.IOException;
import java.util.Arrays;
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
import srcs.webservices.airline.scheme.Airport;
import srcs.webservices.database.AirportsDB;

public class AdminAirportResource extends ServerResource {

    // - POST ou PUT -> ajoute un aeroport
    // - GET -> recupere la liste des aeroport desservis par la compagnie

    @Get("xml|json")
    public Representation request() {

        Application app = this.getApplication();

        if (!(app instanceof SRCSWebServiceFactory)) {
            throw new ResourceException(Status.SERVER_ERROR_INTERNAL);
        }

        SRCSWebService service = (SRCSWebService) app;
        int port = Integer.parseInt(getHostRef().toString().substring(17));

        if (port != service.getAdminPort()) {
            throw new ResourceException(Status.CLIENT_ERROR_NOT_FOUND);
        }
        Representation rep = new JacksonRepresentation<List<Airport>>(AirportsDB.getAirports());
        
        return new JacksonRepresentation<Airport[]>(rep, Airport[].class);
    }

    @Post("json")
    public Representation ajouterPost(Representation r) throws IOException {
        // ajouter des aéroports à la base de données

        Application app = this.getApplication();

        if (!(app instanceof SRCSWebServiceFactory)) {
            throw new ResourceException(Status.SERVER_ERROR_INTERNAL);
        }

        SRCSWebServiceFactory service = (SRCSWebServiceFactory) app;

        int port = Integer.parseInt(getHostRef().toString().substring(17));

        if (port != service.getAdminPort()) {
            System.out.println("ligne 61 dans ajouterPost AdminAirportResource");
            throw new ResourceException(Status.CLIENT_ERROR_NOT_FOUND);
        }

        List<Airport> airportsPost = Arrays
                .asList(new JacksonRepresentation<Airport[]>(r, Airport[].class).getObject());

        AirportsDB.setAirports(airportsPost);

        return r;
    }

    @Put("json")
    public Representation ajouterPut(Representation r) throws IOException {
        // ajouter des aéroports à la base de données

        Application app = this.getApplication();

        if (!(app instanceof SRCSWebServiceFactory)) {
            throw new ResourceException(Status.SERVER_ERROR_INTERNAL);
        }

        SRCSWebServiceFactory service = (SRCSWebServiceFactory) app;

        int port = Integer.parseInt(getHostRef().toString().substring(17));

        if (port != service.getAdminPort()) {
            throw new ResourceException(Status.CLIENT_ERROR_NOT_FOUND);
        }

        List<Airport> airportsPut = Arrays.asList(new JacksonRepresentation<Airport[]>(r, Airport[].class).getObject());

        AirportsDB.addAirports(airportsPut);

        return r;
    }

}
