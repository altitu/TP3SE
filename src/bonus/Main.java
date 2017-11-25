package bonus;
import java.util.ArrayList;

public class Main {
	
	private final static int nbClients = 400;
	
	public static void main(String args[]) {
		SwimmingPool swimmingPool = new SwimmingPool();
		ArrayList<Thread> clientThreadArray = new ArrayList<Thread>();
		
		// Creates a thread for each client
		for (int i=0;i<nbClients;++i) {
			Thread thread = new Thread(new Client(swimmingPool, i));
			clientThreadArray.add(thread);
		}
		
		// Start all threads
		for (int i=0;i<nbClients;++i) {
			clientThreadArray.get(i).start();
		}
		
		// Waits for threads to terminate
		for (Thread thread : clientThreadArray) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("Everyone left!");
	}
}
