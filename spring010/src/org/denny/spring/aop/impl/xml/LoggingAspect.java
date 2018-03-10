package org.denny.spring.aop.impl.xml;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAspect{
	
	public void beforeMethod(JoinPoint point) {
		String methodName = point.getSignature().getName() ;
		List<Object> args = Arrays.asList(point.getArgs());
		System.out.println("【前】The method:public int " + methodName + " (" + String.valueOf(args.toString().replaceAll("\\[|\\]","")) + ") is begin ...");
	}
	
	public void afterReturning(JoinPoint point,Object result) {
		String methodName = point.getSignature().getName() ;
		List<Object> args = Arrays.asList(point.getArgs());
		System.out.println("【返】The method:public int " + methodName + " (" + String.valueOf(args.toString().replaceAll("\\[|\\]","")) + ") is running successfully ... result => " + result);
	}
	
	public void afterMethod(JoinPoint point) {
		String methodName = point.getSignature().getName() ;
		List<Object> args = Arrays.asList(point.getArgs());
		System.out.println("【后】The method:public int " + methodName + " (" + String.valueOf(args.toString().replaceAll("\\[|\\]","")) + ") is end ...");
	}
	
	public void afterThrowing(JoinPoint point,Throwable e) {
		String methodName = point.getSignature().getName() ;
		List<Object> args = Arrays.asList(point.getArgs());
		System.err.print("【异】The method:public int " + methodName + " (" + String.valueOf(args.toString().replaceAll("\\[|\\]","")) + ") occurs exception => ");
	}
	
	public Object aroundMethod(ProceedingJoinPoint proceed) throws Throwable{
		String methodName = proceed.getSignature().getName() ;
		Object result = null ;
		List<Object> args = Arrays.asList(proceed.getArgs()) ;
		String str = "【环】The method:public int " + methodName + " (" + String.valueOf(args.toString().replaceAll("\\[|\\]", "")) + ") " ;
		System.out.println(str + "invoke before ...");
		result = proceed.proceed(proceed.getArgs()) ;
		System.out.println(str + "invoke after ... result => " + result);
		return result ;
	}
	
}
