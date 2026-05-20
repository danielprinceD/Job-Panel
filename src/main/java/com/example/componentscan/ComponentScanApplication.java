package com.example.componentscan;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ComponentScanApplication
{
	public static void main(String[] args)
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("ComponentScan.xml");
		EmployeeBean employeeBean = context.getBean( "employeeBean", EmployeeBean.class );
		System.out.println(employeeBean);
	}
}
