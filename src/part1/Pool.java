package part1;
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
	
	/**
	 * Create a new pool
	 * @param capacity maximum number of clients in the pool at the same time
	 * @param timeMin minimum swimming time
	 * @param timeMax maximum swimming time
	 */
	public Pool(int capacity, int timeMin, int timeMax) {
		this.capacity = capacity;
		this.timeMin = timeMin;
		this.timeMax = timeMax;
	}
	
	/**
	 * A client tries to get in the pool
	 * @param num unique client id
	 */
	public synchronized void enter(int num) {
		// If full, wait
		if (occupiers >= capacity) {
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
		// Notify a client waiting to get in the pool
		occupiers--;
		notify();
		System.out.println("The client #" + num + " left the pool");
	}
}
