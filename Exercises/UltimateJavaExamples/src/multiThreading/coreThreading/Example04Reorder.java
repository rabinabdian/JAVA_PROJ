package multiThreading.coreThreading;

public class Example04Reorder extends Thread {
	volatile static int a = 0;
	volatile static int b = 0;
	static Object lock = new Object();

	public static void main(String[] args) throws InterruptedException {
		Example04Reorder t = new Example04Reorder();
		t.start();
		while (true) {
			synchronized (lock) {
				if (b > a) {  // This example is incorrect, because b and a are two separate reads, so the real problem is just thread preemption, not instruction reordering
					System.out.println("b was bigger than a");
					System.exit(1);
				}
			}
		}
	}

	public void run() {
		while (true) {
			a = 5;
			b = 4;
			b = 0;
			a = 0;
		}
	}
}

/*
 * 
 * a =0; b =0; a =5; b = 4; b = 0; a = 0;
 */
