import java.net.ServerSocket;
import java.net.Socket;

public class Tampon {

    List<Job> queue;

    public Tampon() {
        queue = new LinkedList<Job>();
    }

    public Tampon(List<Job> queue) {
        this.queue = queue;
    }

    public synchronized boolean put(Job job) {

        queue.add(job);
        if (queue.size() == 1) {
            notifyAll();
        }
    }

    public synchronized Job get() {

        try {
            while (queue.size() == 0) {
                this.wait();
            }
            return queue.remove();
        } catch (InterruptedException e) {
        }
    }

}

public class Job {

    private final Socket clientSocket;

    public void run() {

        try {
            system.out.println("je travaille");
            clientSocket.close();
        } catch (Exception e) {
        }
    }
}

public class Worker extends Thread {

    Tampon tampon;

    public Worker(Tampon tampon) {
        this.tampon = tampon;

    }

    public void run() {

        try {
            while (!Thread.currentThread().isInterrupted) {
                Job j = tampon.get();
                j.run();
            }
        } catch (Exception e) {

        }
    }
}

public class Serveur {

    private static final int N = 5;

    public static void main(String[] args) {
        Worker[] pool = new Worker[N];
        Tampon tampon = new Tampon();

        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                // code a exec en cas de fermeture de la JVM (ctrl-c)
                System.out.println("bye bye");
            }
        });

        for (int i = 0; i < pool.length; i++) {
            pool[i] = new Worker(tampon);
            pool[i].start();
        }

        try (ServerSocket ecoute = new ServerSocket(4545)) {
            while (!Thread.currentThread().isInterrupted()) {
                Socket connect = ecoute.accept();
                tampon.put(new Job(connect));
            }
        } catch (IOException e) {

        } finally {
            for (int i = 0; i < pool.length; i++) {
                pool[i].interrupt();
            }
        }
    }
}
