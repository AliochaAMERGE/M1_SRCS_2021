package srcs.rmi.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.rmi.RemoteException;

public abstract class AbstractFunctionService<P extends Serializable, R extends Serializable>
		implements
			FunctionService<P, R> {
	private static final long serialVersionUID = 1L;
	private final String name;
	private boolean alreadyMigrated;
	private FunctionService<P, R> migratedService;

	public AbstractFunctionService(String name) {
		this.name = name;
		alreadyMigrated = false;
	}

	@Override
	public String getName() {

		return name;
	}

	@Override
	public synchronized R invoke(P param) throws RemoteException {

		if (alreadyMigrated) {
			return migratedService.invoke(param);
		} else {
			return perform(param);
		}
	}

	@Override
	public synchronized FunctionService<P, R> migrateTo(Host host)
			throws RemoteException {

		if (alreadyMigrated)
			throw new RemoteException();

		try {
			ObjectOutputStream oos = new ObjectOutputStream(
					new FileOutputStream("temp_SRCS_tme7"));
			ObjectInputStream ois = new ObjectInputStream(
					new FileInputStream("temp_SRCS_tme7"));
			oos.writeObject(this);
			@SuppressWarnings("unchecked")
			FunctionService<P, R> objPaste = (FunctionService<P, R>) ois
					.readObject();
			oos.close();
			ois.close();
			migratedService = host.deployExistingService(objPaste);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		alreadyMigrated = true;
		return migratedService;

	}

	protected abstract R perform(P param);
}
