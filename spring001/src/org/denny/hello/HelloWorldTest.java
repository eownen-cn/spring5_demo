package org.denny.hello;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldTest {

	@Test
	public void test1() { // 指定类去获取上下文中已初始化后的bean --1
		@SuppressWarnings("resource")
		HelloWorld obj = new ClassPathXmlApplicationContext("acc-1.xml")
		.getBean(HelloWorld.class);
		obj.setData("world !!!");
		obj.print();
	}

	@Test
	public void test2() { // 指定类去获取上下文中已初始化后的bean --2
		@SuppressWarnings("resource")
		HelloWorld obj = new ClassPathXmlApplicationContext("acc-2.xml")
		.getBean(HelloWorld.class,"helloWorld");
		obj.setData("world !!!");
		obj.print();
	}
	
	@Test
	public void test3() { // 直接以bean的属性name获取上下文中已初始化后的bean
		@SuppressWarnings("resource")
		HelloWorld obj = (HelloWorld) new ClassPathXmlApplicationContext("acc-3.xml")
		.getBean("helloWorld");
		obj.setData("world !!!");
		obj.print();
	}

	@Test
	public void test4() { // 直接以bean的属性id获取上下文中已初始化后的bean
		@SuppressWarnings("resource")
		HelloWorld obj = (HelloWorld) new ClassPathXmlApplicationContext("acc-4.xml")
		.getBean("helloWorld");
		obj.setData("world !!!");
		obj.print();
	}

	@Test
	public void test5() { // 在上下文中，使用bean的子标签property为对象赋初值，而后获取上下文中已初始化后的bean
		@SuppressWarnings("resource")
		HelloWorld obj = (HelloWorld) new ClassPathXmlApplicationContext("acc-5.xml")
		.getBean("helloWorld");
//		obj.setData("world !!!");
		obj.print();
	}

	@Test
	public void test6() { // 在上下文中，使用bean的子标签constructor-ref为对象赋初值，而后获取上下文中已初始化后的bean
		@SuppressWarnings("resource")
		HelloWorld obj = (HelloWorld) new ClassPathXmlApplicationContext("acc-6.xml")
		.getBean("helloWorld");
//		obj.setData("world !!!");
		obj.print();
	}
	
	@Test
	public void test7() { // 在上下文中，使用bean的子标签constructor-ref为对象赋初值，而后获取上下文中已初始化后的bean
		@SuppressWarnings("resource")
		HelloWorld obj = (HelloWorld) new ClassPathXmlApplicationContext("acc-7.xml")
		.getBean("helloWorld") ;
		obj.print();
	}

	@Test
	public void test8() { // 在上下文中，使用bean的子标签constructor-ref为对象赋初值，而后获取上下文中已初始化后的bean
		@SuppressWarnings("resource")
		HelloWorld obj = (HelloWorld) new ClassPathXmlApplicationContext("acc-8.xml")
		.getBean("helloWorld") ;
		obj.print();
	}
	

}
