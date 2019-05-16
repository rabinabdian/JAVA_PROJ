package example00JDBCNoSpring;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ApplicationMain {



	public static void main(String[] args) {
	
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/people", "root","MyNewPass");
			java.sql.PreparedStatement statement = connection.prepareStatement("DROP TABLE customers");
			statement.executeUpdate();
			statement.executeUpdate("CREATE TABLE customers(id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))");
			
			statement.execute("INSERT INTO customers (first_name, last_name) VALUES ('Mark','Wholberg')");
			
			statement = connection.prepareStatement("SELECT id, first_name, last_name FROM customers WHERE first_name = ?");
			statement.setString(1, "Mark");
		
			ResultSet rs = statement.executeQuery();
		    while (rs.next())  {
			 System.out.println(rs.getString("last_name"));
		    }
		    connection.close();

		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	        
	}
}
