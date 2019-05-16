package example07StatementCallback;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.StatementCallback;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import hello.Customer;

class SaveCustomerCallback implements StatementCallback<Integer>
{
	int id;	String name; String lastName;
	public SaveCustomerCallback(int id, String name, String lastName) {		this.id = id;		this.name = name;		this.lastName = lastName;	}

	
	@Override
	public Integer doInStatement(Statement statement) throws SQLException, DataAccessException {
	    String  sql  = "insert  into customers(id,   first_name,   last_name)    values  ('"+id+"','"+name+"','"+lastName+"')";
	    return statement.executeUpdate(sql);

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


	    jdbcTemplate.execute(new SaveCustomerCallback(1,"Woopy","Goldberg"));
	    
        jdbcTemplate.query(
                "SELECT id, first_name, last_name FROM customers WHERE first_name = 'Woopy'",
                (rs, rowNum) -> new Customer(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"))
        ).forEach(customer -> System.out.println((customer.toString())));
 

	}
}
