package example10OneToMany;

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
class EmployeeTask10 {
	@Id
	@GeneratedValue
	int id;
	String taskDescription;
}

@Entity
class Employee10 {
 @Id
 @GeneratedValue
 int id;
 String name;
 @OneToMany
 Set<EmployeeTask10> tasks = new HashSet<EmployeeTask10>(); 
}


//Demonstrates persisting a simple object with Auto ID, and getting it back from DB with a Query
public class Example {
	public static void main(String[] args) {
	    EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpaDemo");
	    EntityManager em = factory.createEntityManager();
	    
	    // Write a simple client object to DB with auto genreated id;
	    em.getTransaction().begin();

		Employee10 employee1 = new Employee10();
		employee1.name = "Al";
		
		Employee10 employee2 = new Employee10();
		employee2.name = "Bob";
		
		EmployeeTask10 task1 = new EmployeeTask10();
		task1.taskDescription = "Finish Build";
		EmployeeTask10 task2 = new EmployeeTask10();
		task2.taskDescription = "Design Web Access";
		employee1.tasks.add(task1);
		employee1.tasks.add(task2);
		
		em.persist(task1);
		em.persist(task2);
		em.persist(employee1);
		em.persist(employee2);

		em.getTransaction().commit();
		//em.detach(employeeCar);
		
		Query q = em.createQuery("select e from Employee10 e");
		
	    List<Employee10> employees = q.getResultList();
	    for (Employee10 employee : employees) {
	      System.out.println(employee + " " + employee.name + " id =  " + employee.id );
	      System.out.println("    Tasks:");
	      for ( EmployeeTask10 currentTask : employee.tasks)
	      {
	    	  System.out.println("     Task " + currentTask + " description = " +  currentTask.taskDescription);
	      }
	    }
	    em.close();
	    
	}

}
