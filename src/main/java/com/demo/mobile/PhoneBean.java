package com.demo.mobile;

import com.annotation.Injector;

public class PhoneBean
{
	private String name;
	private Specification specification;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public PhoneBean( Specification specification){
		this.specification = specification;
	}

	@Override public String toString()
	{
		return "Phone{name='" + name + "', specification=" + specification + "}";
	}
}
