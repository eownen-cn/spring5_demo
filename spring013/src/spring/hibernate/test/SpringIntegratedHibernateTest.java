package spring.hibernate.test;


import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.hibernate.entity.Computer;
import spring.hibernate.entity.People;
import spring.hibernate.service.ComputerService;
import spring.hibernate.service.PeopleService;

public class SpringIntegratedHibernateTest {
	
	private ApplicationContext ctx = null ;
	private ComputerService computerService = null ;
	private PeopleService peopleService = null ;
	
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml") ;
		computerService = ctx.getBean(ComputerService.class) ;
		peopleService = ctx.getBean(PeopleService.class) ;
	}
	
	@Test
	public void testJdbc() throws SQLException {
		DataSource ds = ctx.getBean(DataSource.class) ;
		System.out.println("数据库：" + ds.getConnection().getCatalog());
	}
	
	@Test
	public void testAddComputer() {
		Computer com = new Computer("华硕") ;
		this.computerService.addComputer(com);
	}
	
	@Test
	public void testAddPeople() {
		People peo = new People("龙永凌") ;
		this.peopleService.addPeople(peo);
	}
	
	@Test
	public void testAddPeopleAndComputer() {
		for (int a = 0 ; a < 100 ; a ++) {
			Computer com1 = new Computer("华硕" + ++a) ;
			Computer com2 = new Computer("华硕" + a) ;
			Computer com3 = new Computer("华硕" + a) ;
			Set<Computer> setList = new HashSet<>() ;
			setList.addAll(Arrays.asList(com1,com2,com3)) ;
			People peo = new People("龙永凌" + a) ;
			peo.setComList(setList);
			this.peopleService.addPeople(peo);
		}
	}
}
