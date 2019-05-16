	package trainologic;

import javax.persistence.Entity;

	@Entity
	public class VIPCustomer extends Customer {
	   private int discount;

	   public int getDiscount() {
		return discount;
	   } 

	   public void setDiscount(int discount) {
		this.discount = discount;
	   }
	}
