package example10SpringExceptions;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import javax.sql.DataSource;
import javax.sql.rowset.RowSetWarning;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.object.MappingSqlQuery;

import hello.Customer;


public class ApplicationMain {



	public static void main(String[] args) {
	
		try{
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/people");
		driverManagerDataSource.setUsername("root");
		driverManagerDataSource.setPassword("WRONG PASSWORD");
		driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");

		JdbcTemplate jdbcTemplate = new JdbcTemplate(driverManagerDataSource);
		jdbcTemplate.execute("DROP TABLE customers");
		}
		catch(DataAccessException e)
		{
			System.out.println("DataAccessException. Original message = " + e.getMessage());
		}
 

	}
}
