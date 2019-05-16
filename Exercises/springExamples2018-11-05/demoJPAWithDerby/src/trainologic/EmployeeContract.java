package trainologic;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class EmployeeContract {
	@Id
	@GeneratedValue
	int id;
	int salary;
	Employee theEmployee;
}
