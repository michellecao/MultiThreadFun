import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;


public class Main {
	public static void main(String args[]) {
		Racer r = new Racer();
		Thread t1 = new Thread(r, "Michelle Pig");
		t1.setPriority(Thread.MAX_PRIORITY);
		Thread t2 = new Thread(r, "JL Snake");
		t2.setPriority(8);
		Thread t3 = new Thread(r, "JL Awesome");
		t3.setPriority(6);
		Thread t4 = new Thread(r, "JL Tall");
		t4.setPriority(4);
		Thread t5 = new Thread(r, "JL Big");
		t5.setPriority(Thread.MIN_PRIORITY);
		
		Queue<Thread> pq = new PriorityQueue<Thread>(5, new Comparator<Thread>() {
			public int compare(Thread t1, Thread t2) {
				return t2.getPriority() - t1.getPriority();
			}
		});
		
		pq.add(t1); pq.add(t2); pq.add(t3); pq.add(t4); pq.add(t5);
		
		while(!pq.isEmpty()) {
			Thread currThread = pq.poll();
			System.err.println(currThread.getName() + ": " + currThread.getPriority());
			currThread.start();
			try {
				Thread.sleep(1000 * 3);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
