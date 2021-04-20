package srcs.webservices;

public interface SRCSWebService {

	// retourne le nom du webservice
	public String getName();

	// démarre le webservice
	public void deploy() throws Exception;

	// arrete le webservice
	public void undeploy() throws Exception;
}
