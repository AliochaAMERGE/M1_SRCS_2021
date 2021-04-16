package srcs.restlet.annuaire;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.restlet.Application;
import org.restlet.Component;
import org.restlet.Restlet;
import org.restlet.data.Protocol;
import org.restlet.data.Status;
import org.restlet.resource.Get;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;
import org.restlet.routing.Router;

// extends org.restlet.Application
public class Annuaire extends Application {

    private Map<String, Etudiant> annuaire = new ConcurrentHashMap<>();

    public Annuaire() {
        getAnnuaire().put("45652", new Etudiant("45652", "Macron", "Emmanuel", "0956874123"));
        getAnnuaire().put("56423", new Etudiant("56423", "Seize", "Louis", "0864287951"));
        getAnnuaire().put("78951", new Etudiant("78951", "Chirac", "Jacques", "0864287951"));
        getAnnuaire().put("89546", new Etudiant("89546", "Sarkozy", "Nicolas", "0978654123"));
    }

    public Map<String, Etudiant> getAnnuaire() {
        return annuaire;
    }

    public void setAnnuaire(Map<String, Etudiant> annuaire) {
        this.annuaire = annuaire;
    }

    @Override
    public Restlet createInboundRoot() {
        Router res = new Router();
        res.attach("/etudiants/{id}", EtudiantResource.class);
        return res;
    }

    public static void main(String[] args) throws Exception {

        Component c = new Component();
        c.getServers().add(Protocol.HTTP, 8585);
        c.getDefaultHost().attach("/annuaire", new Annuaire());
        c.start();
    }

    static class All extends ServerResource {

        @Get("xml|json")
        public Map<String, Etudiant> request() {

            Application app = this.getApplication();

            if (!(app instanceof Annuaire)) {
                throw new ResourceException(Status.SERVER_ERROR_INTERNAL);
            }

            Annuaire a = (Annuaire) getApplication();

            return a.getAnnuaire();
        }
    }

    static class EtudiantResource extends ServerResource {

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
    }
}