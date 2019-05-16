package trainologic;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ExampleTraceJDBC {
public static void main(String[] args) throws Exception {
	
    Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
    Connection con = DriverManager.getConnection(
    		"jdbc:derby:/home/trainologic/jpaDemo;create=true;traceFile=trace.out","test","test");
    	PrintWriter printWriter = new PrintWriter(System.out, true);
		DriverManager.setLogWriter(printWriter);
    	Statement statement = con.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from Client c");
		 DriverManager.getLogWriter().append('x');
		 while(resultSet.next())
            {
                System.out.println("id = " + resultSet.getObject(1) + "name = " + resultSet.getObject(2));
            }
	 resultSet.close();
	 statement.close();
	 printWriter.flush();
}
}
