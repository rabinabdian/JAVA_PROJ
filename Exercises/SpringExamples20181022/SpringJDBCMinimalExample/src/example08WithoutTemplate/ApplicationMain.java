package example08WithoutTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.object.MappingSqlQuery;

import hello.Customer;

class CustomerQuery extends MappingSqlQuery<Customer>
{

	CustomerQuery(DataSource dataSource)
	{
		super(dataSource, "select * from customers");
	}
	@Override
	protected Customer mapRow(ResultSet rs, int arg1) throws SQLException {
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
		
		// Example of SimpleJDBCInsert
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(driverManagerDataSource);
		simpleJdbcInsert.withTableName("customers");
		Map<String,Object> values = new HashMap<>();
		values.put("first_name", "Woody");
		values.put("last_name", "Allen");
		simpleJdbcInsert.execute(values);
		
		// Example of MappingSQLQuery
		CustomerQuery customerQuery = new CustomerQuery(driverManagerDataSource);
		List<Customer> results = customerQuery.execute();
		System.out.println(results.get(0));
		System.out.println(results.get(1));
		


	}
}
