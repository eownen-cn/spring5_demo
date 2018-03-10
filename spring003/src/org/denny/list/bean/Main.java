package org.denny.list.bean;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	@Test
	public void testListForUtilTag() {
		@SuppressWarnings("resource")
		People p = (People) new ClassPathXmlApplicationContext("list.xml").getBean("people") ;
		System.out.println(p);
	}
}
