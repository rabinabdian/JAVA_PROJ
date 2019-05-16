package example05EmbeddedPrimaryKey;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class SerialNumber5 implements Serializable{
static final long serialVersionUID = 2L;
private int prefix;
private int index;


@Override
public int hashCode() {
	return getPrefix()*31+getIndex(); // not sure its the best hash function
}

@Override
public boolean equals(Object obj) {
	if( obj != null && obj.getClass() == this.getClass() )
	{
		SerialNumber5 rhs = (SerialNumber5) obj;
		if ( getPrefix() == rhs.getPrefix() && getIndex() == rhs.getIndex() )
			return true;
	}
	return false;
}

public int getPrefix() {
	return prefix;
}

public void setPrefix(int prefix) {
	this.prefix = prefix;
}

public int getIndex() {
	return index;
}

public void setIndex(int index) {
	this.index = index;
}
}