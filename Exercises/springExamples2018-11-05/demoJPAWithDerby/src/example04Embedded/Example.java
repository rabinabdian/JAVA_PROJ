package example04Embedded;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.persistence.TypedQuery;

import trainologic.Item;
import trainologic.Size;

@Entity
class Item4 {
private String name;
@Id
@GeneratedValue // means the id will be assigned automatically
private int id;
private Size size;

public Item4() {}
public Item4(String name) {this.name = name;}

public int getId() {return id;}
public void setId(int id) {this.id = id;}
@Embedded
public Size getSize() {return size;}
public void setSize(Size size) {this.size = size;}
public String getName() {return name;}
public void setName(String name) {this.name = name;}
}

//Demonstrates persisting a class with fields from a member of another class embedded directly into the parent class table
public class Example {
	public static void main(String[] args) {
	    EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpaDemo");
	    EntityManager em = factory.createEntityManager();
	    
	    em.getTransaction().begin();
	
	    Item4 item = new Item4("Desk");
	    Size size = new Size();
	    size.setHeight(100);
	    size.setWidth(200);
	    item.setSize(size);
	    
	    em.persist(item);		
	    em.getTransaction().commit(); 

		// read the existing entries and write to console
		Query q = em.createQuery("select i from Item4 i where i.id = "	+ item.getId());
		List<Item4> items = q.getResultList();
		for (Item4 currentItem : items) {
			System.out.println(currentItem.getId() + " width = " + currentItem.getSize().getWidth());
		}
	       
	    em.close();
	    
	}

}
