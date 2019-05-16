package example14FetchJoin;

import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import trainologic.BusinessCustomer;
import trainologic.Customer;
import trainologic.Department;
import trainologic.Employee;
import trainologic.EmployeeCar;
import trainologic.EmployeeContract;
import trainologic.EmployeeTask;
import trainologic.VIPCustomer;



@Entity
class Order14 {
 @Id
 @GeneratedValue
 int id;
 String product;
}

@Entity
class Customer14 {
	@Id
	@GeneratedValue
	int id;
	String name;
	@OneToMany
	Set<Order14> orders = new HashSet<Order14>();
}




//Demonstrates persisting a simple object with Auto ID, and getting it back from DB with a Query
public class Example {
	public static void main(String[] args) {
	    EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpaDemo");
	    EntityManager em = factory.createEntityManager();
	    
	    // Write a simple client object to DB with auto genreated id;
	    em.getTransaction().begin();

		Customer14 customer1 = new Customer14();
		customer1.name = "Alex"; 
		
		
		Order14 order1 = new Order14();
		order1.product = "TV";
		Order14 order2 = new Order14();
		order2.product = "Book"; 

		customer1.orders.add(order1);
		customer1.orders.add(order2);

		
		em.persist(customer1);
		em.persist(order1);
		em.persist(order2);
		
		em.getTransaction().commit();
		
		em.clear();
		factory.getCache().evictAll();
		
		//System.out.println("Fetch join");
		//TypedQuery<Customer14> q = em.createQuery("select c from Customer14 c JOIN fetch c.orders",Customer14.class); // Fetches orders for each customer even if task not used, similar to declaring tasks as @OneToMany(fetch=FetchType.EAGER)    
	    System.out.println("Regular Join");
		TypedQuery<Customer14> q = em.createQuery("select c from Customer14 c",Customer14.class);  // Does not fetch order for each customer if orders not used    
		System.out.println("Getting result lists");
	    List<Customer14> customers = q.getResultList();
		System.out.println("Printing results");	    
	    for (Customer14 customer : customers) {
	    	//System.out.println("Customer "  + " Name = " + customer.name);  // no fetch on task
	    	Order14 firstOrder = customer.orders.iterator().next();
			System.out.println("Customer " + customer.name + " first order  = " + firstOrder.product); // fetch on task
	 
	    }

		
	    em.close();
	    
	}

}
