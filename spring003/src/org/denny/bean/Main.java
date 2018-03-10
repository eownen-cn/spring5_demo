package org.denny.bean;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	@Test
	public void testAutowire() {
		@SuppressWarnings("resource")
		People p = (People) new ClassPathXmlApplicationContext("autowire.xml").getBean("people") ;
		System.out.println(p);
	}
}
