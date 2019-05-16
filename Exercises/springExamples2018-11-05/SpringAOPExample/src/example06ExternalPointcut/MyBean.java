package example06ExternalPointcut;

import org.springframework.stereotype.Component;

@Component("myBean")
public class MyBean {
	
 public MyBean() {	}
	


  @MyAnnotation(value="valtest", key="keytest", condition="contest")
  public void testAspectCallInt(int i){
	System.out.println("MyBean.testAspectCallInt(i=" + i + ")");
  }
}
