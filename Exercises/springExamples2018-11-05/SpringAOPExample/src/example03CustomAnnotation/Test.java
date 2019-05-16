package example03CustomAnnotation;

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
	      
	      MyBean bean   = (MyBean)ctx.getBean(example03CustomAnnotation.MyBean.class);
	      
	      bean.testAspectCallInt(12); // calling method
	  }
	}
