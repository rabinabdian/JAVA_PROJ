package trainologic;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ItemTable")
public class Item {
private String name;
@Id
private int id;
private Size size;

public Item() {}
public Item(String name) {this.name = name;}

public int getId() {return id;}
public void setId(int id) {this.id = id;}
@Embedded
public Size getSize() {return size;}
public void setSize(Size size) {this.size = size;}
public String getName() {return name;}
public void setName(String name) {this.name = name;}
}
