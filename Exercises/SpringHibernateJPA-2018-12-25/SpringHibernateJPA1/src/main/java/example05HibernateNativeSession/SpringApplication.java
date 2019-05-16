package example05HibernateNativeSession;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.Customer;

public class SpringApplication {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(PersistenceJPAConfig.class); // should
																										// be
																										// closed
		SessionFactory sessionFactory = (SessionFactory) ctx.getBean(SessionFactory.class);
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Customer customer = new Customer(1, "Al", "Sharpton");
		session.save(customer);
		session.getTransaction().commit();

		// read the existing entries and write to console
		Query q = session.createQuery("select i from Customer i where i.id = 1");
		List<Customer> customers = q.getResultList();
		for (Customer current : customers) {
			System.out.println(current.getId() + " Name = " + current.getFirstName() + " " + current.getLastName());
		}
		session.close();
	}

}
