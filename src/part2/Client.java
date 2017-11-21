package part2;

public class Client implements Runnable {
	// Identifiant du client
	int numero;
	// Reference vers la piscine
	Piscine piscine;
	
	/**
	 * Crée un client
	 * @param piscine référence vers la piscine
	 * @param numero numéro unique du client
	 */
	public Client(Piscine piscine, int numero) {
		this.piscine = piscine;
		this.numero = numero;
	}
	@Override
	public void run() {
		System.out.println("Le client " + numero + " est arrivé");
		
		// Achat du ticket au guichet
		int guichet = piscine.getPointDeVente().allerAuGuichet(numero);
		piscine.getPointDeVente().acheterTicket(numero, guichet);
		piscine.getPointDeVente().partirDuGuichet(numero, guichet);
		
		// Mettage de maillot
		piscine.getVestiaire().entrer(numero);
		piscine.getVestiaire().seChanger(numero, true);
		piscine.getVestiaire().sortir(numero);
		
		// Plongeage dans le bassin
		piscine.getBassin().entrer(numero);
		piscine.getBassin().nage(numero);
		piscine.getBassin().sortir(numero);
		
		// Demettage de maillot
		piscine.getVestiaire().entrer(numero);
		piscine.getVestiaire().seChanger(numero, false);
		piscine.getVestiaire().sortir(numero);
		
		// Sortissage de la piscine
		System.out.println("Le client " + numero + " est parti");
		return;
	}
}
