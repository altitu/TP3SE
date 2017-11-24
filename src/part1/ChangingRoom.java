package part1;

public class ChangingRoom {
	
	private final int capacity = 3;
	private final int time = 10;
	private int occupiers = 0;
	
	public synchronized void enter(int num) {
		if (occupiers >= capacity) {
			System.out.println("The client #" + num + " is waiting for people to leave the changing room");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		occupiers++;
		System.out.println("The client #" + num + " gets in the changing room");
	}
	
	public void change(int num, boolean how) {
		System.out.println("The client #" + num + (how?" puts on his swimsuit":" changes their clothes back"));
		
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public synchronized void leave(int num) {
		occupiers--;
		notify();
		System.out.println("The client #" + num + " leaves the changing room");
	}
}
