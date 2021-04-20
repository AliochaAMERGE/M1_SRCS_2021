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
import srcs.webservices.Util;
import srcs.webservices.airline.scheme.Airport;

public class AdminAirportResource extends ServerResource {
    // - POST ou PUT -> ajoute un aeroport
    // - GET -> recupere la liste des aeroport desservis par la compagnie

    @Get("xml|json")
    public List<Airport> request() {
        Application app = this.getApplication();

        if (!(app instanceof SRCSWebService)) {
            throw new ResourceException(Status.SERVER_ERROR_INTERNAL);
        }

        return Util.allairports;
    }

    @Post("json")
    public Representation ajouterPost(Representation r) throws IOException { // ajouter des aéroports à la base de
                                                                             // données

        List<Airport> airports = Arrays.asList(new JacksonRepresentation<Airport[]>(r, Airport[].class).getObject());

        Application app = this.getApplication();

        if (!(app instanceof SRCSWebService)) {
            throw new ResourceException(Status.SERVER_ERROR_INTERNAL);
        }

        for (Airport a : airports) {
            Util.allairports.add(a);
        }

        return r;
    }

    @Put("json")
    public Representation ajouterPut(Representation r) throws IOException { // ajouter des aéroports à la base de
                                                                            // données

        ajouterPost(r);

        return r;
    }

}
