package org.denny.spring.tx.service;

import org.denny.spring.tx.dao.BookShopDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {

	@Autowired
	private BookShopDao bookShopDao ;
	
	@Transactional(propagation=Propagation.REQUIRES_NEW,isolation=Isolation.READ_COMMITTED,readOnly=false)
	public void purchase(String username, String bookId) throws Exception {
		
		//1.更新库存
		bookShopDao.updateBookStock(bookId);
		
		//2.更新余额
		bookShopDao.updateUserAccount(username, bookShopDao.findBookPriceByBookId(bookId));
		
	}

}
