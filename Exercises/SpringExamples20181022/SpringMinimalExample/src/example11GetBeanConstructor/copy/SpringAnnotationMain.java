package example11GetBeanConstructor.copy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("thePerson")
@Scope("prototype") // constructor args only work with prototype
class Person3
{
	private String name;
	Person3( String name )
	{
		this.name = name;
	}
	public void sayHello() {
		System.out.println("Hi from " + name);
	}
	
}

@ComponentScan
public class SpringAnnotationMain {
 public static void main(String[] args) {
	 ApplicationContext ctx =    new AnnotationConfigApplicationContext(SpringAnnotationMain.class);  // should be closed
	   Person3 x = (Person3)ctx.getBean("thePerson","Gonen"); 
	   x.sayHello();
	   

 }
}

