package com.practice.security.signin;

import java.util.Map;

public class LoginResponse
{
	private Map message;
	private String token;

	public Map getMessage()
	{
		return message;
	}

	public void setMessage(Map message)
	{
		this.message = message;
	}

	public String getToken()
	{
		return token;
	}

	public void setToken(String token)
	{
		this.token = token;
	}
}
