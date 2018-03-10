package org.denny.hello;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldTest {
	@Test
	public void test1() {
		@SuppressWarnings("resource")
		HelloWorldImplOther obj = (HelloWorldImplOther) new ClassPathXmlApplicationContext("acc-1.xml").getBean("helloOther") ;
		System.out.println(obj);
	}
}
