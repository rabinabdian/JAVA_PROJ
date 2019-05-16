package trainologic;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class Example {
public static void main(String[] args) {
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpaDemo");
    //EntityManagerFactory factory = Persistence.createEntityManagerFactory("existingitems");
    EntityManager em = factory.createEntityManager();
    
    em.getTransaction().begin();
    
    //demoCompanies(em);
    //demoEmbedded(em);
    //demoEmbeddedPrimaryKey(em);
    //demoInheritance(em);
    //demoRelationships(em);
    //demoQueries(em);
    demoFetchJoin(em);
    
    em.close();

}

private static void demoFetchJoin(EntityManager em) {

//	Department department1 = new Department();
//	department1.name = "R&D";
//	Employee employee1 = new Employee();
//	employee1.name = "Al";
//	employee1.department = department1;
//	em.persist(department1);
//	em.persist(employee1);
//	
//	em.getTransaction().commit();

	EmployeeTask task1 = new EmployeeTask();
	task1.taskDescription = "Finish Build";
	Employee employee1 = new Employee();
	employee1.name = "Al";
	employee1.tasks.add(task1);
	em.persist(task1);
	em.persist(employee1);
	
	em.getTransaction().commit();
	
	System.out.println("Fetch join");
	TypedQuery<Employee> q = em.createQuery("select e from Employee e JOIN fetch e.tasks",Employee.class); // Fetches task for each employee even if task not used, similar to declaring tasks as @OneToMany(fetch=FetchType.EAGER)    
    //System.out.println("Regular Join");
	//TypedQuery<Employee> q = em.createQuery("select e from Employee e",Employee.class); // Does not fetch task for each employee if tasks not used
	System.out.println("Getting result lists");
    List<Employee> employees = q.getResultList();
    for (Employee employee : employees) {
    	System.out.println("Employee "  + " Name = " + employee.name);  // no fetch on task
    	//System.out.println("Employee " + employee.name + " first task  = " + employee.tasks.iterator().next()); // fetch on task
 
    }

}

private static void demoQueries(EntityManager em) {
	
	EmployeeTask task1 = new EmployeeTask();
	task1.taskDescription = "Finish Build";
	EmployeeTask task2 = new EmployeeTask();
	task2.taskDescription = "Design Web Access";
	EmployeeTask task3 = new EmployeeTask();
	task3.taskDescription = "Make coffee";
	
	Employee employee1 = new Employee();
	employee1.name = "Al";
	
	Employee employee2 = new Employee();
	employee2.name = "Bob";

	employee1.tasks.add(task1);
	employee1.tasks.add(task2);
	
	em.persist(task1);
	em.persist(task2);
	em.persist(task3);
	em.persist(employee1);
	em.persist(employee2);


	em.getTransaction().commit();
	
	// Inner Join
    System.out.println("Inner Join");
	Query q = em.createQuery("select t from Employee e join e.tasks t");
	
    List<EmployeeTask> tasks = q.getResultList();
    for (EmployeeTask task : tasks) {
    	System.out.println("Task " + task.taskDescription);
    }
    
    // Left outer join    Select d FROM Computer c LEFT OUTER JOIN c.disks d
    System.out.println("Left Outer Join");
	Query query2 = em.createQuery("select e.name,t.taskDescription from Employee e LEFT OUTER join e.tasks t");
    List<Object[]> tasks2 = query2.getResultList();
    for (Object[] task : tasks2) {
    	System.out.println("e.name " + task[0] + " t.taskDescription " + task[1]);
    }
    
    System.out.println("Collection Member Variable and In ");
	TypedQuery<EmployeeTask> query3 = em.createQuery("select t FROM Employee e, IN(e.tasks) t",EmployeeTask.class); // selects tasks from all the employees' employee tasks
    List<EmployeeTask> tasksWithEmployees = query3.getResultList();
    for (EmployeeTask task : tasksWithEmployees) {
    	System.out.println("Task = " + task.taskDescription);
    }

    System.out.println("In Clause");
	TypedQuery<Employee> query4 = em.createQuery("select e From Employee e where e.name like ('B%')",Employee.class);
    List<Employee> employeesNamedAl = query4.getResultList();
    for (Employee employee : employeesNamedAl) {
    	System.out.println("Employee 1 = " +employee.name + " id = " + employee.id);
    }
    
    System.out.println("Using Arbitrary Constructors");
	TypedQuery<EmployeeWrapper> query5 = em.createQuery("SELECT NEW trainologic.EmployeeWrapper(e) From Employee e",EmployeeWrapper.class);
	List<EmployeeWrapper> wrappers = query5.getResultList();
    for (EmployeeWrapper employeeWrapper : wrappers) {
    	System.out.println("Wrapper for employee = " +employeeWrapper.employee.name);
    }
	
    System.out.println("Criteria Query");
    CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
    CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
    Root<Employee> from = criteriaQuery.from(Employee.class);
    TypedQuery<Employee> employeesQuery = em.createQuery(criteriaQuery);
    for( Employee curEmployee : employeesQuery.getResultList() )
    {
    	System.out.println("Employee " + curEmployee.name);
    }



  
}

private static void demoRelationships(EntityManager em) {

	EmployeeCar employeeCar = new EmployeeCar();
	employeeCar.carType= "Corolla";
	

	Department department1 = new Department();
	department1.name = "R&D";
	Employee employee1 = new Employee();
	employee1.name = "Al";
	employee1.department = department1;
	employee1.car = employeeCar;
	
	Employee employee2 = new Employee();
	employee2.name = "Bob";
	employee2.department = department1;
	employee2.car = employeeCar;

	EmployeeContract contract1 = new EmployeeContract();
	contract1.salary = 100;
	contract1.theEmployee = employee1;
	employee1.contract = contract1;
	
	EmployeeContract contract2 = new EmployeeContract();
	contract2.salary = 200;
	contract2.theEmployee = employee2;
	employee2.contract = contract2;

	
	System.out.println("Department1 Original Object = " + department1);
	System.out.println("EmployeeCar Original Object = " + employeeCar);
	System.out.println("Contract1 Original Object = " + contract1);
	
	EmployeeTask task1 = new EmployeeTask();
	task1.taskDescription = "Finish Build";
	EmployeeTask task2 = new EmployeeTask();
	task2.taskDescription = "Design Web Access";
	employee1.tasks.add(task1);
	employee1.tasks.add(task2);
	
	em.persist(task1);
	em.persist(task2);
	em.persist(employeeCar);
	em.persist(employee1);
	em.persist(employee2);
	em.persist(department1);
	//em.persist(contract1);  // Persisting by cascade property on Employee instead.
	//em.persist(contract2);

	em.getTransaction().commit();
	//em.detach(employeeCar);
	
	department1.name = "new department name change after commit";

	Query q = em.createQuery("select e from Employee e");
	
    List<Employee> employees = q.getResultList();
    for (Employee employee : employees) {
      System.out.println(employee + " " + employee.name + " id =  " + employee.id );
      System.out.println("    department = " + employee.department + " department name = " + employee.department.name);
      System.out.println("    car = " + employee.car + " car type = " + employee.car.carType);
      System.out.println("    contract = " + employee.contract + " salary = " + employee.contract.salary + " contract.theEmployee = " + employee.contract.theEmployee);
      System.out.println("    Tasks:");
      for ( EmployeeTask currentTask : employee.tasks)
      {
    	  System.out.println("     Task " + currentTask + " description = " +  currentTask.taskDescription);
      }
    }
}

private static void demoInheritance(EntityManager em) {
	BusinessCustomer businessCustomer = new BusinessCustomer();
	businessCustomer.setName("Moshe");
	businessCustomer.setId(getRandomID());
	VIPCustomer vipCustomer = new VIPCustomer();
	vipCustomer.setName("Pessy");
	vipCustomer.setId(getRandomID());
	
	em.persist(vipCustomer);
	em.persist(businessCustomer);
	
	em.getTransaction().commit();
	
    Query q = em.createQuery("select c from VIPCustomer c where c.discount = 0");
    List<Customer> customer = q.getResultList();
    for (Customer currentCustomer : customer) {
      System.out.println("Customer " + currentCustomer.getName() + " id =  " + currentCustomer.getId() + " class = " + currentCustomer.getClass());
    }
	
}

private static void demoEmbeddedPrimaryKey(EntityManager em) {
    CompositeService2 compositeService2 = new CompositeService2();
    compositeService2.setName("service1");
    CompositeServicePK2 primaryKeyObject = new CompositeServicePK2();
    primaryKeyObject.setId1("A"+getRandomID());
    primaryKeyObject.setId2("B"+getRandomID());    
    compositeService2.setPk(primaryKeyObject);
    em.persist(compositeService2);	
    
    em.persist(compositeService2);
    em.getTransaction().commit();

 
    // read the existing entries and write to console
    Query q = em.createQuery("select c from CompositeService2 c");
    List<CompositeService2> services = q.getResultList();
    for (CompositeService2 currentService : services) {
      System.out.println("Service " + currentService.getName() + "PK.id1 " + currentService.getPk().getId1() );
    }

}

private static void demoCompanies(EntityManager em) {
	Company company = new Company();
    company.setName("International Business Machines");
    company.setSymbol("IBM");
    //company.setSymbol(null);
    company.setId(getRandomID());
    em.persist(company);
    em.getTransaction().commit();

 
    // read the existing entries and write to console
    Query q = em.createQuery("select c from Company c");
    List<Company> companies = q.getResultList();
    for (Company currentCompany : companies) {
      System.out.println(currentCompany.getId() + " " + currentCompany.getName());
    }
}

private static int getRandomID() {
	return (int)(Math.random()*100000);
}

private static void demoEmbedded(EntityManager em) {
	  Item item = new Item("Desk");
    int randomID = getRandomID();
	item.setId(randomID);
    Size size = new Size();
    size.setHeight(100);
    size.setWidth(200);
    item.setSize(size);
    em.persist(item);
       
    em.getTransaction().commit(); 

 
    // read the existing entries and write to console
    Query q = em.createQuery("select i from Item i where i.id = "+randomID);
    List<Item> items = q.getResultList();
    for (Item currentItem : items) {
      System.out.println(currentItem.getId() + " width = " + currentItem.getSize().getWidth());
    }
	
    


}

}




