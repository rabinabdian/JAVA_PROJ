package example09AutoWired;
import java.io.Closeable;

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





@Component
class DB 
{
	public void writeValue(int value) { System.out.println("Writing to DB class. Value = " + value);}
}


@Component
class Calc
{
	@Autowired 
	DB db;
	public void writeSum (  int a, int b )
	{
		db.writeValue(a+b);
	}
}


@ComponentScan
public class SpringAnnotationMain {
 public static void main(String[] args) {
	 AnnotationConfigApplicationContext ctx =    new AnnotationConfigApplicationContext(SpringAnnotationMain.class);  
	   Calc calc = ctx.getBean(Calc.class); 
	   calc.writeSum(5,7);
	   ctx.close();
 }
}

