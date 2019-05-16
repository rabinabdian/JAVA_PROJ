package example05ClassLevelAndOrder;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import example02MethodDetails.SpringConfig;

@ComponentScan()
@EnableAspectJAutoProxy
public class Test {
	  public static void main(String[] args) {
	      ApplicationContext ctx =  new AnnotationConfigApplicationContext(Test.class);
	      
	      MyBean2 bean2   = (MyBean2)ctx.getBean("myBean2");
	      MyBean3 bean3   = (MyBean3)ctx.getBean("myBean3");
	      
	      System.out.println(bean2.getClass());
	      System.out.println(bean3.getClass());
	      //bean.testAspectCallInt(12); // calling method
	  }
	}
