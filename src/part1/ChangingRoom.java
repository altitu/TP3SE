package part1;

public class ChangingRoom {
	
	/// Maximum number of clients
	private int capacity;
	/// Time for changing
	private int time;
	/// Current number of clients inside
	private int occupiers = 0;
	
	/**
	 * Creates a changing room
	 * @param capacity maximum number of clients in the room at the same time
	 * @param time time for a client to change themselves
	 */
	public ChangingRoom(int capacity, int time) {
		this.capacity = capacity;
	}
	
	/**
	 * A client tries to get inside the changing room
	 * @param num unique client id
	 */
	public synchronized void enter(int num) {
		// If full, wait
		if (occupiers >= capacity) {
			System.out.println("The client #" + num + " is waiting for people to leave the changing room");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// Get in
		occupiers++;
		System.out.println("The client #" + num + " gets in the changing room");
	}
	
	/**
	 * A client changes in the changing room
	 * @param num unique client id
	 * @param how true if the client is putting a swimsuit, false for normal clothes
	 */
	public void change(int num, boolean how) {
		System.out.println("The client #" + num + (how?" puts on their swimsuit":" changes their clothes back"));
		
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * A client leaves the changing room
	 * @param num unique client id
	 */
	public synchronized void leave(int num) {
		// Leave the room and notify a client waiting for the changing room
		occupiers--;
		notify();
		System.out.println("The client #" + num + " leaves the changing room");
	}
}
