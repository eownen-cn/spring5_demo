package org.denny.spring.tx.dao;

import javax.security.auth.login.AccountException;

import org.denny.spring.tx.exception.BookStockException;

public interface BookShopDao {
	
	/**
	 * 库存查询
	 * 根据图书的编号，查询其库存
	 * @param bookId
	 * @return
	 */
	public Integer findBookStock(String bookId) ;
	
	/**
	 * 书价查询
	 * 根据书号获取书的单价
	 * @param bookId 书号
	 * @return 书的单价
	 */
	public Double findBookPriceByBookId(String bookId) ;
	
	/**
	 * 余额查询
	 * 根据用户名查找用户余额
	 * @param username
	 * @return
	 */
	public Double findBalanceByUsername(String username) ;
	
	/**
	 * 库存更新
	 * 根据书的编号，使库存减一
	 * @param bookId
	 * @throws Exception 
	 */
	public void updateBookStock(String bookId) throws BookStockException ;
	
	/**
	 * 余额更新
	 * 更新用户的账户余额：使username的balance减去书的price
	 * @param username
	 * @param price
	 * @throws AccountException 
	 */
	public void updateUserAccount(String username,double price) throws AccountException ;
	
}
