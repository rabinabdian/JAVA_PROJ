package example08TransactionalProperties;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.Customer;

public class SpringApplication {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(PersistenceJPAConfig.class);
		CustomerDAO customerDAO = ctx.getBean(CustomerDAO.class);
		CustomerDAO2 customerDAO2 = ctx.getBean(CustomerDAO2.class);
		try 
		{
		customerDAO.saveCustomer();
		}
		catch( RuntimeException e)
		{
			System.out.println("Got exception: " + e.getMessage());
		}
		customerDAO.findCustomer();
		ctx.close();
	}

}
