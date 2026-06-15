package com.example.designpattern.behavioral;

import java.util.ArrayList;
import java.util.List;

class Store {
	private NotificationService notificationService;

	public NotificationService getNotificationService()
	{
		return notificationService;
	}
	public Store(NotificationService notificationService)
	{
		this.notificationService = notificationService;
	}

	public void notifySubscribers(String message)
	{
		notificationService.notify(message);
	}

}

class NotificationService {
	private List<NotifificationListener> listeners = new ArrayList<>();

	public void subscribe(NotifificationListener listener)
	{
		listeners.add(listener);
	}

	public void unsubscribe(NotifificationListener listener)
	{
		listeners.remove(listener);
	}

	public void notify(String message)
	{
		for(NotifificationListener listener : listeners)
		{
			listener.notify(message);
		}
	}

}

interface NotifificationListener {
	void notify(String message);
}

class EmailNotificationListener implements NotifificationListener
{
	@Override public void notify(String message)
	{
		System.out.println("Email Notification: " + message);
	}
}

class SMSNotificationListener implements NotifificationListener
{
	@Override public void notify(String message)
	{
		System.out.println("SMS Notification: " + message);
	}
}

public class ObserverDesignPattern
{
	public static void main(String[] args)
	{
		Store store = new Store(new NotificationService());
		store.getNotificationService().subscribe(new EmailNotificationListener());
		store.getNotificationService().subscribe(new SMSNotificationListener());
		store.notifySubscribers("New product launched!");
	}
}
