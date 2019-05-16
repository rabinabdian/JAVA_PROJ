package trainologic;

import javax.persistence.Entity;

@Entity
public class BusinessCustomer extends Customer {
   private String companyName;

   public String getCompanyName() {
	return companyName;
   }

   public void setCompanyName(String companyName) {
	this.companyName = companyName;
   }
}
