package org.denny.spring.aop;

public class CalculatorLoggingImpl implements Calculator {

	@Override
	public int add(int i, int j) {
		System.out.println("add start ...");
		int result = i + j ;
		System.out.println("add end ...");
		return result;
	}

	@Override
	public int sub(int i, int j) {
		System.out.println("sub start ...");
		int result = i - j ;
		System.out.println("sub end ...");
		return result;
	}

	@Override
	public int mul(int i, int j) {
		System.out.println("mul start ...");
		int result = i * j ;
		System.out.println("mul end ...");
		return result;
	}

	@Override
	public int div(int i, int j) {
		System.out.println("div start ...");
		int result = i / j ;
		System.out.println("div end ...");
		return result;
	}

}
