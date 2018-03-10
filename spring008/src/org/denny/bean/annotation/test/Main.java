package org.denny.bean.annotation.test;

import org.denny.bean.annotation.TestObject;
import org.denny.bean.annotation.controller.UserController;
import org.denny.bean.annotation.repository.UserRepository;
import org.denny.bean.annotation.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-annotation.xml");
		
		try {
			UserController userController = (UserController) ctx.getBean("userController");
			System.out.println(userController);
			TestObject testObject = (TestObject) ctx.getBean("testObject");
			System.out.println(testObject);
			UserRepository userRepository = (UserRepository) ctx.getBean("userRepository");
			System.out.println(userRepository);
			UserService userService = (UserService) ctx.getBean("userService");
			System.out.println(userService);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
