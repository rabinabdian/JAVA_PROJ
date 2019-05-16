package example02AutowireEntityManager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan
public class PersistenceJPAConfig {
	// Creates our entity factory
	@Bean
	public LocalEntityManagerFactoryBean getEMFactory()
	{
	   LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
	   factoryBean.setPersistenceUnitName("jpaDemo");
	   return factoryBean;
	}
	
	@Bean
	PlatformTransactionManager getPlatformTransactionManager() // necessary for transactions
	{
		org.springframework.orm.jpa.JpaTransactionManager jpaTransactionManager = new org.springframework.orm.jpa.JpaTransactionManager();
		jpaTransactionManager.setEntityManagerFactory(getEMFactory().getObject());
		return jpaTransactionManager;
	}

}