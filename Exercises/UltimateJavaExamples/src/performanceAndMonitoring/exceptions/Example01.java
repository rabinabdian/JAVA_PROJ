package performanceAndMonitoring.exceptions;

import java.util.ArrayList;
import java.util.List;

public class Example01 {
	
	private static final long SIZE = 100000000;

	static long iterateAllWithExceptions(List<Integer> coll) {
		long result = 0;
		int index = 0;
		// using exceptions for flow control
		try {
			while (true) {
				result += coll.get(index++);
			}
		} catch (IndexOutOfBoundsException e) {
			;//
		}
		return result;
	}
	
	static long iterateAllWithoutExceptions(List<Integer> coll) {
		long result = 0;
		int index = 0;
		// using exceptions for flow control
		
		for (int i = 0; i < SIZE; ++i) {
			result += coll.get(index++);
		}

		return result;
	}
	
   public static void main(String[] args) {
	   ArrayList<Integer> numbers = new ArrayList<>();
	   for (int i = 0; i < SIZE; i++) {
		numbers.add(1);
	   }
	   
	   long startTime;
	   long endTime;

	   // Warmup JVM - call both methods before benchmarking
	   iterateAllWithExceptions(numbers);
	   
	   iterateAllWithoutExceptions(numbers);

	   System.out.println("Testing times:");
	   
	   startTime = System.currentTimeMillis();
	   iterateAllWithExceptions(numbers);
 	   endTime = System.currentTimeMillis();
	   System.out.println("With Exceptions It took: " + (endTime - startTime) + " 	millis.");
	   
	   
	   startTime = System.currentTimeMillis();
	   iterateAllWithoutExceptions(numbers);
 	   endTime = System.currentTimeMillis();
	   System.out.println("Without exceptions It took: " + (endTime - startTime) + " 	millis.");

	
   }
   
   
}
