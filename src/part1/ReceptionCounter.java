package part1;

public class ReceptionCounter {
	
	private int time = 5;
	
	public synchronized void buyTicket(int num) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("The client #" + num + " bought a ticket");
	}
}
