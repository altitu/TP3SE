package part2;
import java.util.Random;

public class Bassin {
	
	private final int capacite = 3;
	private final int tempsMin = 40;
	private final int tempsMax = 100;
	private int occupants = 0;
	
	public synchronized void entrer(int num) {
		if (occupants >= capacite) {
			System.out.println("Le client " + num + " attend car le bassin est plein");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		occupants++;
		System.out.println("Le client " + num + " a plongé !");
	}
	
	public void nage(int num) {
		System.out.println("Le client " + num + " barbote dans le bassin");
		
		int temps = new Random().nextInt(tempsMax-tempsMin)+tempsMin;
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
		System.out.println("Le client " + num + " est sorti du bassin");
	}
}
