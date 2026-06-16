package com.example.designpattern.structural;

class OldSystem {
	public void oldMethod(){
		System.out.println("Old system method called");
	}
}

class NewSystem {
	public void newMethod() {
		System.out.println("New system method called");
	}
}

class NewSystemAdapter extends OldSystem {
	private NewSystem newSystem;

	public NewSystemAdapter(NewSystem newSystem) {
		this.newSystem = newSystem;
	}

	@Override
	public void oldMethod() {
		newSystem.newMethod();
	}
}

public class AdapterDesignPattern
{
	public static void main(String[] args)
	{
		NewSystemAdapter adapter = new NewSystemAdapter(new NewSystem());
		adapter.oldMethod();
	}
}
