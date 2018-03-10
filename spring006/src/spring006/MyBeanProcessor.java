package spring006;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanProcessor implements BeanPostProcessor {

	public MyBeanProcessor() {
		System.out.println("Constructor ==> " + this.getClass().getName() + "...");
	}
	
	/**
	 * bean的前置处理器
	 */
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println("Bean initial before : beanName => " + beanName + " , bean => " + bean);
		return bean;
	}
	
	/**
	 * bean的后置处理器
	 */
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println("Bean initial after : beanName => " + beanName + " , bean => " + bean);
		return bean;
	}
}
