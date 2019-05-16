package trainologic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity	// marking the class as being MAPPED
@Table(name="CompanyTable")
public class Company {
	private String name;
	//@Column(nullable = true)
	//@Basic(optional = false)
	//@Column(length = 100, nullable = false)
	private String symbol;
	@Id
	@Column(name="CUSTOMER_ID")
	private int id;

	public Company() {
		// required constructor for JPA
	}
	public Company(String name, String symbol) {
		this.name = name;
		this.symbol = symbol;
	}

	@Id  	 // marking the primary key
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CUSTOMER_SEQ")
	public int getId() {return id;}
	public void setId(int id) {this.id = id;	}
	//@Transient
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	 
	public String getSymbol() {return symbol;}
	public void setSymbol(String symbol) {this.symbol = 
					symbol;}
}
