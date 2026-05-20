package com.example.autowire.base;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppContext
{
	public static void main(String[] args)
	{
		org.springframework.context.ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		Employee employee = context.getBean("employeeBean", Employee.class);
		employee.setDepartment("HR");
		System.out.println(employee);
		Manager manager = context.getBean("managerBean", Manager.class);
		System.out.println(manager);
	}
}
