package srcs.webservices.resource;

import java.io.IOException;

import org.restlet.data.Status;
import org.restlet.representation.Representation;
import org.restlet.resource.Post;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

public class FlightsResource extends ServerResource {

    @Post("json")
    public void ajouterPost(Representation r) throws IOException {
        throw new ResourceException(Status.CLIENT_ERROR_METHOD_NOT_ALLOWED);
    }

}
