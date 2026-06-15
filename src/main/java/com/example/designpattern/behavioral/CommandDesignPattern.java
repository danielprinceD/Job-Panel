package com.example.designpattern.behavioral;

interface Command {
	void execute();
}

class ChargerCommand implements Command {

	private boolean isCharging = false;

	@Override public void execute()
	{
		isCharging = !isCharging;
		if(isCharging){
			System.out.println("Charger is now ON");
		}else{
			System.out.println("Charger is now OFF");
		}
	}
}

class LampLightCommand implements Command {

	private boolean isLightOn = false;

	@Override public void execute()
	{
		isLightOn = !isLightOn;
		if(isLightOn){
			System.out.println("Lamp Light is now ON");
		}else{
			System.out.println("Lamp Light is now OFF");
		}
	}
}

class LivingRoom {
	private Command command;

	public void setCommand(Command command)
	{
		this.command = command;
	}

	public void executeCommand(){
		command.execute();
	}
}


public class CommandDesignPattern
{
	public static void main(String[] args)
	{
		LivingRoom room = new LivingRoom();
		room.setCommand(new ChargerCommand());
		room.setCommand(new LampLightCommand());
		room.executeCommand();
	}
}
