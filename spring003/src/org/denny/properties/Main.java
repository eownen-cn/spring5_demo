package org.denny.properties;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	@Test
	public void testProperties(){
		@SuppressWarnings("resource")
		DataSource ds = new ClassPathXmlApplicationContext("properties.xml").getBean(DataSource.class);
		System.out.println(ds);
	}
}
