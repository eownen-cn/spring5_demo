package org.denny.spring.aop.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAopBySpring {
	public static void main(String[] args) {
		
		// 1. 创建IOC容器
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-aop.xml") ;
		
		// 2. 获取bean实例
		Calculator bean = ctx.getBean(Calculator.class);
		
		// 3. 使用bean
		int result = 0 ;
		try {
			result = bean.add(3, 5);
			System.out.println("result ==> " + result);
			result = bean.sub(3, 1);
			System.out.println("result ==> " + result);
			result = bean.mul(3, 5);
			System.out.println("result ==> " + result);
			result = bean.div(3, 0);
			System.out.println("result ==> " + result);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
	}
}
