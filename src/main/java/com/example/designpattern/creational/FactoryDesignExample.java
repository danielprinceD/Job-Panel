package com.example.designpattern.creational;

import java.lang.reflect.InvocationTargetException;

abstract class OS
{
	private final int version;
	private final String osName;
	public void spec()
	{
		System.out.println("This is an Operating System");
	}
	public OS(int version , String osName)
	{
		this.version = version;
		this.osName = osName;
		System.out.println("OS Version : " + version + " , OS Name : " + osName);
	}
	public abstract void create();

	public void destroy(){
		System.out.println("Destroying " + osName + " OS");
	}
}


class Windows extends OS {

	public Windows(int version)
	{
		super(version, "Windows");
	}

	@Override public void create()
	{
		System.out.println("Creating Windows OS");
	}
}

class Linux extends OS {

	public Linux(int version)
	{
		super(version, "Linux");
	}

	@Override public void create()
	{
		System.out.println("Creating Linux OS");
	}
}

class OperatingSystemFactory
{
	public static OS getInstance(Class <? extends OS> osClass , int version){
		OS os = null;
		try{
			os = Class.forName(osClass.getName()).asSubclass(OS.class).getConstructor(int.class).newInstance(version);
			return os;
		}
		catch(Exception ex){
			ex.printStackTrace();
			throw new RuntimeException(ex.getMessage());
		}
	}

}


public class FactoryDesignExample
{
	public static void main(String[] args)
	{
		OS windowsOS = OperatingSystemFactory.getInstance(Windows.class , 10);
		windowsOS.create();
		OS linuxOS = OperatingSystemFactory.getInstance(Linux.class , 5);
		linuxOS.create();
		windowsOS.destroy();
		linuxOS.destroy();

	}
}
