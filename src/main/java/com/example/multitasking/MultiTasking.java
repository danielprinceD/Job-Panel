package com.example.multitasking;

public class MultiTasking
{
	public static void main(String[] args)
	{
		Thread task1 = new Thread(()->{
			for(int i=0; i<5; i++)
			{
				System.out.println("Task 1 - Count: " + i);
				try
				{
					Thread.sleep(1000);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		} , "Task-1");

		task1.setDaemon(true);
//		task1.start();
		Thread task2 = new Thread(()->{
			for(int i=0; i<5; i++)
			{
				System.out.println("Task 2 - Count: " + i);
				try
				{
					Thread.sleep(1500);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}

			Thread task1_1 = new Thread(()->{
				for(int j=0; j<3; j++)
				{
					System.out.println("Task 1.1 - Count: " + j);
					try
					{
						Thread.sleep(500);
					}
					catch (InterruptedException e)
					{
						e.printStackTrace();
					}
				}
			});
//			task1_1.setDaemon(true);
			task1_1.start();
		} , "Task-2");

		task2.start();
	}
}
