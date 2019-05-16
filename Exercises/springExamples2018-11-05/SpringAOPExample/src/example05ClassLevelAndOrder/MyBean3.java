package example05ClassLevelAndOrder;

import org.springframework.stereotype.Component;

@Component("myBean3")
 public class MyBean3 {
     public Integer testAspectCallInt(int i){
	System.out.println("MyBean2.testAspectCallInt(i=" + i + ")");
	return i+1000;
    }
}
