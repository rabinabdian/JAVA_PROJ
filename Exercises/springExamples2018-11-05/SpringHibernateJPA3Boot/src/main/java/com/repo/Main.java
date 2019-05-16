package com.repo;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		
		SpringApplication.run(Main.class);
	}
	
	@Bean
	public CommandLineRunner demo(PersonRepository repository) {
		return (args) ->  
		{
			Person p=new Person("Gil",32);
			repository.save(p);
			System.out.println("view all:");
			repository.findAll().forEach(e->System.out.println(e.getName()+" "+e.getAge()));

			;
		};
	}
	
}
