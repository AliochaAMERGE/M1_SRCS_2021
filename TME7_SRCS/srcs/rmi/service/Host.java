package srcs.rmi.service;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Host extends Remote {
	
	public <P extends Serializable, R extends Serializable> FunctionService<P, R> deployNewService(
			String name, Class<? extends FunctionService<P, R>> service) throws RemoteException;

	public <P extends Serializable, R extends Serializable> FunctionService<P, R> deployExistingService(
			FunctionService<P, R> service) throws RemoteException;

	public boolean undeployService(String name) throws RemoteException;

	public List<String> getServices() throws RemoteException;
}
