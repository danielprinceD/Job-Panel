package com.example.multitasking;

public class ThreadStateExample
{
	public static void main(String[] args) throws InterruptedException
	{
		Thread thread = new Thread(()->{
			try{
				for(int i=0;i<5;i++){
					System.out.println("Thread State Example - Count: " + i);
					if(i == 2)
					{
						Thread.yield();
					}
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
		});
		Thread thread2 = new Thread(()->{
			try{
				for(int i=0;i<5;i++){
					System.out.println("Thread State Example 2 - Count: " + i);
					if(i == 3)
					{
						thread.join();
					}
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
		});
		thread.start();
		thread.join();
		thread2.start();

		thread2.join();
		System.out.println("Completed");


	}
}
