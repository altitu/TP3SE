
public class Client implements Runnable {
	int numero;
	Piscine piscine;
	public Client(Piscine piscine, int numero) {
		this.piscine = piscine;
		this.numero = numero;
	}
	@Override
	public void run() {
		System.out.println("Bien le bonjour du thread "+numero+" !");
		piscine.
	}
}
