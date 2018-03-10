package org.denny.spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class LoggingProxy {
	// 声明要需要代理的对象作为成员变量
	private Calculator target ;
	
	public LoggingProxy(Calculator target) {
		this.target = target;
	}

	public Calculator getLoggingProxy() {
		
		Calculator proxy = null ;
		ClassLoader loader = target.getClass().getClassLoader() ; // 得到类的加载器
		Class<?>[] interfaces = target.getClass().getInterfaces() ; // 得到方法
		InvocationHandler hand = new InvocationHandler() { // 调用方法的调用处理器
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("invoke before ...");
				int result = (int) method.invoke(target, args) ;
				System.out.println("invoke result ==> " + result);
				System.out.println("invoke after ...");
				return result;
			}
		};
		proxy = (Calculator) Proxy.newProxyInstance(loader, interfaces, hand) ;
		return proxy ;
	}
}
