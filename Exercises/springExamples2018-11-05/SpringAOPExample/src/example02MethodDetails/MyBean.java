package example02MethodDetails;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component("myBean")
public class MyBean {

	@Resource
	private String s1;
	@Resource
	private String s2;

	@PostConstruct
	public void init() {
		System.out.println("MyBean.init() - s1:[" + s1 + "]");
		System.out.println("MyBean.init() - s2:[" + s2 + "]");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("MyBean.destroy()");
	}

	@Override
	public String toString() {
		return "MyBean [s1=" + s1 + ", s2=" + s2 + "]";
	}

	public String testAspectCall(int i) {
		return "Hello-" + testAspectCallInt(i);
	}

	public Integer testAspectCallInt(int i) {
		System.out.println("MyBean.testAspectCallInt(i=" + i + ")");
		return i + 1000;
	}
}
