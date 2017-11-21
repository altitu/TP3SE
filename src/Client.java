
public class Client implements Runnable {
	int numero;
	Piscine piscine;
	public Client(Piscine piscine, int numero) {
		this.piscine = piscine;
		this.numero = numero;
	}
	@Override
	public void run() {
		System.out.println("Le client " + numero + " est arrivé");
		piscine.getPointDeVente().vendre(numero);
		piscine.getVestiaire().entrer(numero);
		piscine.getVestiaire().seChanger(numero, true);
		piscine.getVestiaire().sortir(numero);
		
		piscine.getVestiaire().entrer(numero);
		piscine.getVestiaire().seChanger(numero, false);
		piscine.getVestiaire().sortir(numero);
		System.out.println("Le client " + numero + " est parti");
		return;
	}
}
