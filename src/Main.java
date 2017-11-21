import java.util.ArrayList;

public class Main {
	
	private final static int nbClients = 40;
	
	public static void main(String args[]) {
		Piscine piscine = new Piscine();
		ArrayList<Thread> clientThreadArray = new ArrayList<Thread>();
		// Crée et lance un thread par client
		for (int i=0; i <nbClients; i++) {
			Thread thread = new Thread(new Client(piscine, i));
			thread.start();
			clientThreadArray.add(thread);
		}
		
		// Attend la fin des threads
		for (Thread thread : clientThreadArray) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("Il n'y a plus personne !");
	}
}
