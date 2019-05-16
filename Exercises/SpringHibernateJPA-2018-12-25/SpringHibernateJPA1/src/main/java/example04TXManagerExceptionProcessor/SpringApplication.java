package example04TXManagerExceptionProcessor;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.Customer;

public class SpringApplication {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(PersistenceJPAConfig.class); // should
																										// be
																										// closed
		EntityManagerFactory entityManagerFactory = (EntityManagerFactory) ctx.getBean("entityManagerFactory");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Customer customer = new Customer(1, "Al", "Sharpton");
		entityManager.persist(customer);
		entityManager.getTransaction().commit();

		// read the existing entries and write to console
		Query q = entityManager.createQuery("select i from Customer i where i.id = 1");
		List<Customer> customers = q.getResultList();
		for (Customer current : customers) {
			System.out.println(current.getId() + " Name = " + current.getFirstName() + " " + current.getLastName());
		}
		entityManager.close();
	}

}
