package part2;

import java.util.ArrayList;
import java.util.List;

public class ReceptionCounters {
	
	private final int time = 5;
	private final int nbCounters = 2;
	// Disponibilité des guichets
	private List<Boolean> counters = new ArrayList<>();
	
	public ReceptionCounters() {
		// Tous les guichets sont libres
		for (int i=0;i<nbCounters;++i)
			counters.add(false);
	}
	
	private boolean all(List<Boolean> a) {
		for (boolean a1 : a) {
			if (!a1) return false;
		}
		return true;
	}
	
	public synchronized int waitInLine(int num) {
		// Attendre si tous les guichets sont occupés
		if (all(counters)) {
			System.out.println("The client #" + num + " waits in line");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// Quand un se libère, le prendre (ou prendre le premier si les deux sont dispo)
		for (int i=0;i<nbCounters;++i) {
			if (!counters.get(i)) {
				counters.set(i, true);
				return i;
			}
		}
		return -1;
	}
	
	public void buyTicket(int num, int counter) {
		System.out.println("The client #" + num + " buys a ticket at the counter #" + counter);
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public synchronized void leaveCounter(int num, int counter) {
		// Libérer le guichet
		counters.set(counter, false);
		notify();
		System.out.println("The client #" + num + " leaves the counter #" + counter);
	}
}
