package example02BatchUpdate.copy;

import java.util.Arrays;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import hello.Customer;

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

        jdbcTemplate.batchUpdate("INSERT INTO customers(first_name, last_name) VALUES (?,?)", Arrays.asList(new Object[]{"John","Woo"},new Object[]{"Jeff","Dean"}));
	        
	}
}
