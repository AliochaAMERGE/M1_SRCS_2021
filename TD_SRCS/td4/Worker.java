package td4;

public class Worker extends Thread{
	
	private final Tampon tampon;
	private static int cpt=0;
	private final int id;
	
	public Worker(Tampon tampon) {
		this.tampon=tampon;
		this.id=cpt++;
	}
	
	public void run() {
		try {
			while(!Thread.currentThread().isInterrupted()) {
				Job j=tampon.get();
				j.run();
			}
		}catch(InterruptedException e) {
			System.out.println("Fin du Worker "+id);
		}
		
	}
}
