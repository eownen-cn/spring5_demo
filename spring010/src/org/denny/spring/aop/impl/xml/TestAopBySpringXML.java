package org.denny.spring.aop.impl.xml;

import java.io.File;
import java.io.FileOutputStream;
import java.rmi.server.LogStream;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAopBySpringXML {
	public static void main(String[] args) {
		
		// 1. 创建IOC容器
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-aop-xml.xml") ;
		
		// 2. 获取bean实例
		Calculator bean = (Calculator) ctx.getBean("calculatorImpl");
		
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
		} catch (Throwable e) {
			e.printStackTrace() ;
		}
		
	}
}
