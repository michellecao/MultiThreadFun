
public class Racer implements Runnable{
	public void run() {
		runHelper();
	}
	
	public synchronized void runHelper() {
		for(int distance = 0; distance <= 20; distance++) {
			System.err.println(Thread.currentThread().getName() + " is " 
						+ (20 - distance) + " meters away from the finish line!");
			
			if(distance == 20) {
				System.err.println(Thread.currentThread().getName() + " has arrived!!! " +
												"Everyone else Sleep for a while");
				
				try {
					Thread.sleep(1000 * 2);
				} catch (InterruptedException e) {
					System.err.println(e.getMessage());
				}
			}
		}
	}
}
