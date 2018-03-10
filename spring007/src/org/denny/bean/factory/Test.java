package org.denny.bean.factory;

import org.springframework.context.support.ClassPathXmlApplicationContext;

@SuppressWarnings("resource")
public class Test {
	
	public static void main(String[] args) {
		factory("static-factory.xml"); // 奥迪
		factory("instance-factory.xml") ; // 福特
		factory("factory-bean.xml") ; // 宝马
	}

	private static void factory(String xmlName) {
		Car car = (Car) new ClassPathXmlApplicationContext(xmlName).getBean("car");
		System.out.println(car);
		System.out.println(car.getClass().getName());
	}
}
