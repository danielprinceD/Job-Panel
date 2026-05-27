package com.practice.functional;

import java.util.function.Function;

public class FunctionExample
{

	public static int increement(int val){
		return ++val;
	}

	public static void main(String[] args) {
		Function<String , Integer > increaseLengthBy1 = str -> str.length() + 1;

		System.out.println( increaseLengthBy1.apply("Hello") );

		System.out.println(increement(2));
	}
}
