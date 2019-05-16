package trainologic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Customer {
   private int id;
   private String name;

   @Id
   @GeneratedValue
   public int getId() { return id; }

   public void setId(int id) {this.id = id;}

   public String getName() {
	return name;
   }

   public void setName(String name) {
	this.name = name;
   }

} 
