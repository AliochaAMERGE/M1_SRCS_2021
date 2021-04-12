package srcs.rmi.concurrent;

import java.io.Serializable;
import java.rmi.RemoteException;

public class SharedVariableClassical<T extends Serializable> implements SharedVariable<T> {

	private T var;
	private boolean isAvailable;
	

	public SharedVariableClassical(T var) throws RemoteException {
		this.var = var;
		this.isAvailable = true;
	}

	@Override
	public synchronized T obtenir() throws RemoteException {
		
		try {
			// while not available
			while(! this.isAvailable) {
				wait();
			}
			// object is taken, not available anymore
			isAvailable = false;
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return var;
		
	}

	@Override
	public synchronized void relacher(T arg) throws RemoteException {

		this.var = arg;
		isAvailable = true;
		notify();
		
	}

}
