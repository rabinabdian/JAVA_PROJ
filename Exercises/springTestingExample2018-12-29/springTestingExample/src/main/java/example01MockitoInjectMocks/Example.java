package example01MockitoInjectMocks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

interface IDB
{
	void saveValue(int value);
}
@Component
class DB implements IDB
{
	public void saveValue(int value) {
		throw new RuntimeException("There is no database on your system");		
	}
	
}
@Component
class Calculator
{
	@Autowired
	private IDB db ;
	void calculate( int a, int b )
	{
		db.saveValue(a+b*10+1);
	}
	
	
}

@ComponentScan
public class Example {
 public static void main(String[] args) {
   AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Example.class);
   Calculator calc = context.getBean(Calculator.class);
   calc.calculate(5, 3);
   
 }
}
