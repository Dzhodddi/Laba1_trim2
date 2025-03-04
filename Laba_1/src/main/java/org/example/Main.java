package org.example;

class Human {
	private String name;
	private String surname;
	private String middlename;
	private int age;
	private String employment;
	Human (String name, String surname, String middlename, int age, String employment) {
		this.name = name;
		this.surname = surname;
		this.middlename = middlename;
		this.age = age;
		this.employment = employment;
	}
}

class Professor extends Human{
    private String name;
    private String surname;
    private String middlename;
    private int age;
	private String cathedra;
	private String faculty;
	Professor(String name, String surname, String middlename, int age, String cathedra, String Faculty) {
		super(name, surname, middlename, age, "Proffesor");
		this.cathedra = cathedra;
		this.faculty = faculty;

	}
}

public class Main {

}
