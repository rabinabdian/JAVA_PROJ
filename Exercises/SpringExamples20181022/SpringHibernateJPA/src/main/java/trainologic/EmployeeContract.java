package trainologic;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class EmployeeContract {
	@Id
	@GeneratedValue
	int id;
	int salary;
	@OneToOne
	Employee theEmployee;
}
