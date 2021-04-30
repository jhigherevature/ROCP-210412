package threadproblems;

/*
 * This class is used to simulate Livelock
 */
public class Police {
	private boolean ransomSent = false;
	
	public void giveRansom(Criminal criminal) {
		while (!criminal.isHostageReleased()) {
			System.out.println("Police: waiting for criminal to release hostage.");
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
		
		System.out.println("Police: sent ransom");
		this.ransomSent = true;
	}
	
	public boolean isRandomSent() {
		return this.ransomSent;
	}
}
