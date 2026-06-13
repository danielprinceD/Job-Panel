package com.example.designpattern.creational;


class Product
{
	private String name;
	private double price;
	private String description;

	Product(String name , double price , String description)
	{
		this.name = name;
		this.price = price;
		this.description = description;
	}

	@Override public String toString()
	{
		return "Product{" +
				"name='" + name + '\'' +
				", price=" + price +
				", description='" + description + '\'' +
				'}';
	}
}

class ProductBuilder
{
	private String name;
	private double price;
	private String description;

	public ProductBuilder setName(String name)
	{
		this.name = name;
		return this;
	}

	public ProductBuilder setPrice(double price)
	{
		this.price = price;
		return this;
	}

	public ProductBuilder setDescription(String description)
	{
		this.description = description;
		return this;
	}

	public Product build()
	{
		return new Product(name , price , description);
	}
}

class ProductDirector{
	public void createSnacks(ProductBuilder builder){
		builder.setDescription("Snacks are delicious and perfect for any time of the day");
		builder.setPrice(5.99);
	}
}


public class BuilderDesignExample
{
	public static void main(String[] args)
	{
		ProductBuilder builder = new ProductBuilder()
			.setName("Laptop");
		ProductDirector productDirector = new ProductDirector();
		productDirector.createSnacks(builder);

		Product product = builder.build();
		System.out.println(product);

	}
}
