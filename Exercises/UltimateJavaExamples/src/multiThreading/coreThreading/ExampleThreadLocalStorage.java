package multiThreading.coreThreading;

import multiThreading.ExampleUtil;

class MyRunnable implements Runnable
{
	   private ThreadLocal<String> tlocalName = new 	ThreadLocal<String>() {
		   @Override
		   protected String initialValue() {
		   // Create a new cache for first time thread.
			return Thread.currentThread().getName();
		}
	   };

	@Override
	public void run() {
		while( true )
		{
			ExampleUtil.sleep(1000);
			System.out.println("Running: " + tlocalName.get());
		}
	}
	   
	   

}
public class ExampleThreadLocalStorage {
 public static void main(String[] args) {
	MyRunnable runnableInstance = new MyRunnable();
   	Thread t1 = new Thread( runnableInstance );
   	Thread t2 = new Thread( runnableInstance );
   	t1.start();
   	t2.start();
 }
}
