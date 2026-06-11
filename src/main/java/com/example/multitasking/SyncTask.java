package com.example.multitasking;

class Adder {
	int num = 0;
	Object lock  = new Object();
	public int add(int num)
	{
		synchronized(new Object()){
			this.num += num;
			return this.num;
		}

	}
	public int sub(int num)
	{
		synchronized(this){
			this.num -= num;
			return this.num;
		}
	}
	public int getNum()
	{
		return this.num;
	}
}

public class SyncTask
{
	public static void main(String[] args)
	{
		Adder adder = new Adder();
		new Thread(()->{
			for(int i=0; i<1000; i++)
			{
				adder.add(10);
			}
		}).start();

		new Thread(()->{
			for(int i=0; i<1000; i++)
			{
				adder.sub(20);
			}
		}).start();

		try{
			Thread.sleep(200);
		}
		catch(Exception e){
			e.getStackTrace();
		}
		System.out.println("Value Added By Main Thread : " + ( (10 * 1000) - (20 * 1000) ) );
		System.out.println( "Value Added By Using Thread : " + adder.getNum());

	}
}
