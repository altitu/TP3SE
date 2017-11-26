package bonus;
import java.util.Random;

public class Pool {
	
	/// Maximum number of clients in the pool at the same time
	private int capacity = 3;
	/// Minimum swimming time
	private int timeMin = 40;
	/// Maximum swimming time
	private int timeMax = 100;
	/// Current number of clients in the pool
	private int occupiers = 0;
	/// Indicates whether Jean-Luc is doing maintenance
	private boolean maintenance = false;
	
	/**
	 * Create a new pool
	 * @param capacity maximum number of clients in the pool at the same time
	 * @param timeMin minimum swimming time
	 * @param timeMax maximum swimming time
	 * @param jeanLucBreakTime time between maintenances
	 * @param jeanLucMaintenanceTime time of pool cleaning
	 */
	public Pool(int capacity, int timeMin, int timeMax, int jeanLucBreakTime, int jeanLucMaintenanceTime) {
		this.capacity = capacity;
		this.timeMin = timeMin;
		this.timeMax = timeMax;
		
		Thread t = new Thread(new JeanLuc(this, jeanLucBreakTime, jeanLucMaintenanceTime));
		t.setDaemon(true);
		t.start();
	}
	
	/**
	 * A client tries to get in the pool
	 * @param num unique client id
	 */
	public synchronized void enter(int num) {
		// If full, wait
		// (while wait is required because sometimes threads wake up without being notified)
		while (occupiers >= capacity || maintenance) {
			System.out.println("The client #" + num + " waits for people to leave the pool");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// Enter the pool
		occupiers++;
	}
	
	/**
	 * A client swims in the pool
	 * @param num unique client id
	 */
	public void swim(int num) {
		System.out.println("The client #" + num + " dived in the pool!");
		
		// The client swims for a random amount of time
		int temps = new Random().nextInt(timeMax-timeMin)+timeMin;
		try {
			Thread.sleep(temps);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * A client gets out of the pool
	 * @param num
	 */
	public synchronized void leave(int num) {
		// Notify a client waiting to get in the pool or Jean-Luc
		occupiers--;
		notifyAll();
		System.out.println("The client #" + num + " left the pool");
	}
	
	/**
	 * Clients can't go in the pool and when no one is left, Jean-Luc cleans the pool
	 */
	public synchronized void startMaintenance() {
		this.maintenance = true;
		System.out.println("Jean-Luc tells people not to get in the pool and waits for clients to come out");
		// Wait for clients to get out
		while (occupiers > 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Clients can go back in the pool after maintenance
	 */
	public synchronized void stopMaintenance() {
		this.maintenance = false;
		System.out.println("Jean-Luc takes a well-deserved break and tells the clients they can come back");
		notifyAll();
	}
}
