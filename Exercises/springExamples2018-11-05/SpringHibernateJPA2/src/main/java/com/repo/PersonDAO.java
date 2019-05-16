package com.repo;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDAO {
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private PersonRepository repo;

	public void deleteAll()
	{
		repo.deleteAll();
	}
	public void addPerson(Person p){
		if(p.getAge()>=0&&p.getAge()<=120)
			repo.save(p);
	}
	
	public Iterable<Person> getAll(){
		return repo.findAll();
	}
	
	public Iterable<Person> getPersonBetweanAges(int from,int to){
		return repo.findPersonBetweenAge(from, to);
	}
	
	
	
	
	
}
