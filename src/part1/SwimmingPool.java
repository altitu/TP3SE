package part1;

public class SwimmingPool {
	
	/// Swimming pool components and getters
	
	private ChangingRoom changingRoom = new ChangingRoom(4, 5);
	
	private ReceptionCounter receptionCounter = new ReceptionCounter(2);
	
	private Pool pool = new Pool(10, 10, 20);
	
	public ChangingRoom getChangingRoom() {
		return changingRoom;
	}
	
	public ReceptionCounter getReceptionCounter() {
		return receptionCounter;
	}
	
	public Pool getPool() {
		return pool;
	}
}
