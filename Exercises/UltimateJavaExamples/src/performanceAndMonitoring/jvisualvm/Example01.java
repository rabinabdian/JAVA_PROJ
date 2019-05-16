package performanceAndMonitoring.jvisualvm;


class MyRunnable implements Runnable
{
	@Override
	public void run() {
		while(true)
		{
			int x = 0;
			x = doStuff(x);
			sleep();
			Example01.result+=x;
		}
	}

	private void sleep() {
		try { Thread.sleep(10); } catch (InterruptedException e) { e.printStackTrace(); }
	}

	private int doStuff(int x) {
		for(int i = 0; i < 10000000; ++i)
			x+=i;
		return x;
	}
}
public class Example01 {
 static int result;
 public static void main(String[] args) throws Exception {
	 Thread thread1 = new Thread(new MyRunnable());
	 Thread thread2 = new Thread(new MyRunnable());
	 startThreadsAndWait(thread1, thread2);

 }

 static void startThreadsAndWait(Thread thread1, Thread thread2) throws InterruptedException {
	 thread1.start(); thread2.start();
	 thread1.join(); thread2.join();
 }
}
