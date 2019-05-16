package example11ManyToOne;

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

import trainologic.BusinessCustomer;
import trainologic.Customer;
import trainologic.Department;
import trainologic.Employee;
import trainologic.EmployeeCar;
import trainologic.EmployeeContract;
import trainologic.EmployeeTask;
import trainologic.VIPCustomer;



@Entity
class Department11 {
	@Id
	@GeneratedValue
	int id;
	String name;
	@OneToMany(mappedBy = "department")
	Set<Employee11> employees = new HashSet<Employee11>();

}

@Entity
class Employee11 {
 @Id
 @GeneratedValue
 int id;
 String name;
 @ManyToOne 
 Department11 department;
}


//Demonstrates persisting a simple object with Auto ID, and getting it back from DB with a Query
public class Example {
	public static void main(String[] args) {
	    EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpaDemo");
	    EntityManager em = factory.createEntityManager();
	    
	    // Write a simple client object to DB with auto genreated id;
	    em.getTransaction().begin();

		Department11 department1 = new Department11();
		department1.name = "R&D";
		
		Employee11 employee1 = new Employee11();
		employee1.name = "Al";
		
		Employee11 employee2 = new Employee11();
		employee2.name = "Bob";
		
		employee1.department = department1;
		employee2.department = department1;
		
		em.persist(department1);
		em.persist(employee1);
		em.persist(employee2);

		em.getTransaction().commit();
		
		Query q = em.createQuery("select e from Employee11 e");
		
	    List<Employee11> employees = q.getResultList();
	    for (Employee11 employee : employees) {
	      System.out.println(employee + " " + employee.name + " id =  " + employee.id );
	      System.out.println("    department = " + employee.department + " department name = " + employee.department.name);
	    }
	    em.close();
	    
	}

}
