package td4.pooldynamic;

import td4.Job;

public class Worker extends Thread{
	
	private final DynamicPool pool;
	private static int cpt=0;
	private final int id;
	
	public Worker(DynamicPool pool) {
		this.pool=pool;
		this.id=cpt++;
	}
	
	public void run() {
		try {
			while(!Thread.currentThread().isInterrupted()) {
				Job j=pool.begin(this);
				j.run();
				pool.end(this);
			}
		}catch(InterruptedException e) {
			System.out.println("Fin du Worker "+id);
		}
		
	}
}
