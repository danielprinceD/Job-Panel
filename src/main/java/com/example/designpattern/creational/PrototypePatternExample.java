package com.example.designpattern.creational;


abstract class Vehicle  {
	private  String type;
	private String model;

	public Vehicle(Vehicle vehicle) {
		this.type = type;
		this.model = model;
	}
	public abstract Vehicle clone();
}

class Car extends Vehicle {

	public Car(Vehicle car) {
		super(car);
	}

	@Override public Car clone()
	{
		return new Car(this);
	}
}


public class PrototypePatternExample
{
	public static void main(String[] args)
	{
		Car car = new Car(null);
		Car clonedCar = car.clone();

		System.out.println("Original Car: " + car);
		System.out.println("Cloned Car: " + clonedCar);
	}
}
