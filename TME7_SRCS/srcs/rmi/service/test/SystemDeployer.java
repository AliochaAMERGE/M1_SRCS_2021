package srcs.rmi.service.test;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import org.junit.After;
import org.junit.Before;

import srcs.rmi.service.Host;
import srcs.rmi.service.Hote;

public class SystemDeployer implements Remote {
	Registry rmiregistry = null;
	final String host1 = "host1";
	final String host2 = "host2";

	@Before
	public void deploy() {
		try {
			int port = 1099;

			rmiregistry = LocateRegistry.createRegistry(port);

			Host hote1 = new Hote();

			UnicastRemoteObject.exportObject(hote1, 0);

			Host hote2 = new Hote();

			UnicastRemoteObject.exportObject(hote2, 0);

			rmiregistry.bind(host1, hote1);
			rmiregistry.bind(host2, hote2);

		} catch (RemoteException | AlreadyBoundException e) {
			e.printStackTrace();
		}

	}

	@After
	public void annuleDeploy() {
		try {
			rmiregistry.unbind(host1);
			rmiregistry.unbind(host2);

			UnicastRemoteObject.unexportObject(rmiregistry, true);

		} catch (RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}
}