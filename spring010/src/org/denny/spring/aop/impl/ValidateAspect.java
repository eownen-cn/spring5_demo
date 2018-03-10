package org.denny.spring.aop.impl;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class ValidateAspect implements BaseAspect{
	
	@Before(EXECUTION)
	public void validate(JoinPoint signature) {
		String methodName = signature.getSignature().getName() ;
		List<Object> args = Arrays.asList(signature.getArgs());
		System.out.println("【验】Validating the method " + methodName + "( " + args + " ) ...");
	}
}
