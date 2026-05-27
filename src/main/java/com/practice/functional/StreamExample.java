package com.practice.functional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample
{
	public static void main(String[] args)
	{
		int[] numbers = {1, 2, 3, 4, 5};

		int sum = java.util.Arrays.stream(numbers)
				.filter(n -> n % 2 == 0) // Filter even numbers
				.map(n -> n * n) // Square the filtered numbers
				.sum(); // Sum the squared numbers

		System.out.println("Sum of squares of even numbers: " + sum);
	}
}
