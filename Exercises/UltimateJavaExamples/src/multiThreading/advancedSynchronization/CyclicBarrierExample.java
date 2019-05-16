package multiThreading.advancedSynchronization;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import multiThreading.ExampleUtil;

class CyclicBarrierThread implements Runnable {   // Cyclic barrier waits for all 3 threads to finish and await, and only then releases all 3 together, then repeats the whole cycle

	@Override
	public void run() {
		try {
			while (true) {
				ExampleUtil.randomSleep(5000);
				System.out.println(Thread.currentThread().getName() + " Finished Sleep");
				CyclicBarrierExample.synchronizer.await();
				System.out.println(Thread.currentThread().getName() + " Released.");
			}
		} catch (InterruptedException | BrokenBarrierException e1) {
			e1.printStackTrace();
		}
	}

}

public class CyclicBarrierExample {

	public static CyclicBarrier synchronizer = new CyclicBarrier(3);

	public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
		new Thread(new CyclicBarrierThread()).start();;
		new Thread(new CyclicBarrierThread()).start();;
		new Thread(new CyclicBarrierThread()).start();;
	}
}
