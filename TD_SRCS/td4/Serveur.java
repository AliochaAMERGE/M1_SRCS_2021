package td4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {

	
	private static final int N = 5;
	
	public static void main(String[] args) {
		Worker[] pool = new Worker[N];
		Tampon tampon = new Tampon();
		
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				System.out.println("Je meurs");
			}
		});
		
		for(int i=0; i <pool.length;i++) {
			pool[i] = new Worker(tampon);
			pool[i].start();
		}
		
		try(ServerSocket ecoute = new ServerSocket(4545)){
			while(!Thread.currentThread().isInterrupted()) {
				Socket connexion = ecoute.accept();
				tampon.put(new Job(connexion));
			}
			
		}catch(IOException e) {
			
		}finally {
			for(int i=0; i <pool.length;i++) {
				pool[i].interrupt();
			}
		}
		
		
		
	}

}
