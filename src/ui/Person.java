package ui;

import javafx.scene.control.Button;

public class Person {

	private String name;
	
	private Button bt;
	
	public Person(String n) {
		name = n;
		bt = new Button("Editar");
	}

	public String getName() {
		return name;
	}

	public Button getBt() {
		return bt;
	}
	
	 
}
