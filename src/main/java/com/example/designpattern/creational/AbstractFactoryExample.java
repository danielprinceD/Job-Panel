package com.example.designpattern.creational;


interface Character{
	void create();
}

interface GameEngine{
	void render();
}

abstract class Company {
	public abstract Character createCharacter();
	public abstract GameEngine createGameEngine();
}

class Villian implements Character{
	@Override public void create()
	{
		System.out.println("Creating Villian Character");
	}
}

class Hero implements Character{
	@Override public void create()
	{
		System.out.println("Creating Hero Character");
	}
}

class UnrealEngine implements GameEngine{
	@Override public void render()
	{
		System.out.println("Rendering with Unreal Engine");
	}
}

class UnityEngine implements GameEngine{
	@Override public void render()
	{
		System.out.println("Rendering with Unity Engine");
	}
}


class Capcom extends Company{
	@Override public Character createCharacter()
	{
		return new Villian();
	}
	@Override public GameEngine createGameEngine()
	{
		return new UnrealEngine();
	}
	public Capcom (){
		System.out.println("Capcom Company Created");
	}
}

class EA extends Company{
	@Override public Character createCharacter()
	{
		return new Hero();
	}
	@Override public GameEngine createGameEngine()
	{
		return new UnityEngine();
	}
	public EA (){
		System.out.println("EA Company Created");
	}
}

class GameFactory {
	public static Company getCompany(Class<? extends Company> companyClass)
	{
		Company company = null;
		try{
			company = Class.forName(companyClass.getName()).asSubclass(Company.class).getConstructor().newInstance();
			return company;
		}
		catch(Exception ex){
			ex.printStackTrace();
			throw new RuntimeException(ex.getMessage());
		}
	}
}

public class AbstractFactoryExample
{


	public static void main(String[] args)
	{
		Company company = GameFactory.getCompany(EA.class);
		company.createCharacter().create();
		company.createGameEngine().render();
	}
}
