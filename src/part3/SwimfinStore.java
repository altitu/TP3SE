package part3;

public class SwimfinStore {
	
	/// Current number of swimfins
	private int current;
	
	/// Time for borrowing or returning swimfins
	private int time;
	
	/**
	 * Creates a swimfin store
	 * @param initial initial number of swimfins in the store
	 * @param time time for borrowing or returning swimfins
	 */
	public SwimfinStore(int initial, int time) {
		this.current = initial;
		this.time = time;
	}
	
	/**
	 * A client borrows a pair of swimfins
	 * @param num unique client id
	 */
	public synchronized void borrowSwimfins(int num) {
		// If there is less than 2 swimfins, wait for 2 to be available
		// (while wait is required because sometimes threads wake up without being notified)
		boolean printed = false;
		while (current < 2) {
			if (!printed) {
				System.out.println("The client #" + num + " is waiting for a pair of swimfins");
				printed = true;
			}
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// Remove the two swimfins
		current -= 2;
		System.out.println("The client #" + num + " borrows a pair of swimfins and heads to the pool");
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void returnSwimfins(int num) {
		System.out.println("The client #" + num + " returns his swimfins to the store");
		// Give back the two swimfins
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		current += 2;
		// Notify the next client that needs it
		notify();
	}

}
