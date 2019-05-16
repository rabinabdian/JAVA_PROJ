package example02AutowireEntityManager;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Client02
{
	String name;
	@Id  // means the id field will be the primary key
	@GeneratedValue // means the id will be assigned automatically
	int id; 
}
