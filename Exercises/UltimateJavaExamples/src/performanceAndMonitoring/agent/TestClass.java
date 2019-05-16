package performanceAndMonitoring.agent;

// vm args   -javaagent:bin\performanceAndMonitoring\agent\agent.jar
public class TestClass {
	   public static void main(String[] args) throws Exception {
		while (true) {
		   Course uj = new Course("Ultimate Java", 24);
		   Course spring = new Course("Spring", 40);
		   System.out.println(uj);
		   System.out.println(spring);
		   System.out.println("*******************");
		   Thread.sleep(2000);
		}
	   }
	}
