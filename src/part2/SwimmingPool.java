package part2;
import part1.ChangingRoom;
import part1.Pool;

public class SwimmingPool {
	private ChangingRoom changingRoom = new ChangingRoom();
	private ReceptionCounters receptionCounters = new ReceptionCounters();
	private Pool pool = new Pool();
	public ChangingRoom getChangingRoom() {
		return changingRoom;
	}
	public ReceptionCounters getReceptionCounter() {
		return receptionCounters;
	}
	public Pool getPool() {
		return pool;
	}
}
