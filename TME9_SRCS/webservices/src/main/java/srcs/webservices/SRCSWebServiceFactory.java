package srcs.webservices;

public class SRCSWebServiceFactory implements SRCSWebService {

    private String name;

    public SRCSWebServiceFactory() {
        
    }

    public static SRCSWebService buildAirline(String name, int portuser, int portadmin) {
        return null;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void deploy() throws Exception {

    }

    @Override
    public void undeploy() throws Exception {

    }

}