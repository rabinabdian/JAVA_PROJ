package trainologic;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class EmployeeTask {
	@Id
	@GeneratedValue
	int id;
	String taskDescription;
}
