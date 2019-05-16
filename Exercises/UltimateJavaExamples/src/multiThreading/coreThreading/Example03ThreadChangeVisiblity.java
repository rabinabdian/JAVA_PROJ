package multiThreading.coreThreading;

public class Example03ThreadChangeVisiblity extends Thread {
    boolean keepRunning = true;
    public static void main(String[] args) throws InterruptedException {
        Example03ThreadChangeVisiblity t = new Example03ThreadChangeVisiblity();
        t.start();
        Thread.sleep(1000);
        t.keepRunning = false;
        System.out.println(System.currentTimeMillis() + ": keepRunning is false");
    }
    public void run() {
        while (keepRunning) 
        {
//        	synchronized (this) {
//				;
//			}
        }
    }
}

