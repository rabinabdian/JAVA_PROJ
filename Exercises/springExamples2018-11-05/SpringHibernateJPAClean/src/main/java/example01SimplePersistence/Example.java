package example01SimplePersistence;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

@Entity
class Client01
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
	    
	    em.getTransaction().begin();
	    Client01 client = new Client01();
	    client.name = "Gonen";
	    em.persist(client);
	    em.getTransaction().commit();
	    
	    
	    
	    // Finding Written using Query
		System.out.println("Getting result lists");
		TypedQuery<Client01> q = em.createQuery("select c from Client01 c",Client01.class);     
	    List<Client01> clients = q.getResultList();
	    for (Client01 currentClient : clients) {
	    	printClient(currentClient);  
	    }
	    
	    // Finding written object using Find method
	    System.out.println("Finding Persisted Object With Find");
	    int generatedId = client.id;
	    Client01 foundClient = em.find(Client01.class, generatedId);
    	printClient(foundClient);  

	    em.close();
	    
	}

	private static void printClient(Client01 foundClient) {
		System.out.println("Client "  + " Name = " + foundClient.name);
	}

}
