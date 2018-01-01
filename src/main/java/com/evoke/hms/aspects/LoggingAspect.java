package com.evoke.hms.aspects;

import org.aspectj.lang.JoinPoint;

public interface LoggingAspect {
	void logBefore(JoinPoint joinPoint);
	void logAfter(JoinPoint joinPoint);
	void logAround(JoinPoint joinPoint);

}
