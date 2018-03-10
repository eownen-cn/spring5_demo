package org.denny.spring.generic.di.test;

import org.denny.spring.generic.di.child.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 泛型依赖注入
 * @author Ewonen-PC
 *
 */
public class Main {
	@Test
	public void test() {
		new ClassPathXmlApplicationContext("generic-di.xml").getBean(UserService.class).add() ;
	}
}
