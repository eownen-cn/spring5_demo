package org.denny.spring.aop;

public class TestAopByDynamicProxy {
	public static void main(String[] args) {
		proxy();
		proxy2();
	}

	private static void proxy2() {
		Calculator target = new CalculatorImpl() ;
		Calculator proxy = new LoggingProxy2(target).getLoggingProxy() ;
		int addResult = proxy.add(3,5) ;
		int subResult = proxy.sub(5,3) ;
		System.out.println("addResult ==> " + addResult);
		System.out.println("subResult ==> " + subResult);
		
	}

	private static void proxy() {
		Calculator target = new CalculatorImpl() ;
		Calculator proxy = new LoggingProxy(target).getLoggingProxy() ;
		int addResult = proxy.add(3,5) ;
		int subResult = proxy.sub(5,3) ;
		System.out.println("addResult ==> " + addResult);
		System.out.println("subResult ==> " + subResult);
	}
}
