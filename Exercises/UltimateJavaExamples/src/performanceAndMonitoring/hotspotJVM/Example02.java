package performanceAndMonitoring.hotspotJVM;

import java.util.ArrayList;
import java.util.List;

// possible flags : -server -XX:-DoEscapeAnalysis


class Foo {
    private int x;
}

public class Example02 {
	private static final int SIZE = 1000*1000*1000;
	//static Object obj = new Object();

	static void createTrappedObjects() {
		for (int index = 0; index < SIZE; index++) {
		  Foo foo = new Foo();
		}
	}
	
	public static void main(String[] args) {
	    

	   long startTime;
	   long endTime;

	   // Warmup JVM - call both methods before benchmarking
	   createTrappedObjects();
	   createTrappedObjects();

	   System.out.println("Testing times:");
	   
	   startTime = System.currentTimeMillis();
	   createTrappedObjects();
 	   endTime = System.currentTimeMillis();
	   System.out.println("It took: " + (endTime - startTime) + " 	millis.");


	}
}
