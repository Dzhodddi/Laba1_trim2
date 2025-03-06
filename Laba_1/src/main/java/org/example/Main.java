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
	
	public String toString() {
		return "My name is: " + name + " " + surname + " " + middlename + " ,and I'm working as a " + employment;
	}
	public String getName() {
		return name + " " + surname;
	}
}

class Professor extends Human{
    private String name;
    private String surname;
    private String middlename;
    private int age;
	private String cathedra;
	private String faculty;
	private int salary;
	private  String [] groups;
	private  String [] students;
	Professor(String name, String surname, String middlename, int age, String cathedra, String Faculty) {
		super(name, surname, middlename, age, "Professor");
		this.cathedra = cathedra;
		this.faculty = faculty;

	}

	public String toString() {
		return super.toString() + " in university at " + cathedra + " cathedra in " + faculty + " faculty"; 
	}

}

class Cathedra {
	private String name;
	private Professor [] professors;
//	private Students [] students;
	
}

class Faculty {

}

class Student {

}

class University {

}

