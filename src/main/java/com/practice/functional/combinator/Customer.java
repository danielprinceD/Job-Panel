package com.practice.functional.combinator;

public class Customer
{
	private String name;
	private String email;
	private String phoneNumber;
	private String city;

	public Customer(String name, String email, String phoneNumber, String city)
	{
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.city = city;
	}

	public String getName()
	{
		return name;
	}

	public String getEmail()
	{
		return email;
	}

	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	public String getCity()
	{
		return city;
	}
}
