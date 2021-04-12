package td4;

import java.util.LinkedList;
import java.util.List;

public class Tampon {

	private List<Job> jobs;
	public Tampon() {
		this.jobs=new LinkedList<Job>();
	}
	
	public synchronized void put(Job job) {
        jobs.add(job);
        if(jobs.size() == 1)
        	this.notifyAll();
    
    }
    
    public synchronized  Job get() throws InterruptedException {
    	while(jobs.isEmpty()) {
        	this.wait();
        }
        return jobs.remove(0);
  }
	
}
