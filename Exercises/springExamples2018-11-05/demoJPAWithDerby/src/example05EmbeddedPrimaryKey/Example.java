package example05EmbeddedPrimaryKey;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

//Demonstrates persisting a class with a primary key which is a member field with a type which is another entity class
public class Example {
	public static void main(String[] args) {
	    EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpaDemo");
	    EntityManager em = factory.createEntityManager();
	    
	    em.getTransaction().begin();
	
	    Item5 item = new Item5("Wooden Desk");
	    SerialNumber5 serial = new SerialNumber5();
	    serial.setIndex(101);
	    serial.setPrefix(201);
	    item.setSerialNumber(serial);
	    
	    em.persist(item);		
	    em.getTransaction().commit(); 

		// read the existing entries and write to console
		Item5 foundItem = em.find(Item5.class, serial);
		System.out.println(foundItem.getName() + " id.prefix=" + foundItem.getSerialNumber().getPrefix() + " id.index = " + foundItem.getSerialNumber().getIndex());
	       
	    em.close();
	    
	}

}
