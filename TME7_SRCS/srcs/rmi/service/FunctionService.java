package srcs.rmi.service;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FunctionService <P extends Serializable, R extends Serializable> extends Remote , Serializable {

    public String getName() throws RemoteException;

    public R invoke(P params) throws RemoteException;

    public FunctionService<P, R> migrateTo(Host host) throws RemoteException;
}
