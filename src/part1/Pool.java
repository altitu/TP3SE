package part1;
import java.util.Random;

public class Pool {
	
	private final int capacity = 3;
	private final int timeMin = 40;
	private final int timeMax = 100;
	private int occupiers = 0;
	
	public synchronized void enter(int num) {
		if (occupiers >= capacity) {
			System.out.println("The client #" + num + " waits for people to leave the pool");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		occupiers++;
	}
	
	public void swim(int num) {
		System.out.println("The client #" + num + " dived in the pool!");
		
		int temps = new Random().nextInt(timeMax-timeMin)+timeMin;
		try {
			Thread.sleep(temps);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public synchronized void leave(int num) {
		occupiers--;
		notify();
		System.out.println("The client #" + num + " left the pool");
	}
}
