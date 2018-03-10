package org.denny.spring.tx.service;

import java.util.List;

public interface CashierService {
	public void chekout(String username,List<String> bookList) throws Exception ;
}
