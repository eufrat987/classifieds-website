package org.example.aspect;

import org.springframework.stereotype.Component;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@Aspect
@Component
public class LoggingAspect {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Before("execution(* org.example.service..*(..))")
	public void logEntry(JoinPoint joinPoint) {
		logger.info("Entered method: {}", joinPoint.getSignature());
	}

}
