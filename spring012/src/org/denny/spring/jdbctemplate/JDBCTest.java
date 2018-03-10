package org.denny.spring.jdbctemplate;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

class JDBCTest implements FT{
	
	
	private ClassPathXmlApplicationContext ctx = null ; // 声明springIOC容器
	private JdbcTemplate jtemplate = null ; // 声明JDBC模板类
	private NamedParameterJdbcTemplate namedQuery = null ; // 声明命名参数模板类
	
	/**
	 * 构造快中初始化spring容器以及JdbcTemplate模板、命名查询模板
	 */
	{
		this.ctx = new ClassPathXmlApplicationContext("applicationContext.xml") ;
		this.jtemplate = this.ctx.getBean(JdbcTemplate.class) ;
		this.namedQuery = this.ctx.getBean(NamedParameterJdbcTemplate.class) ;
	}
	
	/**
	 * 关闭spring IOC 容器上下文
	 */
	@After
	public void testAfter() {
		this.ctx.close();
	}
	
	/**
	 * 测试数据库连接
	 * @throws SQLException
	 */
	@Test
	public void testDataSource() throws SQLException { 
		
		DataSource ds = (DataSource) ctx.getBean("dataSource") ;                                                       
		System.out.println("Catalog : " + ds.getConnection().getCatalog()) ;
		
	}

	/**
	 * 测试插入
	 */
	@Test
	public void testInsert() {
		String sql = "insert into employee(email,deptno) values (?,?)" ;
		Integer setRow = this.jtemplate.update(sql,"eownen@gmail.com",7839) ;
		System.out.println("受影响的行数：" + setRow) ;
	}
	
	/**
	 * 测试批量插入
	 */
	@Test
	public void testBatchInsert() {
		String sql = "insert into employee(empno,email,deptno) values (?,?,?)" ;
		List<Object[]> listObj = new ArrayList<>() ;
		listObj.add(new Object[] {1,"hello@gmail.com",7906});
		listObj.add(new Object[] {2,"world@gmail.com",7507});
		listObj.add(new Object[] {3,"say@gmail.com",7238});
		listObj.add(new Object[] {4,"goodbye@gmail.com",7396});
		int[] setRow = this.jtemplate.batchUpdate(sql, listObj) ;
		System.out.println("受影响的行数：" + this.sum(setRow)) ;
	}
	
	/**
	 * 测试删除
	 */
	@Test
	public void testDelete() {
		String sql = "delete from employee where deptno = ?" ;
		int setRow = this.jtemplate.update(sql,7906) ;
		System.out.println("受影响的行数：" + setRow);
	}
	
	/**
	 * 测试批量删除
	 */
	@Test
	public void testBatchDelete() {
		String sql = "delete from employee where deptno in (?,?,?,?)" ;
		int setRow = this.jtemplate.update(sql,7906,7507,7238,7396) ;
		System.out.println("受影响的行数：" + setRow);
	}
	
	/**
	 * 测试更新
	 */
	@Test
	public void testUpdate() {
		String sql = "update employee set email=? where deptno=?" ;
		int setRow = this.jtemplate.update(sql,"whathell@hell.com",7396) ;
		System.out.println("受影响的行数：" + setRow);
	}
	
	/**
	 * 测试批量更新
	 */
	@Test
	public void testBatchUpdate() {
		String sql = "update employee set email=? where deptno=?" ;
		List<Object[]> listObj = new ArrayList<>() ;
		listObj.add(new Object[] {"AA@hell.com",7906}) ;
		listObj.add(new Object[] {"BB@hell.com",7507}) ;
		listObj.add(new Object[] {"CC@hell.com",7238}) ;
		listObj.add(new Object[] {"DD@hell.com",7396}) ;
		int[] setRow = this.jtemplate.batchUpdate(sql,listObj) ;
		System.out.println("受影响的行数：" + this.sum(setRow)) ;
	}
	
	/**
	 * 测试查询单个
	 * 1.RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class) ;
	 * 2.注意：如果数据库字段与对应类的类成员变量不同，在查询的时候可以使用别名来将查询出的数据映射到类中成员变量上
	 * 3.JdbcTemplate 在检索数据时，不支持级联属性操作
	 */
	@Test
	public void testQueryForObject() {
		String sql = "select empno,email,deptno from employee where empno=?" ;
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class) ;
		Employee emp = this.jtemplate.queryForObject(sql,rowMapper,3) ;
		System.out.println(emp);
	}

	/**
	 * 测试批量查询
	 */
	@Test
	public void testBatchQueryForObject() {
		String sql = "select empno,email,deptno from employee where empno > ?" ; // 查询empno大于2的所有数据
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class) ;
		List<Employee> empList = this.jtemplate.query(sql,rowMapper,0) ;
		for( Employee emp : empList ) {
			System.out.println(emp);
		}
	}

	/**
	 * 测试命名参数的使用
	 * 自定义命名参数
	 * this.namedQuery.update(sql, paramMap) ;
	 */
	@Test
	public void testNamedParameter() {
		String sql = "insert into employee(empno,email,deptno) values(:e1,:e2,:e3)" ;
		Map<String,Object> paramMap = new HashMap<>() ;
		paramMap.put("e1", 5) ;
		paramMap.put("e2", "denny_loong@outlook.com") ;
		paramMap.put("e3", "2018") ;
		int setRow = this.namedQuery.update(sql, paramMap) ;
		System.out.println("受影响的行数：" + setRow);
	}
	
	/**
	 * 测试命名参数的使用
	 * 命名为类成员字段
	 * SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(emp) ;
	 * this.namedQuery.update(sql, parameterSource) ;
	 */
	@Test
	public void testNamedParameter2() {
		String sql = "insert into employee(empno,email,deptno) values(:empno,:email,:deptno)" ;
		Employee emp = new Employee(6,"666@gmail.com","7322") ;
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(emp) ;
		int setRow = this.namedQuery.update(sql, parameterSource) ;
		System.out.println("受影响的行数：" + setRow);
	}
	
	

	@Override
	public int sum(int[] setRow) {
		int rows = 0 ;
		for(int a = 0 ; a < setRow.length; a++) {
			rows += setRow[a] ;
		}
		return rows;
	}


	
}

@FunctionalInterface
interface FT{
	int sum(int[] rowArray);
}
