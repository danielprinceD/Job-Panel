package com.example.designpattern.behavioral;

abstract class BaseGameLoader {

	public abstract void loadAssets();
	public abstract void initializeGame();
	public void startGame() {
		System.out.println("Default Game Started");
	}

	public final void loadGame(){
		loadAssets();
		initializeGame();
		startGame();
	}
}

class GodOfWarGameLoader extends BaseGameLoader {
	@Override public void loadAssets()
	{
		System.out.println("Loading God of War Assets");
	}

	@Override public void initializeGame()
	{
		System.out.println("Initializing God of War Game");
	}

	@Override public void startGame()
	{
		System.out.println("Starting God of War Game");
	}

}

class SpiderManGameLoader extends BaseGameLoader
{
	@Override public void loadAssets()
	{
		System.out.println("Loading Spider-Man Game");
	}

	@Override public void initializeGame()
	{
		System.out.println("Initializing Spider-Man Game");
	}

}



public class TemplateDesignPattern
{
	public static void main(String[] args)
	{
		BaseGameLoader gameLoader = new GodOfWarGameLoader();
		gameLoader.loadGame();

		System.out.println();

		gameLoader = new SpiderManGameLoader();
		gameLoader.loadGame();
	}

}
