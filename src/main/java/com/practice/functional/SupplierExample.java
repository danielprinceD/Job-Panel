package com.practice.functional;

import java.util.function.Supplier;


class Lazy<T> implements Supplier<T> {
	T value;
	Supplier<T> supplier;
	public Lazy(Supplier<T> supplier){
		this.supplier = supplier;
	}
	@Override
	public T get() {
		if(value == null){
			value = supplier.get();
		}
		return value;
	}
}

public class SupplierExample
{

	static class DatabaseConnection {
		private String connectionString;

		public DatabaseConnection(Supplier<String> connectionStringSupplier) {
			this.connectionString = connectionStringSupplier.get();
		}


		public void connect() {
			System.out.println("Connecting to database with connection string: " + connectionString);
		}
	}

	public static void main(String[] args)
	{

		Lazy<String> stringSupplier = new Lazy<>( ()-> {
			System.out.println("Generating string...");
			return "Hello, World!";
		});

		DatabaseConnection dbConnection = new DatabaseConnection(() -> "jdbc:mysql://localhost:3306/mydb");

		System.out.println(stringSupplier.get());

	}
}
