package example08BeanAnnotation;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

class Person2
{
	public void sayHello() {
		System.out.println("Hi");
	}
	
}

@Configuration
class PersonFactory
{
	@Bean
	@Scope(value=ConfigurableBeanFactory.SCOPE_SINGLETON)
	public Person2 getPerson2()
	{
		System.out.println("getPerson2 called");
		return new Person2();
	}
}

@ComponentScan
public class SpringAnnotationMain {
 public static void main(String[] args) {
	 ApplicationContext ctx =    new AnnotationConfigApplicationContext(SpringAnnotationMain.class); 
	   System.out.println(ctx.getBean(Person2.class));
	   System.out.println(ctx.getBean(Person2.class));

	   
	   

 }
}

