package performanceAndMonitoring.atomicOperations;

import java.util.concurrent.atomic.AtomicInteger;

public class Example01 {
 static int x;
 static AtomicInteger y = new AtomicInteger();
 public static void main(String[] args) throws Exception {
	 Thread thread1 = new Thread(()->{for(int i=0; i <10000; ++i) x++;});
	 Thread thread2 = new Thread(()->{for(int i=0; i <10000; ++i) x++;});
	 startThreadsAndWait(thread1, thread2);
	 System.out.println("Final count of x = " + x);
	 
	 thread1 = new Thread(()->{for(int i=0; i <10000; ++i) y.incrementAndGet();});
	 thread2 = new Thread(()->{for(int i=0; i <10000; ++i) y.incrementAndGet();});
	 startThreadsAndWait(thread1, thread2);
	 System.out.println("Final count of y = " + y.get());
 }

 static void startThreadsAndWait(Thread thread1, Thread thread2) throws InterruptedException {
	 thread1.start(); thread2.start();
	 thread1.join(); thread2.join();
 }
}
