package multiThreading.advancedSynchronization;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import multiThreading.ExampleUtil;

class WorkerThread implements Runnable {
    
    private String command;
     
    public WorkerThread(String s){
        this.command=s;
    }
 
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" Start. Command = "+command);
        ExampleUtil.randomSleep(5000);
        System.out.println(Thread.currentThread().getName()+" End.");
    }
 

}

public class FixedThreadPoolExecutorDemo {
 	 
	    public static void main(String[] args) throws InterruptedException {
	        ExecutorService executor = Executors.newFixedThreadPool(5);
	        for (int i = 0; i < 10; i++) {
	            Runnable worker = new WorkerThread("Command" + i);
	            executor.execute(worker);
	          }
	        executor.shutdown();
	        executor.awaitTermination(1, TimeUnit.DAYS);
	        System.out.println("Finished all threads");
	    }
	 
	}

