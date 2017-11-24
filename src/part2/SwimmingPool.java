package part2;
import part1.ChangingRoom;
import part1.Pool;

public class SwimmingPool {

	/// Swimming pool components and getters
	
	private ChangingRoom changingRoom = new ChangingRoom(4, 5);
	
	private ReceptionCounters receptionCounters = new ReceptionCounters(2, 2);
	
	private Pool pool = new Pool(10, 10, 20);
	
	public ChangingRoom getChangingRoom() {
		return changingRoom;
	}
	
	public ReceptionCounters getReceptionCounters() {
		return receptionCounters;
	}
	
	public Pool getPool() {
		return pool;
	}
}
