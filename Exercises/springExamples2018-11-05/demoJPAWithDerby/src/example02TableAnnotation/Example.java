package example02TableAnnotation;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.TypedQuery;

import trainologic.Employee;

@Entity
@Table( name = "ImportantClient" )
class Client2
{
	@Column(name = "TheName", insertable=true, updatable=false) // this field will not generate Update statements
	String name;
	@Column( insertable=true, updatable=true)
	int height;
	@Id
	@GeneratedValue
	int id;
	@Transient
	int age; // this field will not be written to DB
}

// Demonstrates the annotations @Table (name=), @Column name/insertable/updatable , and @Transient
public class Example {
	public static void main(String[] args) {
	    EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpaDemo");
	    EntityManager em = factory.createEntityManager();
	    
	    em.getTransaction().begin();
	    Client2 client = new Client2();
	    em.persist(client);

	    client.name = "Gonen2";
	    client.age = 39; // ;)
	    client.height = 175;
	    
	    em.getTransaction().commit();

	    // Try to update
	    em.getTransaction().begin();
	    client.age = 29;
	    client.height = 185;
	    client.name = "Gonen2B"; 
	    em.getTransaction().commit();

	    em.clear(); // without this line client will still point to the original object, so age would still be 29, and name "Gonen2B"
	    // without this line the non updatable field name still shows as updated in the query result, even though it is not updated in the DB. A bug?
	    factory.getCache().evictAll();  
	    
		System.out.println("Getting result lists");
		TypedQuery<Client2> q = em.createQuery("select c from Client2 c",Client2.class);     
	    List<Client2> clients = q.getResultList();
	    for (Client2 current : clients) {
	    	System.out.println("Client "  + " Name = " +current.name +  " Height = " + current.height  + " age = " + current.age);
	    }
	    em.close();
    
	    
	}

}
