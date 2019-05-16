package example06Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import hello.Customer;

@Repository // We will get native exceptions instead of spring exceptions without this bean
public class CustomerDAO {
	

	@PersistenceContext // like @Autowired , but adds more control 
	public EntityManager em ;

	@Transactional
	public void saveCustomer() {
		Customer customer = new Customer(1,"Gonen","Israeli");
		em.persist(customer);
		throw new RuntimeException("Error after persist");
	}

	@Transactional
	public void findCustomer() {
		// Finding written object using Find method
		System.out.println("Finding Persisted Object With Find");
		Customer foundCustomer = em.find(Customer.class, 1L);
		if ( foundCustomer == null )
			System.out.println("No customer found!");
		else
		    System.out.println("Client " + " Name = " + foundCustomer.getFirstName());
	}

}
