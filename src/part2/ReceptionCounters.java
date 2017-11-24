package part2;

import java.util.ArrayList;
import java.util.List;

public class ReceptionCounters {
	
	/// Time for buying a ticket
	private int time;
	/// Number of counters
	private int nbCounters;
	
	/// Availability of counters (boolean at counter[i] means counter #i is busy) 
	private List<Boolean> counters = new ArrayList<>();
	
	/**
	 * Create new reception counters
	 * @param nbCounters number of counters
	 * @param time time to buy a ticket
	 */
	public ReceptionCounters(int nbCounters, int time) {
		this.nbCounters = nbCounters;
		this.time = time;
		// All counters are available
		for (int i=0;i<nbCounters;++i)
			counters.add(false);
	}
	
	public int getAvailableCounter() {
		for (int i=0;i<nbCounters;++i) {
			if (!counters.get(i)) return i;
		}
		return -1;
	}
	
	/**
	 * A client waits in line for a counter to be available
	 * @param num unique client id
	 * @return the counter the client chose
	 */
	public synchronized int waitInLine(int num) {
		System.out.println("The client #" + num + " waits in line");
		// If all counters are busy, wait 
		// (while wait is required because sometimes threads wake up without being notified)
		int availableCounter = -1;
		while ((availableCounter = getAvailableCounter()) == -1) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// When one counter is available, find which one it is, make it busy and return its id
		counters.set(availableCounter, true);
		return availableCounter;
	}
	
	/**
	 * A client buys a ticket from the counter
	 * @param num unique client id
	 * @param counter counter id
	 */
	public void buyTicket(int num, int counter) {
		System.out.println("The client #" + num + " buys a ticket at the counter #" + counter);
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * A client leaves the counter
	 * @param num unique client id
	 * @param counter counter id
	 */
	public synchronized void leaveCounter(int num, int counter) {
		System.out.println("The client #" + num + " leaves the counter #" + counter);
		// Sets the counter to be available
		counters.set(counter, false);
		// Notify a client waiting for a counter
		notify();
		
	}
}
