package com.example.designpattern.behavioral;

interface Requestor {
	void setMediator(LoginMediator mediator);
	void requestLogin();
}

class LoginRequestor implements Requestor {
	private LoginMediator mediator;

	@Override public void setMediator(LoginMediator mediator)
	{
		this.mediator = mediator;
	}

	@Override  public void requestLogin() {
		mediator.login();
	}
}


interface LoginMediator {
	void login();
}

class PortalLoginMediator implements LoginMediator {
	private String portalName;
	private String username;
	private String password;

	@Override public void login()
	{
		System.out.println("Logging in to " + portalName + " with username: " + username);
	}
	public PortalLoginMediator(String portalName, String username, String password) {
		this.portalName = portalName;
		this.username = username;
		this.password = password;
	}
}

class EmployeeLoginMediator implements LoginMediator
{
	private String employeeId;
	private String password;

	@Override public void login()
	{
		System.out.println("Logging in with Employee ID: " + employeeId);
	}
	public EmployeeLoginMediator(String employeeId, String password) {
		this.employeeId = employeeId;
		this.password = password;
	}
}

public class MediatorDesignPattern
{
	public static void main(String[] args)
	{
		Requestor requestor = new LoginRequestor();
		requestor.setMediator(new PortalLoginMediator("ExamplePortal", "john_doe", "123456"));
		requestor.requestLogin();

		requestor.setMediator(new EmployeeLoginMediator("EMP12345", "password"));
		requestor.requestLogin();

	}
}
