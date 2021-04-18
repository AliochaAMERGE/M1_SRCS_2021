package srcs.restlet.client;

import java.io.IOException;

import org.restlet.Application;
import org.restlet.data.MediaType;
import org.restlet.data.Status;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;
import org.restlet.resource.Delete;
import org.restlet.resource.ResourceException;

import srcs.restlet.annuaire.Annuaire;
import srcs.restlet.annuaire.Etudiant;

public class Client extends ClientResource {
    public static void main(String[] args) throws ResourceException, IOException {

        ClientResource client = new ClientResource("http://localhost:8585/annuaire/etudiants/56423");
        client.get().write(System.out);

        client.accept(MediaType.APPLICATION_JSON);
        Representation r = client.get();
        JacksonRepresentation<Etudiant> jr = new JacksonRepresentation<>(r, Etudiant.class);
        Etudiant e = jr.getObject();
        System.out.println(e.getId());
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
}
