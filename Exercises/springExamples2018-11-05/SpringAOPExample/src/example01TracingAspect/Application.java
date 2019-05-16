package example01TracingAspect;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@EnableAspectJAutoProxy
@ComponentScan()
public class Application {

  
 public static void main(String[] args) {
	 AnnotationConfigApplicationContext  ctx =    new AnnotationConfigApplicationContext(Application.class);
	 TestClass x = ctx.getBean(TestClass.class);
	 x.wrapFoo();

}
}
