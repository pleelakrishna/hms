package com.evoke.hms.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspectImpl implements LoggingAspect{
	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspectImpl.class);

	@Override
	@Before("execution(* com.evoke.hms.dao.impl.VisitDAOImpl.*(..))")
	public void logBefore(JoinPoint joinPoint) {
		LOGGER.info("Started execution of method: {}", joinPoint.getSignature().getName());
		LOGGER.info("Started execution of method with args: {}", joinPoint.getArgs());
	}

	@Override
	@Before("execution(* com.evoke.hms.dao.impl.VisitDAOImpl.*(..))")
	public void logAfter(JoinPoint joinPoint) {
		LOGGER.info("Ended execution of method: {}", joinPoint.getSignature().getName());
	}


	@Override
	@Around("execution(* com.evoke.hms.dao.impl.PatientDAOImpl.*(..))")
	public void logAround(JoinPoint joinPoint) {
		LOGGER.info("Execution of method: {}", joinPoint.getSignature().getName());
	}

}
