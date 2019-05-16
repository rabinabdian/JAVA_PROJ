package classLoaders;

public class Example03 {
 public static void main(String[] args) throws Exception {

		ClassLoader cl = ClassLoader.getSystemClassLoader();
		System.out.println("First lets load the class");
		Class<?> clasz = cl.loadClass("classLoaders.Test");
		System.out.println("Now to initialize the class");
		Class.forName("classLoaders.Test", true, cl);

 }
}
