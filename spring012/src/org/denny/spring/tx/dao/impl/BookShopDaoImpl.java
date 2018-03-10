package org.denny.spring.tx.dao.impl;

import org.denny.spring.tx.dao.BookShopDao;
import org.denny.spring.tx.exception.BookStockException;
import org.denny.spring.tx.exception.AccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("bookShopDao")
public class BookShopDaoImpl implements BookShopDao{

	private JdbcTemplate jtemplate ;
	
	@Autowired
	public void setJtemplate(JdbcTemplate jtemplate) {
		this.jtemplate = jtemplate;
	}
	
	/**
	 * 查询给定书的价格
	 */
	public Double findBookPriceByBookId(String bookId) {
		String sql = "select bookPrice from book where bookId = ?" ;
		Double price = this.jtemplate.queryForObject(sql, Double.class,bookId) ;
		return price;
	}
	
	/**
	 * 库存更新
	 * @throws Exception 
	 */
	public void updateBookStock(String bookId) throws BookStockException {
		// 0. 库存检测
		if ( this.findBookStock(bookId) < 1 ) { // 如果一本都没了，那么抛出异常
			throw new BookStockException("No more stock.") ;
		}
		String sql = "update bookStock set bookStock = bookStock - 1 where bookId = ?" ;
		this.jtemplate.update(sql, bookId) ;
	}

	/**
	 * 余额更新
	 * @throws AccountException 
	 */
	public void updateUserAccount(String username, double price) throws AccountException {
		// 0. 余额检测
		if ( this.findBalanceByUsername(username) < price ) { // 余额不足
			throw new AccountException("No more balance.") ;
		}
		String sql = "update account set balance = balance - ? where username = ?" ;
		this.jtemplate.update(sql,price,username) ;
	}

	/**
	 * 余额查询
	 */
	public Double findBalanceByUsername(String username) {
		String sql = "select balance from account where username = ?" ;
		return this.jtemplate.queryForObject(sql, Double.class, username);
	}

	/**
	 * 库存查询
	 */
	public Integer findBookStock(String bookId) {
		String sql = "select bookStock from bookstock where bookId = ?" ;
		return this.jtemplate.queryForObject(sql, Integer.class,bookId) ;
	}
	
}
