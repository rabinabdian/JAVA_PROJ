package performanceAndMonitoring.exceptions;

import java.util.ArrayList;
import java.util.List;

public class Example02 {
	
	private static final long SIZE = 1000000000;

	static long doWithExceptions() {
		int x = 7;
		for (int i = 0; i < SIZE; i++) {
			try {
				x += 1;
			} catch (RuntimeException e) {
			}
		}
		return x;
	}
	
	static long doWithoutExceptions() {
		int x = 7;
		for (int i = 0; i < SIZE; i++) {
				x += 1;
		}
		return x;
	}
	


	public static void main(String[] args) {

	   long startTime;
	   long endTime;

	   // Warmup JVM - call both methods before benchmarking
	   doWithExceptions();
	   
	   doWithoutExceptions();

	   doWithExceptions();

	   doWithoutExceptions();

	   System.out.println("Testing times:");
	
	   startTime = System.currentTimeMillis();
	   doWithoutExceptions();
 	   endTime = System.currentTimeMillis();
	   System.out.println("Without exceptions It took: " + (endTime - startTime) + " 	millis.");

	   startTime = System.currentTimeMillis();
	   doWithExceptions();
 	   endTime = System.currentTimeMillis();
	   System.out.println("With Exceptions It took: " + (endTime - startTime) + " 	millis.");
	   
	   
	
	
   }
   
   
}
