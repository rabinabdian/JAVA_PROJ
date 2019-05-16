package example03CustomAnnotation;

import org.springframework.stereotype.Component;

@Component("myBean")
public class MyBean {
	
 public MyBean() {	}
	
 public String testAspectCall(int i){
      return "Hello-" + testAspectCallInt(i);
 }

  @MyAnnotation(value="valtest", key="keytest", condition="contest")
  public Integer testAspectCallInt(int i){
	System.out.println("MyBean.testAspectCallInt(i=" + i + ")");
	return i+1000;
  }
}
