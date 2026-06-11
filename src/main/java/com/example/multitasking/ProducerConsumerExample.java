package com.example.multitasking;

import java.util.LinkedList;
import java.util.Queue;

class BlockingQueue {
	private int capacity;
	private Queue<Integer> queue = new LinkedList<>();

	public BlockingQueue(int capacity){
		this.capacity = capacity;
	}

	public int add(int num){

		synchronized(queue){
			if(queue.size() == capacity){
				try{
					System.out.println("Queue is Full, Waiting for Consumer to Consume...");
					queue.wait();
				}catch(Exception e){e.printStackTrace();}
			}
			queue.add(num);
			queue.notifyAll();
			return num;
		}

	}

	public int remove(){
		synchronized(queue){
			if(queue.size() == 0){
				try{
					System.out.println("Queue is Empty, Waiting for Producer to Produce...");
					queue.wait();
				}catch(Exception e){e.printStackTrace();}
			}
			int num = queue.remove();
			queue.notifyAll();
			return num;
		}
	}
}

public class ProducerConsumerExample
{
	public static void main(String[] args)
	{
		BlockingQueue b = new BlockingQueue(2);
		Thread producer = new Thread(()->{
			for(int i=0; i<10; i++){
				System.out.println("Produced : " + b.add(i));
			}
		});

		Thread consumer = new Thread(()->{
			for(int i=0; i<10; i++){
				System.out.println("Consumed : " + b.remove());
			}
		});

		producer.start();
		consumer.start();


	}
}
