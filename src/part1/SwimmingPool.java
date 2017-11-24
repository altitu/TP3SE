package part1;

public class SwimmingPool {
	private ChangingRoom changingRoom = new ChangingRoom();
	private ReceptionCounter receptionCounter = new ReceptionCounter();
	private Pool pool = new Pool();
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
