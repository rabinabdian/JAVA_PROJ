package trainologic;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class CompositeServicePK2 implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String id1;
private String id2;


@Override
public int hashCode() {
	return id1.hashCode() + id2.hashCode();
}

@Override
public boolean equals(Object obj) {
	if( obj != null && obj.getClass() == this.getClass() )
	{
		CompositeServicePK2 rhs = (CompositeServicePK2) obj;
		if ( getId1().equals(rhs.getId1()) && getId2().equals(rhs.getId2() ))
			return true;
	}
	return false;
}
public String getId1() {return id1;}
public void setId1(String id1) {this.id1 = id1;}
public String getId2() {return id2;}
public void setId2(String id2) {this.id2 = id2;}
}
