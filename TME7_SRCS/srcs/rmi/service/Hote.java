package srcs.rmi.service;

import java.util.List;
import java.util.Map;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.rmi.NoSuchObjectException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;

public class Hote implements Host {

	@SuppressWarnings("rawtypes")
	Map<String, FunctionService> services = new HashMap<>();

	@Override
	public <P extends Serializable, R extends Serializable> FunctionService<P, R> deployNewService(
			String name, Class<? extends FunctionService<P, R>> classService)
			throws RemoteException {

		try {
			if (services.containsKey(name)) {
				throw new RemoteException();
			}
			
			FunctionService<P, R> myService = classService
					.getConstructor(String.class).newInstance(name);

			UnicastRemoteObject.exportObject(myService, 0);

			services.put(name, myService);

			return myService;

		} catch (InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public <P extends Serializable, R extends Serializable> FunctionService<P, R> deployExistingService(
			FunctionService<P, R> service) throws RemoteException {

		this.services.put(service.getName(), service);

		try {
			
			UnicastRemoteObject.exportObject(service, 0);
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		return service;
	}

	@Override
	public boolean undeployService(String name) {
		if (services.containsKey(name)) {
			try {
				UnicastRemoteObject.unexportObject(services.get(name), false);
			} catch (NoSuchObjectException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			services.remove(name);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<String> getServices() {
		return new ArrayList<String>(services.keySet());
	}

}
