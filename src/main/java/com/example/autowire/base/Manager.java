package com.example.autowire.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("managerBean")
public class Manager
{
	@Autowired
	private Employee employee;

//	@Autowired
//	public Manager(Employee employee)
//	{
//		this.employee = employee;
//	}

	public Employee getEmployee()
	{
		return employee;
	}
	public void setEmployee(Employee employee)
	{
		this.employee = employee;
	}
	@Override
	public String toString()
	{
		return "Manager [employee=" + employee + "]";
	}
}
