package multiThreading.advancedSynchronization;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

import multiThreading.ExampleUtil;

class CountDownLatchThread implements Runnable { 
	@Override
	public void run() {
			ExampleUtil.randomSleep(5000);
			System.out.println(Thread.currentThread().getName() + " Finished Sleep");
			CountDownLatchExample.countDownLatch.countDown();
			System.out.println(Thread.currentThread().getName() + " Continuing.");
//			try {   // in CountDownLatch countDown does not wait, and wait does not count down
//				CountDownLatchExample.countDownLatch.await();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			System.out.println(Thread.currentThread().getName() + " Exiting.");
	}

}

public class CountDownLatchExample {

	public static CountDownLatch countDownLatch = new CountDownLatch(3);

	public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
		new Thread(new CountDownLatchThread()).start();
		new Thread(new CountDownLatchThread()).start();
		new Thread(new CountDownLatchThread()).start();
		countDownLatch.await();
		System.out.println("Main finished");
	}
}
