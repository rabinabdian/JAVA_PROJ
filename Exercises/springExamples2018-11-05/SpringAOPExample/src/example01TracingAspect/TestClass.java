package example01TracingAspect;

import org.springframework.stereotype.Component;

@Component
public class TestClass {
   public void foo() {
	System.out.println("foo");
   }

   public void bar() {
	System.out.println("bar");
   }

   public void wrapFoo() {
	foo();
   }
}
