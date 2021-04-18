package srcs.restlet.client;

import java.io.IOException;

import org.restlet.data.MediaType;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import srcs.restlet.annuaire.Etudiant;

public class Client extends ClientResource {
    public static void main(String[] args) throws ResourceException, IOException {
        // telecharger les informations d'un étudiant en particulier avec un get
        // et l'afficher sur la console d'un client
        ClientResource client = new ClientResource("http://localhost:8585/annuaire/etudiants/56423");
        client.get().write(System.out);

        // pour transformer une représentation JSON en object Java
        client.accept(MediaType.APPLICATION_JSON);
        Representation r = client.get();
        JacksonRepresentation<Etudiant> jr = new JacksonRepresentation<>(r, Etudiant.class);
        Etudiant e = jr.getObject();

        System.out.println(e.getNom());
        // suppression de l'étudiant Louis XVI
        client.delete();
        // ajout d'un nouvel étudiant
        Etudiant new_e = new Etudiant("56423", "Coty", "Rene", "089657484");
        client.post(new JacksonRepresentation<Etudiant>(new_e));
    }

}
