package part1;

public class ReceptionCounter {
	
	/// Time for buying a ticket
	private int time;
	
	/**
	 * Creates a new reception counter
	 * @param time time for buying a ticket
	 */
	public ReceptionCounter(int time) {
		this.time = time;
	}
	
	/**
	 * A client tries to buy a ticket
	 * No wait/notify because there is only one counter and one client at a time, a synchronized method is enough
	 * @param num unique client id
	 */
	public synchronized void buyTicket(int num) {
		System.out.println("The client #" + num + " buys a ticket");
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
