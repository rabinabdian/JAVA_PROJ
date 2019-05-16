package example02MethodDetails;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	  public static void main(String[] args) {
	      ApplicationContext ctx =  new AnnotationConfigApplicationContext(SpringConfig.class);
	      
	      MyBean bean = (MyBean)ctx.getBean("myBean");
	      String str = bean.testAspectCall(12); // calling method
	      System.out.println(str);
	      bean.testAspectCallInt(12); // calling method
	      System.out.println("Test.main() - bean:" + bean);
	 }
	}
