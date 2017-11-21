
public class Vestiaire {
	
	private final int capacite = 3;
	private final int temps = 10;
	private int occupants = 0;
	
	public synchronized void entrer(int num) {
		if (occupants >= capacite) {
			System.out.println("Le client " + num + " attend car les vestiaires sont plein");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		occupants++;
		System.out.println("Le client " + num + " est entré dans les vestiaires");
	}
	
	public void seChanger(int num, boolean seChanger) {
		System.out.println("Le client " + num + (seChanger?" met son maillot":" remet ses vêtements"));
		
		try {
			Thread.sleep(temps);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public synchronized void sortir(int num) {
		occupants--;
		notify();
		System.out.println("Le client " + num + " est sorti des vestiaires");
	}
}
