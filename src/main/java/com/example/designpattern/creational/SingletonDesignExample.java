package com.example.designpattern.creational;

class Book {
	private String title;
	private String author;
	public Book(String title , String author)
	{
		this.title = title;
		this.author = author;
	}
	public String getTitle()
	{
		return title;
	}
	public String getAuthor()
	{
		return author;
	}
}

class ArchieveBook {
	private static volatile ArchieveBook instance;

	private ArchieveBook(){

	}

	public static  ArchieveBook getInstance()
	{
		ArchieveBook localInstance = instance;
		if(localInstance == null){
			synchronized(ArchieveBook.class)
			{
				if(localInstance == null)
				{
					localInstance = instance = new ArchieveBook();
				}
			}
		}

		return localInstance;
	}

}

public class SingletonDesignExample
{
	public static void main(String[] args)
	{
		ArchieveBook book = ArchieveBook.getInstance();
		System.out.println(book.getClass().getName());
	}
}
