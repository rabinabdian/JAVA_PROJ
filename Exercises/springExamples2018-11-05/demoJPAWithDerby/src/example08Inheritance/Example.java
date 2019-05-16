package example08Inheritance;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Persistence;
import javax.persistence.Query;

import trainologic.BusinessCustomer;
import trainologic.Customer;
import trainologic.VIPCustomer;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
abstract class Customer8 {
   @Id
   @GeneratedValue
   protected int id;
   protected String name;
} 

@Entity
class BusinessCustomer8 extends Customer8 {
   protected String companyName;
}

@Entity
class VIPCustomer8 extends Customer8 {
   protected int discount;
}


//Demonstrates persisting a simple object with Auto ID, and getting it back from DB with a Query
public class Example {
	public static void main(String[] args) {
	    EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpaDemo");
	    EntityManager em = factory.createEntityManager();
	    
	    // Write a simple client object to DB with auto genreated id;
	    em.getTransaction().begin();
		BusinessCustomer8 businessCustomer = new BusinessCustomer8();
		businessCustomer.name = "Moshe";
		businessCustomer.companyName = "TSG";

		VIPCustomer8 vipCustomer = new VIPCustomer8();
		vipCustomer.name = "David";
		vipCustomer.discount = 20;
		
		em.persist(vipCustomer);
		em.persist(businessCustomer);
		
		em.getTransaction().commit();
		
	    Query q = em.createQuery("select c from VIPCustomer8 c where c.discount > 10");
	    List<Customer8> customer = q.getResultList();
	    for (Customer8 currentCustomer : customer) {
	      System.out.println("Customer " + currentCustomer.name + " id =  " + currentCustomer.id + " class = " + currentCustomer.getClass());
	    }

	    em.close();
	    
	}

}
