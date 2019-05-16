package multiThreading.advancedSynchronization;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import multiThreading.ExampleUtil;

class AsynchAdd implements Callable<Integer>
{
	int a;
	int b;
	public AsynchAdd(int a, int b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public Integer call() throws Exception {
		System.out.println("Starting computation on thread...");
		ExampleUtil.randomSleep(5000);
		return a + b;
	}
}

public class FutureExample {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newSingleThreadExecutor();

		AsynchAdd addTask = new AsynchAdd(5,3);
		Future<Integer> future = executorService.submit( addTask );

		System.out.println("Now doing other things, and waiting for result");
		while( !future.isDone() )
		{
			System.out.println("Not done yet...");
			Thread.sleep(1000);
		}
		System.out.println("future.get() = " + future.get());
		executorService.shutdown();
	}

}
