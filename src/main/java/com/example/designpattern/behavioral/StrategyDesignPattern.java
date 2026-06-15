package com.example.designpattern.behavioral;

interface PaymentStrategy {
	void pay(double amount);
}

class CreditCardPayment implements PaymentStrategy {
	@Override public void pay(double amount)
	{
		System.out.println("Paying " + amount + " using Credit Card");
	}
}

class PaymentService{
	private PaymentStrategy paymentStrategy;

	public PaymentService(PaymentStrategy paymentStrategy) {
		this.paymentStrategy = paymentStrategy;
	}

	public void processPayment(double amount){
		paymentStrategy.pay(amount);
	}
}

class PayPalPayment implements PaymentStrategy
{
	@Override public void pay(double amount)
	{
		System.out.println("Paying " + amount + " using PayPal");
	}
}

public class StrategyDesignPattern
{
	public static void main(String[] args)
	{
		PaymentService paymentService = new PaymentService(new CreditCardPayment());
		paymentService.processPayment(100);
		paymentService = new PaymentService(new PayPalPayment());
		paymentService.processPayment(200);

	}
}
