package classLoaders;

public class Test {
 static
 {
	 System.out.println("Test initialization block");
 }
 public Test() {
	System.out.println("Constructor of Test V2:");
 }
}
