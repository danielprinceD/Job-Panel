package com.example.componentscan;

import org.springframework.stereotype.Component;

@Component("employeeBean")
public class EmployeeBean
{
	private String name;
	private String department;
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getDepartment()
	{
		return department;
	}
	public void setDepartment(String department)
	{
		this.department = department;
	}
	@Override
	public String toString()
	{
		return "EmployeeBean [name=" + name + ", department=" + department + "]";
	}
}
