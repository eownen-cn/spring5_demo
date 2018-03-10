package org.denny.spring.tx.service;

public interface BookShopService {
	
	/**
	 * @param username // 用户名
	 * @param bookId   // 图书编号
	 * @throws Exception 
	 */
	public void purchase(String username,String bookId) throws Exception ;
}
