package multiThreading.coreThreading;


import java.util.concurrent.ExecutionException;

import multiThreading.ExampleUtil;

class AsynchAdd implements Runnable
{
	int a;
	int b;
	int result;
	Object doneFlag;
	
	public AsynchAdd(int a, int b, Object doneFlag ) {
		this.a = a;
		this.b = b;
		this.doneFlag = doneFlag;
	}

	@Override
	public void run() {
		System.out.println("Starting computation on thread...");
		ExampleUtil.randomSleep(5000);
		System.out.println("Finished computation on thread...");
		result = a + b;
		synchronized (doneFlag) {
		 doneFlag.notify();	
		}
		
	}
}

public class NotifyExample {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		Object doneFlag = new Object();
		AsynchAdd addTask = new AsynchAdd(5,3,doneFlag);
		Thread thread = new Thread(addTask);
		thread.start();

		synchronized (doneFlag) {
		 doneFlag.wait();	
		}
		System.out.println("Thread result = " + addTask.result);
	}

}
