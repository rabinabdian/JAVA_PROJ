package example05ClassLevelAndOrder;

import org.springframework.stereotype.Component;

@Component("myBean2")
@MyAnnotation(value="valtest-classLevel2", key="keytest-classLevel2", condition="contest-classLevel2")
 public class MyBean2 {
     public Integer testAspectCallInt(int i){
	System.out.println("MyBean2.testAspectCallInt(i=" + i + ")");
	return i+1000;
    }
}
