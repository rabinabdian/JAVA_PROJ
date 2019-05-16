package example04TemplateXMLConfig;

import java.sql.Types;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import hello.Customer;

@Repository("personDao")
public class CustomerDao {

	      private org.springframework.jdbc.core.JdbcTemplate  jdbcTemplate;

	      public void setJdbcTemplate(JdbcTemplate jdbcTemplate ){
	            this. jdbcTemplate = jdbcTemplate;
	      }
	      
	      public void clearDatabase()
	      {
	 		 jdbcTemplate.execute("DROP TABLE customers");
		     jdbcTemplate.execute("CREATE TABLE customers(id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))");
	      }
	      
	      public  int savePerson(Customer customer)     { 
	    	    String  sql  = "insert  into customers (id,   first_name,   last_name)    values  (? ,? ,?)";
	    	    Object[]  args  = { customer.getId(),  customer.getFirstName(),  customer.getLastName() };
	    	    int [] types  = { Types.INTEGER, Types.VARCHAR, Types.VARCHAR };
	    	    int  insertCount =  jdbcTemplate.update(sql, args, types);  // typed version supposed to be safer
	    	    return  insertCount;
	    	}
	      
	      public Customer getPerson(String personName)
	      {
		        List<Customer> results = jdbcTemplate.query(
		                "SELECT id, first_name, last_name FROM customers WHERE first_name = ?", new Object[] { personName },
		                (rs, rowNum) -> new Customer(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"))
		        );
		        return results.get(0);

	      }
	      
}