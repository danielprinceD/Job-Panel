package com.example.designpattern.behavioral;

import java.util.Map;

abstract class AbstractHandler  {
	private AbstractHandler nextHandler;

	public AbstractHandler setNextHandler(AbstractHandler handler) {
		this.nextHandler = handler;
		return handler;
	}

	public abstract boolean handleRequest(Map<String , String> request);

	protected boolean handleNextRequest(Map<String , String> request) {
		if (nextHandler != null) {
			return nextHandler.handleRequest(request);
		}
		return true;
	}
}

class UserNameValidation extends AbstractHandler {
	@Override public boolean handleRequest(Map<String , String> request)
	{
		if (request.containsKey("user_name")) {
			System.out.println("Username Validator");
			return handleNextRequest(request);
		}
		return false;
	}
}

class PasswordValidation extends AbstractHandler {
	@Override public boolean handleRequest(Map<String , String> request)
	{
		if (request.containsKey("password")) {
			System.out.println("Password Validator");
			return handleNextRequest(request);
		}
		return false;
	}
}

class RoleValidation extends AbstractHandler {
	@Override public boolean handleRequest(Map<String , String> request)
	{
		if (request.containsKey("role")) {
			System.out.println("Role Validator");
			return handleNextRequest(request);
		}
		return false;
	}
}


public class ChainOfResponsibility
{
	public static void main(String[] args)
	{
		Map<String , String> request = Map.of("user_name" , "john_doe" , "password" , "123456" , "role" , "admin");
		AbstractHandler validationChain = new UserNameValidation();
		validationChain.setNextHandler(new PasswordValidation()).setNextHandler(new RoleValidation());
		validationChain.handleRequest(request);

	}
}
