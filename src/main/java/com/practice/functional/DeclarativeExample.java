package com.practice.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

interface Math {
	int add(int a, int b);
}


public class DeclarativeExample
{
	public static void main(String[] args)
	{

		List<People> people = List.of(
				new People("John", Gender.MALE) ,
				new People("Jane" , Gender.FEMALE),
				new People("George" , Gender.MALE),
				new People("Emily" , Gender.FEMALE)
		);

		List<People> females = new ArrayList<>();

//      Imperative approach
//		for(People person : people) {
//			if(person.gender == Gender.FEMALE)
//				females.add(person);
//		}

		// Declarative approach using Streams
		people.stream()
			.filter(person->Gender.FEMALE.equals(person.gender))
			.forEach(
				person-> System.out.println(person.name + " is " + person.gender)
			);

//		for(People female : females){
//			System.out.println(female.name + " is a " + female.gender);
//		}




	}
	static class People {
		final String name;
		final Gender gender;
		People(String name , Gender gender){
			this.name = name;
			this.gender = gender;
		}
	}

	enum Gender
	{
		MALE, FEMALE;
	}
}
