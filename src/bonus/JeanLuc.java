package bonus;

public class JeanLuc implements Runnable {
	
	private Pool pool;
	
	public JeanLuc(Pool pool) {
		this.pool = pool;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pool.startMaintenance();
			System.out.println("Jean-Luc cleans the pool");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pool.stopMaintenance();
		}
	}

}
