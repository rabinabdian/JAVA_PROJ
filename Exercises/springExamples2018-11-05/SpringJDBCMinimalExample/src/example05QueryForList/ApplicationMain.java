package example05QueryForList;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
	        jdbcTemplate.execute("CREATE TABLE customers(" +
	                "id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))");

	    jdbcTemplate.execute("INSERT INTO customers (first_name, last_name) VALUES ('Mark','Wholberg')");

	    List<Map<String, Object>> results = jdbcTemplate.queryForList("SELECT id, first_name, last_name FROM customers WHERE first_name = 'Mark'");
	    for( Map resultMap : results)
	    {
	    	System.out.println("ID: " + resultMap.get("id"));
	    	System.out.println("Name: " + resultMap.get("first_name"));
	    }
	        
	}
}
