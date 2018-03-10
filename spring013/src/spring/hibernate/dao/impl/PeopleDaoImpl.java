package spring.hibernate.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.hibernate.dao.PeopleDao;
import spring.hibernate.entity.People;
import spring.hibernate.exception.ComputerException;
import spring.hibernate.exception.PeopleException;

@Repository("peopleDao")
public class PeopleDaoImpl implements PeopleDao{

	@Autowired
	private SessionFactory sessionFactory ;

	private Session getSession() {
		return this.sessionFactory.getCurrentSession() ;
	}
	
	public void add(People peo) {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Double temp = 0.0 ;
		if ((temp = new java.util.Random().nextDouble())>0.99) { // 模拟异常发生，测试事务回滚
			System.err.println("发生错误啦！！！！SS" + temp);
			System.err.println("发生错误啦！！！！SS" + temp);
			System.err.println("发生错误啦！！！！SS" + temp);
			throw new ComputerException("哈哈哈哈哈！" + temp) ;
		}
		this.getSession().save(peo) ;
	}

	public People getById(String peoid) {
		return this.getSession().get(People.class, peoid) ;
	}

	public List<People> getPeoples() {
		return null;
	}
	
}
