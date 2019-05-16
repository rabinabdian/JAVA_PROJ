package example09OneToOne;

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
class EmployeeCar9 {
	@Id
	@GeneratedValue
	int id;
	String carType;
}

@Entity
class EmployeeContract9 {
	@Id
	@GeneratedValue
	int id;
	int salary;
	Employee9 theEmployee; // Back-Reference
}

@Entity
class Employee9 {
 @Id
 @GeneratedValue
 int id;
 String name;
 @OneToOne EmployeeCar9 car; // Uni-Directional
 @OneToOne( cascade=CascadeType.PERSIST, mappedBy="theEmployee")
 EmployeeContract9 contract; // Bi-Directional
}


//Demonstrates persisting a simple object with Auto ID, and getting it back from DB with a Query
public class Example {
	public static void main(String[] args) {
	    EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpaDemo");
	    EntityManager em = factory.createEntityManager();
	    
	    // Write a simple client object to DB with auto genreated id;
	    em.getTransaction().begin();
		EmployeeCar9 employeeCar = new EmployeeCar9();
		employeeCar.carType= "Corolla";
		
		Employee9 employee1 = new Employee9();
		employee1.name = "Al";
		employee1.car = employeeCar;
		
		EmployeeContract9 contract1 = new EmployeeContract9();
		contract1.salary = 100;
		contract1.theEmployee = employee1;
		employee1.contract = contract1;
			
		em.persist(employee1);
		em.persist(employeeCar);  // Commenting out this line will throw an exception when employee is persisted
		//em.persist(contract1);  // Persisting by cascade property on Employee instead.

		em.getTransaction().commit();
		//em.detach(employeeCar);
		
		Query q = em.createQuery("select e from Employee9 e");
		
	    List<Employee9> employees = q.getResultList();
	    for (Employee9 employee : employees) {
	      System.out.println("Employee = " + employee + " " + employee.name + " id =  " + employee.id );
	      System.out.println("    car = " + employee.car + " car type = " + employee.car.carType);
	      System.out.println("    contract = " + employee.contract + " salary = " + employee.contract.salary + " contract.theEmployee = " + employee.contract.theEmployee);
	    }

	    em.close();
	    
	}

}
