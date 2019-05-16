package multiThreading.atomicOperations;

public class Example02DoubleNotAtomic {

	static long val = 0;

    // This demo might work on a 32 bit JVM?
	public static void main(String[] args) {
		Runnable r = new Runnable() {
			public void run() {
				while (true) {
					long currentVal = val;
					if (currentVal == 0) {
						val = -1L;
					} else if (currentVal == -1L) {
						val = 0;
					} else {
						System.out.println("Unexpected value val = " + val);
						System.exit(1);
					}
				}
			}
		};
		new Thread(r).start();
		new Thread(r).start();
	}
}
