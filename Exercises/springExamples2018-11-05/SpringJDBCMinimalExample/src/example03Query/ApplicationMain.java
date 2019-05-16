package example03Query;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import hello.Customer;

class CustomerRowMapper implements RowMapper<Customer> {

	@Override
	public Customer mapRow(ResultSet rs, int arg1) throws SQLException {
		Customer customer =  new Customer(rs.getInt("id"),rs.getString("first_name"),rs.getString("last_name"));
		return customer;
	}

}

public class ApplicationMain {

	public static void main(String[] args) {
	
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/people");
		driverManagerDataSource.setUsername("root");
		driverManagerDataSource.setPassword("MyNewPass");
		driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");

		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(driverManagerDataSource);
		jdbcTemplate.execute("DROP TABLE customers");
	    jdbcTemplate.execute("CREATE TABLE customers( id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))");

	    jdbcTemplate.execute("INSERT INTO customers (first_name, last_name) VALUES ('Mark','Wholberg')");

	    List<Customer> customers = jdbcTemplate.query("SELECT id, first_name, last_name FROM customers WHERE first_name = 'Mark'",new CustomerRowMapper());
	    for( Customer customer : customers )
	     System.out.println(customer.toString());
	        
	}
}
