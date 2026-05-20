package com.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.aspectj.lang.annotation.Aspect;

@Retention(RetentionPolicy.RUNTIME)
@Target({
	ElementType.METHOD , ElementType.FIELD
})
public @interface Injector
{
	String value() default "";
	String type() default "";
}
