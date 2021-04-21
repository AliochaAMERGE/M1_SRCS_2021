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
import srcs.webservices.Util;
import srcs.webservices.airline.scheme.Airport;

public class AdminAirportResource extends ServerResource {

    // - POST ou PUT -> ajoute un aeroport
    // - GET -> recupere la liste des aeroport desservis par la compagnie

    @Get("xml|json")
    public List<Airport> request() {

        Application app = this.getApplication();

        if (!(app instanceof SRCSWebServiceFactory)) {
            throw new ResourceException(Status.SERVER_ERROR_INTERNAL);
        }

        SRCSWebService service = (SRCSWebService) app;

        System.out.println(this.getRequest().getClientInfo().getPort());

        if (this.getRequest().getClientInfo().getPort() != service.getAdminPort()) {
            throw new ResourceException(Status.CLIENT_ERROR_NOT_FOUND);
        }

        return Util.allairports;
    }

    @Post("json")
    public Representation ajouterPost(Representation r) throws IOException {
        // ajouter des aéroports à la base de données

        System.out.println(this.getRequest().getClientInfo().getPort());

        Application app = this.getApplication();

        System.out.println(app.getClass().getName());
        System.out.println(app.getName());

        System.out.println("tu es SRCSWebServiceFactory ? " + (app instanceof SRCSWebService));

        if (!(app instanceof SRCSWebServiceFactory)) {
            System.out.println("throw");
            throw new ResourceException(Status.SERVER_ERROR_INTERNAL);
        }

        SRCSWebServiceFactory service = (SRCSWebServiceFactory) app;

        if (this.getRequest().getClientInfo().getPort() != service.getAdminPort()) {
            throw new ResourceException(Status.CLIENT_ERROR_NOT_FOUND);
        }

        List<Airport> airports = Arrays.asList(new JacksonRepresentation<Airport[]>(r, Airport[].class).getObject());

        for (Airport a : airports) {
            Util.allairports.add(a);
        }

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

        if (this.getRequest().getClientInfo().getPort() != service.getAdminPort()) {
            throw new ResourceException(Status.CLIENT_ERROR_NOT_FOUND);
        }

        List<Airport> airports = Arrays.asList(new JacksonRepresentation<Airport[]>(r, Airport[].class).getObject());

        for (Airport a : airports) {
            Util.allairports.add(a);
        }

        return r;
    }

}
