package part2;

import java.util.ArrayList;
import java.util.List;

public class PointDeVente {
	
	private final int temps = 5;
	private final int nbGuichets = 2;
	// Disponibilité des guichets
	private List<Boolean> guichets = new ArrayList<>();
	
	public PointDeVente() {
		// Tous les guichets sont libres
		for (int i=0;i<nbGuichets;++i)
			guichets.add(false);
	}
	
	private boolean all(List<Boolean> a) {
		for (boolean a1 : a) {
			if (!a1) return false;
		}
		return true;
	}
	
	public synchronized int allerAuGuichet(int num) {
		// Attendre si les deux guichets sont occupés
		if (all(guichets)) {
			System.out.println("Le client " + num + " attend car les " + nbGuichets + " guichets sont occupés");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// Quand un se libère, le prendre (ou prendre le premier si les deux sont dispo)
		for (int i=0;i<nbGuichets;++i) {
			if (!guichets.get(i)) {
				System.out.println("Le client " + num + " va au guichet " + i);
				return i;
			}
		}
		return -1;
	}
	
	public void acheterTicket(int num, int guichet) {
		try {
			Thread.sleep(temps);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Le client " + num + " achète un ticket au guichet " + guichet);
	}
	
	public synchronized void partirDuGuichet(int num, int guichet) {
		// Libérer le guichet
		guichets.set(guichet, false);
		notify();
		System.out.println("Le client " + num + " part du guichet " + guichet);
	}
}
