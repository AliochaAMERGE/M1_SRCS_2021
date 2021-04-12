package srcs.service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServeurMultithread {

	private final int port;
	private final Class<? extends Service> service;
	private Service current_service;

	public ServeurMultithread(int port, Class<? extends Service> service) {
		this.port = port;
		this.service = service;
		this.current_service = null;

	}

	public void listen()  {
		try {
			ServerSocket ss = new ServerSocket(port);
			// c'est une boucle infinie
			while (!Thread.currentThread().isInterrupted()) {
//			while (true) {
				Socket connect = ss.accept();
				Service s = this.getService();
				Thread t = new Thread(() -> {
					s.execute(connect);
				});
				t.start();
			}
			ss.close();
		}catch(IllegalStateException e) {
			throw new IllegalStateException();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private Service getService() {
		try {
			if (service.getAnnotation(SansEtat.class) != null) {
				return service.getConstructor().newInstance();
			}
			if (service.getAnnotation(EtatGlobal.class) != null) {
				if (current_service == null) {
					current_service = service.getConstructor().newInstance();
				}
				return current_service;
			}
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		throw new IllegalStateException();
	}

}
