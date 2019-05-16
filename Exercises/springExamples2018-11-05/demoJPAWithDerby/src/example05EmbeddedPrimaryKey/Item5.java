package example05EmbeddedPrimaryKey;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Item5 {
private String name;
private SerialNumber5 serialNumber;

public Item5() {}
public Item5(String name) {this.name = name;}

@EmbeddedId 
public SerialNumber5 getSerialNumber() {return serialNumber;}
public void setSerialNumber(SerialNumber5 serial) {this.serialNumber = serial;}
public String getName() {return name;}
public void setName(String name) {this.name = name;}
}