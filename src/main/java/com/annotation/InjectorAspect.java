package com.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
public class InjectorAspect
{
	@Around("@annotation(Injector)")
	public Object injectCode(ProceedingJoinPoint joinPoint){
		System.out.println("Hello from the aspect! This code is injected before the method execution.");
		return "Injected code executed before method execution. " + joinPoint.getSignature().getName() + " method is called.";
	}
}
