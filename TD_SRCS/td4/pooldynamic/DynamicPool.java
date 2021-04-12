package td4.pooldynamic;

import java.util.LinkedList;
import java.util.List;

import td4.Job;
import td4.Tampon;


public class DynamicPool {

	private final Tampon tampon;
	
	private final List<Worker> idle = new LinkedList<>();
	private final List<Worker> working = new LinkedList<>();
	
	private final int minidle,maxidle, maxthread;
	
	
	public DynamicPool(Tampon tampon, int minidle, int maxidle, int maxthread ) {
		this.tampon=tampon;
		this.minidle=minidle;
		this.maxidle=maxidle;
		this.maxthread=maxthread;
		checkstate();
	}
	
	public synchronized Job begin(Worker w) throws InterruptedException {
		Job res = tampon.get();
		
		idle.remove(w);
		working.add(w);
		checkstate();
	
		return res;
	}
	
	public synchronized void end(Worker w) {
		working.remove(w);
		idle.add(w);
		checkstate();
	}
	
	// minidle <= idle.size <= maxidle
	// minidle <= idle.size+working.size <= maxthread
	private synchronized void checkstate() {
		//suis-je sous-dimensionné
		while(idle.size() < minidle &&  idle.size()+working.size() < maxthread) {
			Worker w = new Worker(this);
			idle.add(w);
			w.start();
		}
		
		//suis-je sur-dimensionné
		
		while(idle.size() > maxidle) {
			idle.remove(0).interrupt();
		}
	}
	
}
