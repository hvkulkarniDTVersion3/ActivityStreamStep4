package com.stackroute.activitystream.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.stereotype.Component;
import org.apache.log4j.xml.DOMConfigurator;

@Aspect
@Component
public class LoggingAspect {
	// Logger log = LoggerFactory.getLogger(LoggingAspect.class);
	static Logger logger = Logger.getLogger(LoggingAspect.class);

	public LoggingAspect() {
		System.out.println("I m in LoggingAspect constructor");
		// PropertiesConfigurator is used to configure logger from properties file
		// PropertyConfigurator.configure("WEB-INF/resources/log4j.properties");
		// DOMConfigurator is used to configure logger from xml configuration file
		//DOMConfigurator.configure("log4j-config.xml");
		// Log in console in and log file
		logger.info("Log4j appender configuration is successful !!");
	}
/*
	@Pointcut("within(@com.stackroute.activitystream.controller.UserAuthController)")
	public void controller() {
	}*/

	@Before("execution(public * authenticateUser(..))")
	public void loggingAdvice() {
		//System.out.println("login method called");
		logger.debug("..............++++++++++");
	}

	@After("execution(public * authenticateUser(..))")
	public void loggingAdvice2() {
		logger.info("after methods calling in UserAuthController");
	}

	/*
	 * @Before("execution(* UserAuthController+.*(..))") public void
	 * advice(JoinPoint joinPoint) { // advise FooService methods as appropriate
	 * System.out.println("+++++I am in LoggingAspect++++++++++++++++++++++++++++");
	 * System.out.println(joinPoint.getClass().getTypeName());
	 * log.debug("Entering in Method :  " + joinPoint.getSignature().getName());
	 * log.debug("Class Name :  " +
	 * joinPoint.getSignature().getDeclaringTypeName()); }
	 */
}