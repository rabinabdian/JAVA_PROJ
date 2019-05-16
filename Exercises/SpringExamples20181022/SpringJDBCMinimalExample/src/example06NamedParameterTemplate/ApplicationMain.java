package example06NamedParameterTemplate;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import hello.Customer;


public class ApplicationMain {



	public static void main(String[] args) {
	
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/people");
		driverManagerDataSource.setUsername("root");
		driverManagerDataSource.setPassword("MyNewPass");
		driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");

		

		// DEMO DDL with NamedTemplate
	    NamedParameterJdbcTemplate namedTemplate = new NamedParameterJdbcTemplate(driverManagerDataSource);
	    namedTemplate.execute("DROP TABLE customers", e-> e.execute() );
	    namedTemplate.execute("CREATE TABLE customers( id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))", e-> e.execute() );
	    
	    // Demo Batching from Object List with NamedTemplate and named parameters
	    List<Customer> customers = Arrays.asList(new Customer(1,"John","Ham"), new Customer(2,"Albert","Einstein"));
	    SqlParameterSource[] customerBatch = SqlParameterSourceUtils.createBatch(customers);
	    		namedTemplate.batchUpdate("INSERT INTO customers (first_name, last_name) VALUES (:firstName,:lastName)", customerBatch);

	    // Demo Named Parameters		
	    HashMap<String, Object> params = new HashMap<>();
	    params.put("first_name", "John");
	    List<Map<String, Object>> results = namedTemplate.queryForList("SELECT id, first_name, last_name FROM customers WHERE first_name = :first_name",params);
	    for( Map resultMap : results)
	    {
	    	System.out.println("ID: " + resultMap.get("id"));
	    	System.out.println("Name: " + resultMap.get("first_name") + " " + resultMap.get("last_name"));
	    }
	        
	}
}
