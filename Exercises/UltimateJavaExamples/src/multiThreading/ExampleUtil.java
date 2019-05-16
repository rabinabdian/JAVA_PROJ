package multiThreading;

import java.util.Random;

public class ExampleUtil {
	static public void randomSleep(int millis) {
		try {
			Thread.sleep(new Random().nextInt(millis));
		} catch (InterruptedException e) {
			System.out.println("Thread interrupted on random sleep");
			e.printStackTrace();
		}
	}

	static public void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			System.out.println("Thread interrupted on random sleep");
			e.printStackTrace();
		}
	}

}
