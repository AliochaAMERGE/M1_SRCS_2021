package srcs.rmi.concurrent;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.Timer;
import java.util.TimerTask;

public class SharedVariableReliable<T extends Serializable>
		implements
			SharedVariable<T> {

	private T var;
	private boolean isAvailable;
	private Timer timer = new Timer();

	public SharedVariableReliable(T var) throws RemoteException {
		this.var = var;
		isAvailable = true;
	}

	@Override
	public synchronized T obtenir() throws RemoteException {
		try {
			while (!isAvailable) {
				wait();
			}
			isAvailable = false;
			timer.schedule(new TimerTask() {
				public void run() {
					try {
						relacher(var);
					} catch(RemoteException e) {
						e.printStackTrace();
					}
				}
			},2500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return var;
	}

	@Override
	public synchronized void relacher(T arg) throws RemoteException {
		this.var = arg;
		isAvailable = true;
		timer.cancel();
		timer = new Timer();
		notify();
	}

}
