package td4;

import java.io.IOException;
import java.net.Socket;

public class Job implements Runnable {

	private final Socket client;
	
	public Job(Socket client) {
		this.client=client;
	}

	@Override
	public void run() {
		//traitement de la requete client
		//ce que fait une requete
		try {
			client.close();
		} catch (IOException e) {
		}		
	}
	
	
	
}
