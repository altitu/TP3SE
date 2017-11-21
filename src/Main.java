import java.util.ArrayList;

public class Main {
	public static void main(String args[]) {
		Piscine piscine = new Piscine();
		ArrayList<Thread> clientThreadArray = new ArrayList<Thread>();
		int i = 0;
		for (Thread thread: clientThreadArray) {
			thread = new Thread(new Client(piscine, i));
			i++;
			thread.setDaemon(true);
			thread.start();
		}
	}
}
