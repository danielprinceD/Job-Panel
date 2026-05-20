package com.example.demo;

import coupling.loosely.DatabaseService.DetailsService;
import coupling.loosely.Provider.EmployeeDataBaseProviderImpl;
import coupling.loosely.Provider.UserDataBaseProviderImpl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.mobile.PhoneBean;
import com.demo.mobile.Specification;
import com.practice.bean.MyBean;

@SpringBootApplication
public class DemoApplication {
	public static final String USER_DETAILS_BEAN = "userDetailBean";
	public static final String EMPLOYEE_DETAILS_BEAN = "employeeDetailBean";
	public static void main(String[] args) {
		ApplicationContext xmlContext = new ClassPathXmlApplicationContext("AppContext.xml");
		MyBean myBean = (MyBean) xmlContext.getBean("myBean");

		Specification specification = xmlContext.getBean("specificationBean", Specification.class);
//		System.out.println(specification);

		PhoneBean phoneBean = xmlContext.getBean("phoneBean", PhoneBean.class);
//		System.out.println(phoneBean);

		// TODO: 1. Without Inversion of Control (IoC)

		DetailsService userDetails = new DetailsService(new UserDataBaseProviderImpl());
		DetailsService employeeDetails = new DetailsService(new EmployeeDataBaseProviderImpl());

		// TODO 2. With Inversion of Control (IoC) using Spring Framework

		DetailsService userDetailsBean = xmlContext.getBean( USER_DETAILS_BEAN , DetailsService.class);
		DetailsService employeeDetailsBean = xmlContext.getBean( EMPLOYEE_DETAILS_BEAN , DetailsService.class);

//		System.out.println(userDetailsBean.fetchDetails());
//		System.out.println(employeeDetailsBean.fetchDetails());

//		System.out.println(myBean);
 		SpringApplication.run(DemoApplication.class, args);

	}

}
