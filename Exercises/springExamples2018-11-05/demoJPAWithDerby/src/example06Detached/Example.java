package example06Detached;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import trainologic.Employee;

@Entity
class Client6
{
	String name;
	@Id  // means the id field will be the primary key
	@GeneratedValue // means the id will be assigned automatically
	int id; 
}

//Demonstrates persisting a simple object with Auto ID, and getting it back from DB with a Query
public class Example {
	public static void main(String[] args) {
	    EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpaDemo");
	    EntityManager em = factory.createEntityManager();
	    
	    // Write a simple client object to DB with auto genreated id;
	    em.getTransaction().begin();
	    Client6 client = new Client6();
	    client.name = "GonenV1";
	        
	    em.persist(client);
	    
	    // This change will be persisted on on commit
	    client.name = "GonenV2";

	    em.getTransaction().commit();
	    int generatedId = client.id;

	    // This change will not be persisted without a new transaction
	    client.name = "GonenV3";
	    
	    // Find the object in the DB - EntityManager Cache will mean we get the same object
	    System.out.println("Original Object Reference = " + client);
	    Client6 foundClient = em.find(Client6.class, generatedId);
	    System.out.println("Object reference from em.find" + foundClient);
	    System.out.println("Object reference from em.find = " + foundClient.name);
	    
	    // use these 2 lines to send the updated name to DB
	    //em.getTransaction().begin();
	    //em.getTransaction().commit(); 
   
	    System.out.println("Detaching Object");
	    // Make the object detached - not managed
	    em.detach(client); // or em.clear();
	    
	    foundClient = em.find(Client6.class, generatedId);
	    System.out.println("Detached Object reference from DB" + foundClient);
	    System.out.println("Detached object name = " + foundClient.name);
	    
	   
    
	    em.close();
	    
	}

}
