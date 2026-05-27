package com.practice.functional;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

class Printer{

	public boolean printerStatus = true;

	public void toggle(){
		printerStatus = !printerStatus;
	}

	public void toggler(Consumer<Printer> consumer){
		consumer.accept(this);
		if(printerStatus == false){
			System.out.println("Printer is turned off");
		}
		else{
			System.out.println("Printer is turned on");
		}
	}

	public void print(String str){
		if(!printerStatus){
			System.out.println("Printer is turned off. Please turn it on to print.");
			return;
		}
		System.out.println(str);
	}
	public void customPrint(Consumer<String> consumer ,  String msg){
		if(!printerStatus){
			System.out.println("Printer is turned off. Please turn it on to print.");
			return;
		}
		consumer.accept(msg);
	}
}


public class ConsumerExample
{

	public static void main(String[] args)
	{
		Printer p = new Printer();
		p.print("Hello");
		p.customPrint(msg-> System.out.println("Custom: " + msg), "Hello");
		p.toggler(printer -> printer.toggle());
		p.print("Hello");
		biConsumer.accept("str 1" , "str 2" );

	}
	static BiConsumer<String , String > biConsumer = (str1 , str2) -> System.out.println(str1 + " " + str2);
}
