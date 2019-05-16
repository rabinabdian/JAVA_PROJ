package example02AutowireEntityManager;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringApplication {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(example02AutowireEntityManager.PersistenceJPAConfig.class); 
		MyDao myDAO = (MyDao) ctx.getBean(MyDao.class);
		myDAO.doJPAStuff();
		ctx.close();
	}

}
