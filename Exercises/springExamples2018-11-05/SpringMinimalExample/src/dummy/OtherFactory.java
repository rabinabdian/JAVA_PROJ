package dummy;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import person2Package.Person2;

@Configuration
public class OtherFactory {
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public Person2 createPerson2() {
		System.out.println("getPerson2 called in other factory");
		return new Person2();
	}

}