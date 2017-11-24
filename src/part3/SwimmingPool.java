package part3;
import part1.ChangingRoom;
import part1.Pool;
import part2.ReceptionCounters;

public class SwimmingPool {

	/// Swimming pool components and getters
	
	private ChangingRoom changingRoom = new ChangingRoom(4, 5);
	
	private ReceptionCounters receptionCounters = new ReceptionCounters(2, 2);
	
	private Pool pool = new Pool(10, 10, 20);
	
	private SwimfinStore swimfinStore = new SwimfinStore(16, 2);
	
	public ChangingRoom getChangingRoom() {
		return changingRoom;
	}
	
	public ReceptionCounters getReceptionCounters() {
		return receptionCounters;
	}
	
	public Pool getPool() {
		return pool;
	}
	
	public SwimfinStore getSwimfinStore() {
		return swimfinStore;
	}
}
