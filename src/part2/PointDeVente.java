package part2;

public class PointDeVente {
	
	private final int temps = 5;
	private boolean[] guichets = new boolean[2];
	
	public synchronized void allerAuGuichet(int num) {
		if (guichets[0] && guichets[1]) {
			System.out.println("Le client " + num + " attend car les " + guichets + " sont occupés");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		guichetsOccupes++;
		System.out.println("Le client " + num + " va au guichet");
	}
	
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
