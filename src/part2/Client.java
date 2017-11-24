package part2;

public class Client implements Runnable {
	// Identifiant du client
	int num;
	// Reference vers la piscine
	SwimmingPool swimmingPool;
	
	/**
	 * Crée un client
	 * @param piscine référence vers la piscine
	 * @param num numéro unique du client
	 */
	public Client(SwimmingPool piscine, int num) {
		this.swimmingPool = piscine;
		this.num = num;
	}
	@Override
	public void run() {
		System.out.println("The client #" + num + " enters the swimming pool");
		
		// Achat du ticket au guichet
		int counter = swimmingPool.getReceptionCounter().waitInLine(num);
		swimmingPool.getReceptionCounter().buyTicket(num, counter);
		swimmingPool.getReceptionCounter().leaveCounter(num, counter);
		
		// Mettage de maillot
		swimmingPool.getChangingRoom().enter(num);
		swimmingPool.getChangingRoom().change(num, true);
		swimmingPool.getChangingRoom().leave(num);
		
		// Plongeage dans le bassin
		swimmingPool.getPool().enter(num);
		swimmingPool.getPool().swim(num);
		swimmingPool.getPool().leave(num);
		
		// Demettage de maillot
		swimmingPool.getChangingRoom().enter(num);
		swimmingPool.getChangingRoom().change(num, false);
		swimmingPool.getChangingRoom().leave(num);
		
		// Sortissage de la piscine
		System.out.println("The client #" + num + " leaves the swimming pool");
		return;
	}
}
