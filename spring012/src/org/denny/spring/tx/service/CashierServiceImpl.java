package org.denny.spring.tx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("cashierService")
public class CashierServiceImpl implements CashierService {

	@Autowired
	private BookShopService bookShopService ;
	
	@Transactional
	public void chekout(String username, List<String> bookList) throws Exception {
		for( String bookId : bookList ) {
			bookShopService.purchase(username, bookId);
		}
	}

}
