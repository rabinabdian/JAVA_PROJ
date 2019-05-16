package com.repo;


import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.Transactional;



public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(PersistenceJPAConfig.class);
		PersonDAO repo=context.getBean(PersonDAO.class);
		repo.deleteAll();
		System.out.println("Addding new person");
		Person p=new Person("Gil",32);
		repo.addPerson(p);
		System.out.println("view all:");
		repo.getAll().forEach(e->System.out.println(e.getName()+" "+e.getAge()));
		System.out.println("view all with age between 37-42:");
		repo.getPersonBetweanAges(37, 42).forEach(e->System.out.println(e.getName()+" "+e.getAge()));
		context.close();
	}
}
