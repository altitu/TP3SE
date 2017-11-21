
public class PointDeVente {
	public synchronized void vendre(boolean ticket) {
		if (ticket == false) {
			ticket = true;
		} else {
			System.err.println("Erreur: le client passe deux fois par le point de vente");
		}
	}
}
