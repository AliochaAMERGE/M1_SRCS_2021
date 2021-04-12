package srcs.rmi.concurrent;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

/* Il faut que T implément Serializable ou soit de type primitif */

public interface SharedVariable <T extends Serializable> extends Remote {
	
	public T obtenir() throws RemoteException;
	
	public void relacher(T arg) throws RemoteException;
	
}
