package org.denny.conn;

import javax.sql.DataSource;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DataSourceTest {
	public static void main(String[] args) throws Exception{
		@SuppressWarnings("resource")
		DataSource ds = (DataSource) new ClassPathXmlApplicationContext("pool.xml").getBean("dataSource") ;
		System.out.println(ds.getConnection()); 
	}
}
