package part2;

public class PointDeVente {
	
	private int temps = 5;
	
	public synchronized void vendre(int num) {
		try {
			Thread.sleep(temps);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Le client " + num + " a acheté un ticket");
	}
}
