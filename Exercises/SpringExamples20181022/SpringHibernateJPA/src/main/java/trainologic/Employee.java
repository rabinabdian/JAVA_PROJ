package trainologic;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Employee {
 @Id
 @GeneratedValue
 int id;
 String name;
 @ManyToOne 
 Department department;
 @OneToOne EmployeeCar car;
 @OneToOne( cascade=CascadeType.PERSIST, mappedBy="theEmployee")
 EmployeeContract contract;
 @OneToMany
 Set<EmployeeTask> tasks = new HashSet<EmployeeTask>(); 
}
