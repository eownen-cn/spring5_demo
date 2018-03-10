package spring006;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	@Test
	public void test() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("life-cycle.xml") ; 
		LifeCycle lf = ctx.getBean(LifeCycle.class);
		System.out.println(lf.getData());
		ctx.close();
	}
	
	@Test
	public void test1() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("bean-postprocessor.xml") ; 
		System.out.println(ctx.getBean(LifeCycle.class).getData());
		ctx.close();
	}

}
