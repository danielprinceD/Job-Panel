package com.practice.functional;

import java.util.function.Consumer;
import java.util.function.Function;

public class LambdaExample
{

	public static void main(String[] args)
	{
		Function<String, String> toUpperCase = str -> str.toUpperCase();
		System.out.println(toUpperCase.apply("hello"));

		Consumer<String> printWithPrefix = str -> System.out.println("Prefix: " + str);
		printWithPrefix.accept("Hello");
	}
}
