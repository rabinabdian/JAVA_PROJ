package trainologic;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class EmployeeCar {
	@Id
	@GeneratedValue
	int id;
	String carType;
}
