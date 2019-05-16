package example10AutoWiredInjection;
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




interface IDB
{
	public void writeValue(int value);
}
@Component
@Primary
class DB implements IDB
{
	public void writeValue(int value) { System.out.println("Writing to DB class. Value = " + value);}
}

@Component

class DB2 implements IDB
{
	public void writeValue(int value) { System.out.println("Writing to DB2 class. Value = " + value);}
}

@Component
class Calc
{
	IDB db;
	public void writeSum (  int a, int b )
	{
		db.writeValue(a+b);
	}
	@Autowired 
	public void setDB(IDB db)
	{
		System.out.println("Setting DB in Calc");
		this.db = db;
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

