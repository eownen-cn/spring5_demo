package org.denny.spring.tx.test;

import java.util.Arrays;

import javax.security.auth.login.AccountException;

import org.denny.spring.tx.dao.BookShopDao;
import org.denny.spring.tx.service.BookShopService;
import org.denny.spring.tx.service.CashierService;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestTransactionMananger {
	
	private ClassPathXmlApplicationContext ctx = null ;
	private BookShopDao dao = null ;
	private BookShopService service = null ;
	private CashierService cashierService = null ;
	
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml") ;
		dao = ctx.getBean(BookShopDao.class) ;
		service = ctx.getBean(BookShopService.class) ;
		cashierService = ctx.getBean(CashierService.class) ;
	}
	
	/**
	 * 测试事务的传播属性
	 * @throws Exception
	 */
	@Test
	public void testTransactionPropagation() throws Exception {
		this.cashierService.chekout("AA", Arrays.asList("1001","1002"));
	}
	
	/**
	 * 测试事务的一致性
	 * @throws Exception
	 */
	@Test
	public void testPurchase() throws Exception {
		this.service.purchase("AA", "1001");
	}
	
	/**
	 * 根据书的价格更新用户的余额
	 */
	@Test
	public void testUpdateAccount() {
		try {
			this.dao.updateUserAccount("AA", 78.8 );
		} catch (AccountException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 测试根据书的ID更新库存
	 */
	@Test
	public void testUpdateBookStock() {
		try {
			this.dao.updateBookStock("1001");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 测试根据书的ID查询书的价格
	 */
	@Test
	public void testFindBookPriceByBookId() {
		Double price = this.dao.findBookPriceByBookId("1001") ;
		System.out.println("1001的价格是:" + price);
	}

	/**
	 * 测试查询余额
	 */
	@Test
	public void testFindAcountBalance() {
		System.out.println(this.dao.findBalanceByUsername("AA"));
	}
}
