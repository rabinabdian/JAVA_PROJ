package example04TemplateXMLConfig;

import java.util.Arrays;

import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


import hello.Customer;

public class ApplicationMain {



	public static void main(String[] args) {

	    FileSystemXmlApplicationContext appContext = new FileSystemXmlApplicationContext("SpringContext.xml");

        CustomerDao customerDao = (CustomerDao) appContext.getBean("myDAO");
        
        customerDao.clearDatabase();
        
        customerDao.savePerson(new Customer(1,"John","Doe"));
        
        Customer customer = customerDao.getPerson("John");
        System.out.println( customer.toString());

	        
	}
}
