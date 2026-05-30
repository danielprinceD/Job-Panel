package com.practice.customannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.function.Function;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
	Class<?> value();
	Class<? extends Function<String , String>> function();
}

class Elephant {
	public void eat() {
		System.out.println("Elephant is eating");
	}
}

class StringFunction implements Function<String , String>
{
	@Override
	public String apply(String s) {
		return s.toUpperCase();
	}
}

@MyAnnotation( value = Elephant.class , function = StringFunction.class)
class Animal {
	public void eat() {
		System.out.println("Animal is eating");
	}
}


public class AnnotationExample
{
	public static void main(String[] args)
	{
		Animal animal = new Animal();
		if(animal.getClass().getAnnotation(MyAnnotation.class) != null)
		{
			MyAnnotation annotation = animal.getClass().getAnnotation(MyAnnotation.class);
			System.out.println("Annotation value: " + annotation.value().getName());
			try{
				Object obj = Class.forName(annotation.value().getName()).newInstance();
				if(obj instanceof Elephant)
				{
					Elephant elephant = (Elephant) obj;
					elephant.eat();
				}
				else
				{
					System.out.println("The class specified in the annotation is not an instance of Elephant");
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
