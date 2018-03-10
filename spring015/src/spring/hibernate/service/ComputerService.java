package spring.hibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.hibernate.dao.ComputerDao;
import spring.hibernate.entity.Computer;

@Service
public class ComputerService {
	
	@Autowired
	private ComputerDao computerDao ;
	
	public void addComputer(Computer com) {
		computerDao.add(com);
	}
	
	public Computer getComputer(String comid) {
		return this.computerDao.getById(comid) ;
	}
	
}
