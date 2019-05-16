package example03Optional;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

@Entity
class Client3
{
	//@Basic( optional = false ) // Supposed to be enforced by JPA runtime. Does not work with EclipseLink/Derby
	@Column( nullable = false ) // Supposed to be enforced by SQL DB itself
	String name;
	String nickName;
	@Id  // means the id field will be the primary key
	@GeneratedValue // means the id will be assigned automatically
	int id; 
}

//Demonstrates the optional vs nullable properties
public class Example {
	public static void main(String[] args) {
	    EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpaDemo");
	    EntityManager em = factory.createEntityManager();
	    
	    em.getTransaction().begin();
	    Client3 client = new Client3();
	    // client.name = null; // Will generate a runtime error
	    client.name = "Gonen";
	    client.nickName = null;
	    em.persist(client);
	    em.getTransaction().commit();
	    
		System.out.println("Getting result lists");
		TypedQuery<Client3> q = em.createQuery("select c from Client3 c",Client3.class);     
	    List<Client3> clients = q.getResultList();
	    for (Client3 current : clients) {
	    	System.out.println("Client "  + " Name = " + current.name + " NickName = " + current.nickName);  
	    }

	    em.close();
	    
	}

}
