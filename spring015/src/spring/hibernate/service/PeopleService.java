package spring.hibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.hibernate.dao.PeopleDao;
import spring.hibernate.entity.People;

@Service
public class PeopleService {
	
	@Autowired
	private PeopleDao peopleDao ;
	
	public void addPeople(People peo) {
		this.peopleDao.add(peo);
	}
	
	public People getPeople(String peoid) {
		return this.peopleDao.getById(peoid) ;
	}
	
	public void save() {
		System.out.println("PeopleService's save...");
	}
	
}
