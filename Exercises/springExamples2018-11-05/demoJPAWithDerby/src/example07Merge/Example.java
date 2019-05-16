package example07Merge;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Persistence;

@Entity
class Client7
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
	    Client7 client = new Client7();
	    client.name = "Gonen";
	    em.persist(client);
	    em.getTransaction().commit();
	    int generatedId = client.id;

	    em.detach(client); // or em.clear();

	    Client7 client2 = new Client7();
	    client2.id = generatedId;
	    client2.name = "new name";
	    // em.persist(client2);  // would cause duplicate id exception during commit
	    em.merge(client2);
	    
	    em.getTransaction().begin();
	    em.getTransaction().commit();
	    
	    System.out.println("Finding updated client:");
	    Client7 foundClient = em.find(Client7.class, generatedId);
    	System.out.println("Client "  + " Name = " + foundClient.name);  


	    em.close();
	    
	}

}
