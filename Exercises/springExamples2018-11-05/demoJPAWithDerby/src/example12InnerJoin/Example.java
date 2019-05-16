package example12InnerJoin;

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

import trainologic.BusinessCustomer;
import trainologic.Customer;
import trainologic.Department;
import trainologic.Employee;
import trainologic.EmployeeCar;
import trainologic.EmployeeContract;
import trainologic.EmployeeTask;
import trainologic.VIPCustomer;



@Entity
class Order12 {
 @Id
 @GeneratedValue
 int id;
 String product;
 @Temporal(value = TemporalType.DATE) 
 Date date;
 @ManyToOne 
 Customer12 customer;
}

@Entity
class Customer12 {
	@Id
	@GeneratedValue
	int id;
	String name;
	String address;
	@OneToMany(mappedBy = "customer")
	Set<Order12> orders = new HashSet<Order12>();
}




//Demonstrates persisting a simple object with Auto ID, and getting it back from DB with a Query
public class Example {
	public static void main(String[] args) {
	    EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpaDemo");
	    EntityManager em = factory.createEntityManager();
	    
	    // Write a simple client object to DB with auto genreated id;
	    em.getTransaction().begin();

		Customer12 customer1 = new Customer12();
		customer1.name = "Alex"; customer1.address = "Tel-Aviv";
		Customer12 customer2 = new Customer12();
		customer2.name = "Bob"; customer2.address = "Jerusalem";
		Customer12 customer3 = new Customer12();
		customer3.name = "Carol"; customer3.address = "Haifa";
		
		
		Order12 order1 = new Order12();
		order1.product = "TV"; order1.date = new GregorianCalendar(2015,5,5).getTime();
		Order12 order2 = new Order12();
		order2.product = "Book"; order2.date = new GregorianCalendar(2015,4,5).getTime();
		Order12 order3 = new Order12();
		order3.product = "Couch"; order3.date = new Date();

		customer1.orders.add(order1);
		customer1.orders.add(order2);
		order1.customer = customer1;
		order2.customer = customer1;

		customer3.orders.add(order3);
		order3.customer = customer3;
		
		em.persist(customer1);
		em.persist(customer2);
		em.persist(customer3);
		em.persist(order1);
		em.persist(order2);
		em.persist(order3);
		
		em.getTransaction().commit();
		
		// Inner Join
	    System.out.println("Inner Join");
		//Equivalent to select c.name,c.address,o.product,o.date from Customer12 inner join orders on Customer12.CustomerID = Orders12.CustomerID 
		Query q = em.createQuery("select c.name,c.address,o.product,o.date from Customer12 c inner join c.orders o on o.customer = c");

		// Shortened form
		//Query q = em.createQuery("select c.name,c.address,o.product,o.date from Customer12 c join c.orders o");

	    
	    List<Object[]> lines = q.getResultList();
	    for (Object[] line : lines) {
	    	System.out.println("Customer name " + line[0] + " address " + line[1] + " Order product: " + line[2] + " date " + line[3]);
	    }

	    System.out.println("Left outer Join");
		q = em.createQuery("select c.name,c.address,o.product,o.date from Customer12 c left outer join c.orders o on o.customer = c");
		lines = q.getResultList();
	    for (Object[] line : lines) {
	    	System.out.println("Customer name " + line[0] + " address " + line[1] + " Order product: " + line[2] + " date " + line[3]);
	    }
	    
	    em.close();
	    
	}

}
