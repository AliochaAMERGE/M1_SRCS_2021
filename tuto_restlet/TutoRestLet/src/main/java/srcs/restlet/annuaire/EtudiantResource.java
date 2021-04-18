package srcs.restlet.annuaire;

import java.io.IOException;

import org.restlet.Application;
import org.restlet.data.Status;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

public class EtudiantResource extends ServerResource {

    @Get("xml|json")
    public Etudiant request() {
        Application app = this.getApplication();
        if (!(app instanceof Annuaire)) {
            throw new ResourceException(Status.SERVER_ERROR_INTERNAL);
        }
        Annuaire a = (Annuaire) getApplication();
        Object id = getRequest().getAttributes().get("id");
        if (!a.getAnnuaire().containsKey(id)) {
            throw new ResourceException(Status.CLIENT_ERROR_NOT_FOUND);
        }
        return a.getAnnuaire().get(id);
    }

    @Delete
    public void supprimer() {
        Application app = this.getApplication();
        if (!(app instanceof Annuaire)) {
            throw new ResourceException(Status.SERVER_ERROR_INTERNAL);
        }

        Annuaire a = (Annuaire) getApplication();
        Object id = getRequest().getAttributes().get("id");
        if (!a.getAnnuaire().containsKey(id)) {
            throw new ResourceException(Status.CLIENT_ERROR_NOT_FOUND);
        }
        a.getAnnuaire().remove(id);
    }

    @Post("json")
    public void ajouter(Representation r) throws IOException {
        JacksonRepresentation<Etudiant> jr = new JacksonRepresentation<Etudiant>(r, Etudiant.class);
        Etudiant e = jr.getObject();
        Application app = this.getApplication();
        if (!(app instanceof Annuaire)) {
            throw new ResourceException(Status.SERVER_ERROR_INTERNAL);
        }
        Annuaire a = (Annuaire) getApplication();
        Object id = getRequest().getAttributes().get("id");
        if (!id.equals(e.getId())) {
            throw new ResourceException(Status.CLIENT_ERROR_CONFLICT);
        }
        a.getAnnuaire().put(id.toString(), e);
    }

}
