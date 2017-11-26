package bonus;

public class JeanLuc implements Runnable {
	
	private Pool pool;
	
	private int breakTime;
	private int maintenanceTime;
	
	public JeanLuc(Pool pool, int breakTime, int maintenanceTime) {
		this.pool = pool;
		this.breakTime = breakTime;
		this.maintenanceTime = maintenanceTime;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(breakTime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pool.startMaintenance();
			System.out.println("Jean-Luc cleans the pool");
			try {
				Thread.sleep(maintenanceTime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pool.stopMaintenance();
		}
	}

}
