package spring.hibernate.dao;

import java.util.List;

import spring.hibernate.entity.Computer;

public interface ComputerDao {
	
	public void add(Computer com) ;
	
	public Computer getById(String comid) ;
	
	public List<Computer> getComputers() ;
	
}
