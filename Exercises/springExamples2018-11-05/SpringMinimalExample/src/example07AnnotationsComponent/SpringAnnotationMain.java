package example07AnnotationsComponent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component("thePerson")
class Person2
{
	public void sayHello() {
		System.out.println("Hi");
	}
	
}

@ComponentScan
public class SpringAnnotationMain {
 public static void main(String[] args) {
	 ApplicationContext ctx =    new AnnotationConfigApplicationContext(SpringAnnotationMain.class);  // should be closed
	   Person2 x = (Person2)ctx.getBean("thePerson"); 
	   x.sayHello();
	   

 }
}

