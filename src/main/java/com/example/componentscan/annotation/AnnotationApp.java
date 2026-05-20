package com.example.componentscan.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.componentscan.EmployeeBean;

public class AnnotationApp
{
	public static void main(String[] args)
	{
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		EmployeeBean employeeBean = context.getBean("employeeBean", EmployeeBean.class);
		System.out.println("Annotation based configuration : " + employeeBean);
	}
}
