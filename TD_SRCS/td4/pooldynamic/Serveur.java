package td4.pooldynamic;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import td4.Job;
import td4.Tampon;

public class Serveur {

	
	private static final int minidle = 3;
	private static final int maxidle = 8;
	private static final int maxthread = 20;
	
	public static void main(String[] args) {
		Tampon tampon = new Tampon();
		
		DynamicPool pool = new DynamicPool(tampon, minidle, maxidle, maxthread);
				
		try(ServerSocket ecoute = new ServerSocket(4545)){
			while(!Thread.currentThread().isInterrupted()) {
				Socket connexion = ecoute.accept();
				tampon.put(new Job(connexion));
			}
			
		}catch(IOException e) {
			
		}finally {
			
		}
		
		
		
	}

}
