package trainologic;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class CompositeService2 {
private String name;

@EmbeddedId 
private CompositeServicePK2 pk;

public CompositeServicePK2 getPk() {
	return pk;
}
public void setPk(CompositeServicePK2 pk) {
	this.pk = pk;
}

public String getName() {return name;}
public void setName(String name) {this.name = name;}
}
