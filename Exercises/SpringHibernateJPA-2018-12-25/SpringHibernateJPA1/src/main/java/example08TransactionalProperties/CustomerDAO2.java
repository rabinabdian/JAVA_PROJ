package example08TransactionalProperties;

import javax.sql.DataSource;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.interceptor.TransactionAspectSupport;


@Repository // We will get native exceptions instead of spring exceptions without this bean
public class CustomerDAO2 {
	
	private JdbcTemplate jdbcTemplate;
	@Autowired
	void setupTemplate(DataSource datasource )
	{
		jdbcTemplate = new JdbcTemplate(datasource);
	}
	

	@Transactional(value=TxType.REQUIRES_NEW)
	//@Transactional(value=TxType.REQUIRED)
	public void saveCustomer2() {
	    jdbcTemplate.execute("INSERT INTO customers (first_name, last_name) VALUES ('John','Ham')");
	    //throw new RuntimeException("Exception after insert in saveCustomer2");
	    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		
	}

}
