package performanceAndMonitoring.hotspotJVM;

import java.util.ArrayList;
import java.util.List;

// possible flags : -client -server -XX:+PrintCompilation   -XX:CompileThreshold=100000   -XX:-TieredCompilation

public class Example01 {
	private static final int SIZE = 100000000;

	public static void main(String[] args) {
	   List<Integer> list = new ArrayList<Integer>(SIZE);
	   for (int i = 0; i < SIZE; i++) {
		list.add(1);
	   }
	   int result = 0;
	   long startTime = System.currentTimeMillis();
	   for (int count = 0; count < 15; count++) {
	      for (int index = 0; index < SIZE; index++) {
		    result += list.get(index);
	      }
	   }
	   long endTime = System.currentTimeMillis();
	   System.out.println("It took: " + (endTime - startTime) + " 	millis.");
	}

}
