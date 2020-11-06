package ui;

public class Person {

	private String name;
	private String code;
	private String lastName;
	private char sex;
	private String date;
	
	public Person(String n, String c, String l, char s, String d) {
		name = n;
		code = c;
		lastName = c;
		sex = s;
		date = d;
	}

	public String getName() {
		return name;
	}

	public String getCode() {
		return code;
	}

	public String getLastName() {
		return lastName;
	}

	public char getSex() {
		return sex;
	}

	public String getDate() {
		return date;
	}
	
	
	 
}
