package part2;

public class Client implements Runnable {
	
	/// Unique client id
	int num;
	/// Reference to swimming pool
	SwimmingPool swimmingPool;
	
	/**
	 * Creates a new client
	 * @param swimmingPool reference to swimming pool
	 * @param num unique client id
	 */
	public Client(SwimmingPool swimmingPool, int num) {
		this.swimmingPool = swimmingPool;
		this.num = num;
	}
	
	@Override
	public void run() {
		System.out.println("The client #" + num + " enters the swimming pool");
		
		// The client buys a ticket
		int counter = swimmingPool.getReceptionCounters().waitInLine(num);
		swimmingPool.getReceptionCounters().buyTicket(num, counter);
		swimmingPool.getReceptionCounters().leaveCounter(num, counter);
		
		// The client goes to the changing room to put on a swimsuit
		swimmingPool.getChangingRoom().enter(num);
		swimmingPool.getChangingRoom().change(num, true);
		swimmingPool.getChangingRoom().leave(num);
		
		// The client gets in the pool
		swimmingPool.getPool().enter(num);
		swimmingPool.getPool().swim(num);
		swimmingPool.getPool().leave(num);
		
		// The client goes back to the changing room to put their clothes back
		swimmingPool.getChangingRoom().enter(num);
		swimmingPool.getChangingRoom().change(num, false);
		swimmingPool.getChangingRoom().leave(num);

		System.out.println("The client #" + num + " leaves the swimming pool");
	}
}
