package example07ManualTransaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import hello.Customer;

@Repository 
public class CustomerDAO {
	

	@PersistenceUnit
	EntityManagerFactory entityManagerFactory ;


	//@Transactional - Use JPA-EM Transactions instead
	public void saveCustomer() {
		EntityManager em = entityManagerFactory.createEntityManager(); // Get our own EM for manual transactions
		em.getTransaction().begin();
		Customer customer = new Customer(1,"Gonen","Israeli");
		em.persist(customer);
		if ( 1 == 1)
		 throw new RuntimeException("Error after persist");
		em.getTransaction().commit();
	}

	//@Transactional
	public void findCustomer() {
		EntityManager em = entityManagerFactory.createEntityManager();
		// Finding written object using Find method
		System.out.println("Finding Persisted Object With Find");
		Customer foundCustomer = em.find(Customer.class, 1L);
		if ( foundCustomer == null )
			System.out.println("No customer found!");
		else
		    System.out.println("Client " + " Name = " + foundCustomer.getFirstName());
	}

}
