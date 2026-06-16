package com.example.designpattern.structural;

interface Inotifier {
	void send(String message);
	void getUserInfo();
}

class Notifier implements Inotifier {
	public void send(String message) {
		System.out.println("Sending message: " + message);
	}
	public void getUserInfo() {
		System.out.println("Getting user info");
	}
}

abstract class BaseNotificationDecorator implements Inotifier {

	private Inotifier notifier;

	public BaseNotificationDecorator(Inotifier notifier) {
		this.notifier = notifier;
	}

	public void send(String message) {
		notifier.send(message);
	}

	public void getUserInfo() {
		notifier.getUserInfo();
	}

}

class WhatsppNotificationDecorator extends BaseNotificationDecorator {
	public WhatsppNotificationDecorator(Inotifier notifier) {
		super(notifier);
	}
	public void send(String message) {
		super.send(message);
		System.out.println("Sending WhatsApp notification: " + message);
	}
	public void getUserInfo() {
		super.getUserInfo();
		System.out.println("Getting user info for WhatsApp notification");
	}
}

class EmailNotificationDecorator extends BaseNotificationDecorator {

	public EmailNotificationDecorator(Inotifier inotifier){
		super(inotifier);
	}

	public void send(String message) {
		super.send(message);
		System.out.println("Sending Email notification: " + message);
	}

	public void getUserInfo() {
		super.getUserInfo();
		System.out.println("Getting user info for Email notification");
	}

}


public class DecoratorDesignPattern
{
	public static void main(String[] args)
	{
		Inotifier notifier = new WhatsppNotificationDecorator(new EmailNotificationDecorator(new Notifier()));
		notifier.send("Hello, World!");
	}
}
