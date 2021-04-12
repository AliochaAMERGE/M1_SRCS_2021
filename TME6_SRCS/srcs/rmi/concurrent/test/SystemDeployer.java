package srcs.rmi.concurrent.test;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import org.junit.After;
import org.junit.Before;

import srcs.rmi.concurrent.SharedVariableClassical;
import srcs.rmi.concurrent.SharedVariableReliable;

public class SystemDeployer implements Remote {
	Registry rmiregistry = null;
	final String nameService = "variableIntegerClassical";
	final String nameServiceReliable = "variableIntegerReliable";
	@Before
	public void deploy() {
		try {
			int port = 1099;
			rmiregistry = LocateRegistry.createRegistry(port);

			SharedVariableClassical<Integer> varShared = new SharedVariableClassical<Integer>(
					0);

			UnicastRemoteObject.exportObject(varShared, 0);

			rmiregistry.bind(nameService, varShared);

			SharedVariableReliable<Integer> varSharedReliable = new SharedVariableReliable<Integer>(
					0);
			UnicastRemoteObject.exportObject(varSharedReliable, 0); 

			rmiregistry.bind(nameServiceReliable, varSharedReliable);

		} catch (RemoteException | AlreadyBoundException e) {
			e.printStackTrace();
		}

	}

	@After
	public void annuleDeploy() {
		try {
			rmiregistry.unbind(nameService);

			rmiregistry.unbind(nameServiceReliable);
			UnicastRemoteObject.unexportObject(rmiregistry, true);

		} catch (RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}
}