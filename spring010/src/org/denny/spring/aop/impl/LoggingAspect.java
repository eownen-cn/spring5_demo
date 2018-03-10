package org.denny.spring.aop.impl;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LoggingAspect implements BaseAspect{
	
	/***
	 * 前置通知
	 * 前置通知在方法执行之前调用，可以获得方法的签名
	 * @param point 用于获取方法的签名，可以得到方法的具体信息(方法名称，方法参数，以及方法所在的类)
	 */
	@Before(EXECUTION)
	public void beforeMethod(JoinPoint point) {
		String methodName = point.getSignature().getName() ;
		List<Object> args = Arrays.asList(point.getArgs());
		System.out.println("【前】The method:public int " + methodName + " (" + String.valueOf(args.toString().replaceAll("\\[|\\]","")) + ") is begin ...");
	}
	
	/***
	 * 环绕通知
	 * 1.环绕通知可以获得方法的签名，但不能和前置通知混用，必须二选一
	 * 2.环绕通知的执行过程就类似于一个动态代理的全过程，即进行通知操作的类必须手动返回目标方法的操作结果
	 * @param point 用于获取方法的签名，可以得到方法的具体信息(方法名称，方法参数，以及方法所在的类)
	 * @param ProceedingJoinPoint 用于获取方法的签名，可以得到方法的具体信息(方法名称，方法参数，以及方法所在的类)
	 * ProceedingJoinPoint 类似于，动态代理中的如下方法：
	 * public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
	 * 中的 method 参数 加上 args 参数，方法执行的前后可以随意添加业务逻辑，甚至修改方法执行后的返回值
	 */
	@Around(EXECUTION)
	public Object around(ProceedingJoinPoint method) throws Throwable{
		String methodName = method.getSignature().getName();
		Object[] args = method.getArgs();
		List<Object> listArgs = Arrays.asList(args);
		System.out.println("【环】Around The method:public int " + methodName + " (" + String.valueOf(listArgs.toString().replaceAll("\\[|\\]","")) + ") before ...");
		Object result = method.proceed(args) ;
		System.out.println("【果】Around The method:public int " + methodName + " (" + String.valueOf(listArgs.toString().replaceAll("\\[|\\]","")) + ") result => " + result);
		System.out.println("【环】Around The method:public int " + methodName + " (" + String.valueOf(listArgs.toString().replaceAll("\\[|\\]","")) + ") after ...");
		return result ;
	}
	
	/***
	 * 返回通知，返回通知在方法成功执行后调用，该通知可以获取方法的返回结果
	 * @param point  用于获取方法的签名，可以得到方法的具体信息(方法名称，方法参数，以及方法所在的类)
	 * @param result  获取方法成功执行后的返回结果
	 */
	@AfterReturning(value=EXECUTION,returning="result")
	public void afterReturning(JoinPoint point,Object result) {
		String methodName = point.getSignature().getName() ;
		List<Object> args = Arrays.asList(point.getArgs());
		System.out.println("【返】The method:public int " + methodName + " (" + String.valueOf(args.toString().replaceAll("\\[|\\]","")) + ") is running successfully ... result => " + result);
	}
	
	/***
	 * 后置通知
	 * 后置通知在方法成功执行后调用，因为不确定方法是否会抛异常，所以该通知不支持获取方法的返回结果
	 * @param point
	 */
	@After(value=EXECUTION)
	public void afterMethod(JoinPoint point) {
		String methodName = point.getSignature().getName() ;
		List<Object> args = Arrays.asList(point.getArgs());
		System.out.println("【后】The method:public int " + methodName + " (" + String.valueOf(args.toString().replaceAll("\\[|\\]","")) + ") is end ...");
	}
	
	/***
	 * 异常通知，返回通知在方法执行失败后调用，该通知可以获取方法的返回结果
	 * @param point 用于获取方法的签名，可以得到方法的具体信息(方法名称，方法参数，以及方法所在的类)
	 * @param e 用于方法执行发生异常后，接收捕获到的异常
	 */
	@AfterThrowing(value=EXECUTION,throwing="e")
	public void afterThrowing(JoinPoint point,Throwable e) {
		String methodName = point.getSignature().getName() ;
		List<Object> args = Arrays.asList(point.getArgs());
		System.err.println("【异】The method:public int " + methodName + " (" + String.valueOf(args.toString().replaceAll("\\[|\\]","")) + ") is error ... Cause by: => " + e.getMessage());
	}
}
