package org.example.aspect;

import org.springframework.stereotype.Component;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@Aspect
@Component
public class LoggingAspect {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Before("execution(* org.example.service..*(..))")
	public void logEntry(JoinPoint joinPoint) {
		logger.debug("Entered method: {} with args: {}", joinPoint.getSignature(), joinPoint.getArgs());
	}

	@AfterReturning("execution(* org.example.service..*(..))")
	public void logEntry(JoinPoint joinPoint, Object result) {
		logger.debug("Exited method: {} with result: {}", joinPoint.getSignature(), result);
	}

	@AfterThrowing("execution(* org.example.service..*(..))")
	public void logEntry(JoinPoint joinPoint, Throwable ex) {
		logger.error("Exception in method: {} with message: {}", joinPoint.getSignature(), ex.getMessage());
	}
}
