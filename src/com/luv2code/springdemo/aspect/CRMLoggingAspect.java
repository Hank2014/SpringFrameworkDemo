package com.luv2code.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class CRMLoggingAspect {
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	@Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}
	
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("=====>> in @Before: Calling method" + theMethod);
		
		Object [] args = theJoinPoint.getArgs();
		
		for(Object o:args) {
			myLogger.info("=====>> argument =" + o);	
		}
		
	}
	
	@AfterReturning(
			pointcut = "forAppFlow()",
			returning = "theResult123")
	public void afterReturning(JoinPoint theJoinPoint, Object theResult123) {
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("=====>> in @AfterReturning: Calling method" + theMethod);
		
		myLogger.info("=====>> result: " + theResult123);
	}
	
}
