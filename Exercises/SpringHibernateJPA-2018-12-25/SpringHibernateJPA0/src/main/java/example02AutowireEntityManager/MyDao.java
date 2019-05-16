package example02AutowireEntityManager;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;



@Repository // like @Component, but adds Exception Translation 
public class MyDao {
	

	@PersistenceContext // like @Autowired , but adds more control 
	public EntityManager em ;

	@Transactional
	public void doJPAStuff() {

		Client02 client = new example02AutowireEntityManager.Client02();
		client.name = "Gonen";
		em.persist(client);
		

		em.flush(); // Will cause SQL INSERT now, instead of at end of transaction
		//em.clear(); // Will cause SQL SELECT
		
		// Finding written object using Find method
		System.out.println("Finding Persisted Object With Find");
		int generatedId = client.id;
		Client02 foundClient = em.find(Client02.class, generatedId);
		System.out.println("Client " + " Name = " + foundClient.name);

		em.close();
	}

}
