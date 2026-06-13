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
	private static ArchieveBook instance;

	private ArchieveBook(){

	}

	public static  ArchieveBook getInstance()
	{
		if(instance == null){
			synchronized(ArchieveBook.class)
			{
				if(instance == null)
				{
					instance = new ArchieveBook();
				}
			}
		}

		return instance;
	}

}

public class SingletonDesignExample
{
	public static void main(String[] args)
	{
		ArchieveBook book = ArchieveBook.getInstance();
	}
}
