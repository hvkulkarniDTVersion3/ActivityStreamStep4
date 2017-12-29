package com.stackroute.activitystream.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class LoggingAspect {
	public LoggingAspect() {
		System.out.println("I m in LoggingAspect constructor");
	}

	Logger log = LoggerFactory.getLogger(this.getClass());

	@Pointcut("within(@com.stackroute.activitystream.controller.UserAuthController)")
	public void controller() {
	}

	@Before("execution(public * authenticateUser(..))")
	public void loggingAdvice() {
		System.out.println("login method called");
	}
	
	@After("execution(public * *(..))")
	public void loggingAdvice2() {
		System.out.println("after methods calling in UserAuthController");
	}
	/* @Before("execution(* UserAuthController+.*(..))")
     public void advice(JoinPoint joinPoint) {
         // advise FooService methods as appropriate
		 System.out.println("+++++I am in LoggingAspect++++++++++++++++++++++++++++");
		 System.out.println(joinPoint.getClass().getTypeName());
     }*/
}