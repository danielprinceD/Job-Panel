package com.example.designpattern.behavioral;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

// Originator
class TextArea {
	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Memento takeSnapshot() {
		return new Memento(text);
	}

	public void restore(Memento memento) {
		this.text = memento.text;
	}

	public static class Memento {
		private final String text;

		public Memento(String text) {
			this.text = text;
		}
	}

}

// Caretaker

class Editor {
	private TextArea textArea;
	private Deque<TextArea.Memento> history = new LinkedList<>();

	public Editor() {
		this.textArea = new TextArea();
	}

	public void write(String text) {
		history.push(textArea.takeSnapshot());
		textArea.setText(text);
	}

	public void undo() {
		if (!history.isEmpty()) {
			textArea.restore(history.pop());
		}
	}
	public void print(){
		System.out.println(textArea.getText());
	}
}


public class MementoDesignPattern
{
	public static void main(String[] args)
	{
		Editor editor = new Editor();
		editor.write("Hello, World!");
		editor.print();
		editor.write("Hello, Memento Pattern!");
		editor.print();
		editor.undo();
		editor.print();
	}
}
