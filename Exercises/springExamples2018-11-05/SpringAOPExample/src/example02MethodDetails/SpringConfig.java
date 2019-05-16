package example02MethodDetails;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("example02MethodDetails")
@EnableAspectJAutoProxy
public class SpringConfig {
	@Bean
	public String stringBean() {
		String str = "Hello " + (int) (Math.random() * 11);
		return str;
	}

}
