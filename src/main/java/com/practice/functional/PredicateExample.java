package com.practice.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class Person{
	String name;
	int age;
	boolean isVerified;
	Person(String name , int age , boolean isVerified){
		this.name = name;
		this.age = age;
		this.isVerified = isVerified;
	}
}

class Verifier{
	public static List<Person> verify(Predicate<Person> predicate, List<Person> obj){

		List<Person> verifiedList = new ArrayList<>();

		for(Person person : obj){
			if(predicate.test(person)){
				verifiedList.add(person);
			}
		}
		return verifiedList;
	}
}


public class PredicateExample
{
	static List<Person> people = List.of(
			new Person("John", 25, true) ,
			new Person("Jane" , 17, true),
			new Person("George" , 30, false),
			new Person("Emily" , 22, true)
	);

	public static void main(String[] args)
	{
		Predicate<Person> isAdult = person -> person.age >= 18;
		Predicate<Person> isVerified = person -> person.isVerified;

		List<Person> verifiedAdults = Verifier.verify(isAdult.and(isVerified) , people );
		verifiedAdults.forEach(person -> System.out.println(person.name + " is a verified adult."));

	}
}
