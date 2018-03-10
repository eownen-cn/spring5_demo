package spring.hibernate.dao;

import java.util.List;

import spring.hibernate.entity.People;

public interface PeopleDao {
	
	public void add(People peo) ;
	
	public People getById(String peoid) ;
	
	public List<People> getPeoples() ;
	
}
