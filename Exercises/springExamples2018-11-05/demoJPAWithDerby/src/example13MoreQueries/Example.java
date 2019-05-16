package example13MoreQueries;

import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.eclipse.persistence.jpa.config.Cascade;

import trainologic.BusinessCustomer;
import trainologic.Customer;
import trainologic.Department;
import trainologic.Employee;
import trainologic.EmployeeCar;
import trainologic.EmployeeContract;
import trainologic.EmployeeTask;
import trainologic.EmployeeWrapper;
import trainologic.VIPCustomer;




@Entity
class Pet13
{
	 @Id
	 @GeneratedValue
	 int id;
	 String nickName;
}

@Entity
class Owner13 {
 @Id
 @GeneratedValue
 int id;
 String name;
 @OneToMany (cascade=CascadeType.PERSIST)
 Set<Pet13> pets = new HashSet<Pet13>();
}

class AnimalHouse
{
	Pet13 pet;
	public AnimalHouse(Pet13 pet)
	{
		this.pet = pet;
	}
}





//Demonstrates persisting a simple object with Auto ID, and getting it back from DB with a Query
public class Example {
	public static void main(String[] args) {
	    EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpaDemo");
	    EntityManager em = factory.createEntityManager();
	    
	    // Write a simple client object to DB with auto genreated id;
	    em.getTransaction().begin();

	    Pet13 dog1 = new Pet13();
	    dog1.nickName = "Rover";

	    Pet13 cat1 = new Pet13();
	    cat1.nickName = "Mitzee";
	    
	    Pet13 gerbil1 = new Pet13();
	    gerbil1.nickName = "Foofoo";

		Owner13 owner1 = new Owner13();
		owner1.name = "Johnny";
		owner1.pets.add(dog1);
		owner1.pets.add(cat1);
			
		Owner13 owner2 = new Owner13();
		owner2.name = "Lonesome";
		
		em.persist(owner1);
		em.persist(owner2);
		em.persist(gerbil1);
		
		em.getTransaction().commit();
		
		// Inner Join
	    System.out.println("Inner Join - Owners with pets");
		TypedQuery<Owner13> q = em.createQuery("select o from Owner13 o join o.pets p",Owner13.class);
	    List<Owner13> owners = q.getResultList();
	    for (Owner13 owner : owners) {
	    	System.out.println("Owner name " + owner.name);
	    }
	    
	    System.out.println("Collection Member Variable and In. Pets with owners = ");
		TypedQuery<Pet13> query3 = em.createQuery("select p FROM Owner13 o, IN(o.pets) p",Pet13.class); // selects pets from all the owners' pets
	    List<Pet13> petsWithOwners = query3.getResultList();
	    for (Pet13 pet : petsWithOwners) {
	    	System.out.println("Pet = " + pet.nickName);
	    }
	    System.out.println("Collection Member Variable and In. Owners with pets = ");
		TypedQuery<Owner13> query4 = em.createQuery("select o FROM Owner13 o, IN(o.pets) p",Owner13.class); // selects owners from all the owners' pets
	    List<Owner13> ownersWithPets = query4.getResultList();
	    for (Owner13 owner : ownersWithPets) {
	    	System.out.println("Owner = " + owner.name);
	    }
	    
	    System.out.println("In Clause - Owners beginning with Lone");
		TypedQuery<Owner13> query5 = em.createQuery("select o From Owner13 o where o.name like ('Lone%')",Owner13.class);
	    List<Owner13> ownersStartingWithLone = query5.getResultList();
	    for (Owner13 owner : ownersStartingWithLone) {
	    	System.out.println("Owner = " + owner.name);
	    }
	    
	 
	    System.out.println("Using Arbitrary Constructors");
		TypedQuery<AnimalHouse> query6 = em.createQuery("SELECT NEW example13MoreQueries.AnimalHouse(p) From Pet13 p",AnimalHouse.class);
		List<AnimalHouse> houses = query6.getResultList();
	    for (AnimalHouse house : houses) {
	    	System.out.println("House for pet = " +house.pet.nickName);
	    }
	    
	    System.out.println("Criteria Query");
	    CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
	    CriteriaQuery<Owner13> criteriaQuery = criteriaBuilder.createQuery(Owner13.class);
	    TypedQuery<Owner13> ownerQuery = em.createQuery(criteriaQuery);
	    for( Owner13 owner : ownerQuery.getResultList() )
	    {
	    	System.out.println("Owner " + owner.name);
	    }
	    
	    em.close();
	    
	}

}
