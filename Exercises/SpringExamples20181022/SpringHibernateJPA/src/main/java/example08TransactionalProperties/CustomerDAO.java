package example08TransactionalProperties;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import javax.transaction.TransactionManager;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.hibernate.resource.transaction.spi.TransactionCoordinator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import hello.Customer;

class CustomerRowMapper implements RowMapper<Customer> {
	public Customer mapRow(ResultSet rs, int arg1) throws SQLException {
		Customer customer =  new Customer(rs.getInt("id"),rs.getString("first_name"),rs.getString("last_name"));
		return customer;
	}

}

@Repository // We will get native exceptions instead of spring exceptions without this bean
public class CustomerDAO {
	
	private JdbcTemplate jdbcTemplate;
	@Autowired
	void setupTemplate(DataSource datasource )
	{
		jdbcTemplate = new JdbcTemplate(datasource);
		jdbcTemplate.execute("DROP TABLE customers");
	    jdbcTemplate.execute("CREATE TABLE customers( id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))");	        
	}
	
	@Autowired
	CustomerDAO2 customerDao2;
	
	@Transactional(value=TxType.REQUIRED)
	public void saveCustomer() {
	    jdbcTemplate.execute("INSERT INTO customers (first_name, last_name) VALUES ('Mark','Wholberg')");

	    customerDao2.saveCustomer2();
	}

	
	@Transactional
	public void findCustomer() {
		System.out.println("Printing all customers ");
	    List<Customer> customers = jdbcTemplate.query("SELECT id, first_name, last_name FROM customers",new CustomerRowMapper());
	    for( Customer customer : customers )
	     System.out.println(customer.toString());
	}


}
