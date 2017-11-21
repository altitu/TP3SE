package part2;

public class PointDeVente {
	
	private final int temps = 5;
	// Disponibilité des guichets
	private boolean[] guichets = new boolean[2];
	
	public PointDeVente() {
		// Les deux guichets sont libres
		guichets[0] = false;
		guichets[1] = false;
	}
	
	public synchronized int allerAuGuichet(int num) {
		// Attendre si les deux guichets sont occupés
		if (guichets[0] && guichets[1]) {
			System.out.println("Le client " + num + " attend car les 2 guichets sont occupés");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// Quand un se libère, le prendre (ou prendre le premier si les deux sont dispo)
		if (!guichets[0]) {
			System.out.println("Le client " + num + " va au guichet 0");
			guichets[0] = true;
			return 0;
		} else {
			System.out.println("Le client " + num + " va au guichet 1");
			guichets[1] = true;
			return 1;
		}
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
		guichets[guichet] = false;
		notify();
		System.out.println("Le client " + num + " part du guichet " + guichet);
	}
}
