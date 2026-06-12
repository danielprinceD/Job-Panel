package com.example.multitasking;

public class DeadlockExample
{
	public static void main(String[] args)
	{
		Object lock1 = new Object();
		Object lock2 = new Object();

		Thread th1 = new Thread(()->{
			synchronized(lock1){
				System.out.println("Thread 1: Holding lock 1...");
				synchronized(lock2){
					System.out.println("Thread 1: Holding lock 2...");
				}
			}
		});

		Thread th2 = new Thread(()->{
			synchronized(lock2){
				System.out.println("Thread 2: Holding lock 2...");
				synchronized(lock1){
					System.out.println("Thread 2: Holding lock 1...");
				}
			}
		});

		th1.start();
		th2.start();



	}
}
