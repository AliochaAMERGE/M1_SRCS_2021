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
import srcs.webservices.airline.scheme.Aircraft;

public class AdminAircraftResource extends ServerResource {

    // - POST ou PUT -> ajoute un avion
    // - GET -> recupere la liste des avions détenu par la compagnie

    @Get("xml|json")
    public List<Aircraft> request() {

        Application app = this.getApplication();

        if (!(app instanceof SRCSWebService)) {
            throw new ResourceException(Status.SERVER_ERROR_INTERNAL);
        }

        SRCSWebService service = (SRCSWebService) app;

        if (this.getRequest().getClientInfo().getPort() != service.getAdminPort()) {
            throw new ResourceException(Status.CLIENT_ERROR_NOT_FOUND);
        }

        return Util.aircrafts;
    }

    @Post("json")
    public Representation ajouterPost(Representation r) throws IOException {
        // ajouter des aéroports à la base de données

        Application app = this.getApplication();

        if (!(app instanceof SRCSWebService)) {
            throw new ResourceException(Status.SERVER_ERROR_INTERNAL);
        }

        SRCSWebService service = (SRCSWebService) app;

        if (this.getRequest().getClientInfo().getPort() != service.getAdminPort()) {
            throw new ResourceException(Status.CLIENT_ERROR_NOT_FOUND);
        }

        List<Aircraft> aircrafts = Arrays
                .asList(new JacksonRepresentation<Aircraft[]>(r, Aircraft[].class).getObject());

        for (Aircraft a : aircrafts) {
            Util.aircrafts.add(a);
        }

        return r;
    }

    @Put("json")
    public Representation ajouterPut(Representation r) throws IOException {
        // ajouter des aéroports à la base de données

        Application app = this.getApplication();

        if (!(app instanceof SRCSWebService)) {
            throw new ResourceException(Status.SERVER_ERROR_INTERNAL);
        }

        SRCSWebService service = (SRCSWebService) app;

        if (this.getRequest().getClientInfo().getPort() != service.getAdminPort()) {
            throw new ResourceException(Status.CLIENT_ERROR_NOT_FOUND);
        }

        List<Aircraft> aircrafts = Arrays
                .asList(new JacksonRepresentation<Aircraft[]>(r, Aircraft[].class).getObject());

        for (Aircraft a : aircrafts) {
            Util.aircrafts.add(a);
        }

        return r;
    }

}
