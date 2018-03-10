package org.denny.spring.aop.impl.xml;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;

public class ValidateAspect{
	
	public void validate(JoinPoint signature) {
		String methodName = signature.getSignature().getName() ;
		List<Object> args = Arrays.asList(signature.getArgs());
		System.out.println("【验】Validating the method " + methodName + "( " + args + " ) ...");
	}
}
