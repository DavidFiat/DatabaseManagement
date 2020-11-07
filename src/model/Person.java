package model;

public class Person {
	
	public final static char MASCULINE = 'M';
	public final static char FEMENINE = 'F';
	
	private String name;
	
	private String code;
	
	private String lastName;
	
	private char sex;
	
	private String date;
	
	private int height;
	
	private String nationality;
	
	public Person(String c, String n, String l, char s, String d, int he, String nat) {
		name = n;
		code = c;
		lastName = c;
		sex = s;
		date = d;
		height = he;
		nationality = nat;
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

	public int getHeight() {
		return height;
	}

	public String getNationality() {
		return nationality;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	
	 
}
