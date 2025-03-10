package org.example;
/*

    Створити/видалити/редагувати факультет.
    Створити/видалити/редагувати кафедру факультета.
    Додати/видалити/редагувати студента/викладача до кафедри.
    Знайти студента/викладача за ПІБ, курсом або групою.
    Вивести всіх студентів впорядкованих за курсами.
    Вивести всіх студентів/викладачів факультета впорядкованих за алфавітом.
    Вивести всіх студентів кафедри впорядкованих за курсами. (done, need test)
    Вивести всіх студентів/викладачів кафедри впорядкованих за алфавітом. (done, need test)
	Вивести всіх студентів кафедри вказаного курсу. (done, need test)
    Вивести всіх студентів кафедри вказаного курсу впорядкованих за алфавітом. (done, need test)


*/

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
		return "My name is: " + name + " " + surname + " " + middlename + " I'm " + age + " ,and I'm working as a " + employment;
	}
	public String getName() {
		return name + " " + surname;
	}

	public String getFullName() {
		return getName() + " " + middlename;
	}

	public int getAge() {
		return age;
	}

	public boolean toEquals(Human human) {
		return human.getFullName().equals(getFullName());
	}
}

class Professor extends Human{
	private String cathedra;
	private String faculty;
	Professor(String name, String surname, String middlename, int age, String cathedra, String faculty) {
		super(name, surname, middlename, age, "Professor");
		this.cathedra = cathedra;
		this.faculty = faculty;

	}

	public String toString() {
		return super.toString() + " in university at " + cathedra + " cathedra in " + faculty + " faculty"; 
	}

	public String getFaculty() {
		return faculty;
	}

	public String getCathedra() {
		return cathedra;
	}


}

class Student extends Human{

	private int year;
	private int group;
	private String cathedra;
	private String faculty;

	Student(String name, String surname, String middlename, int age, int year, int group, String cathedra, String faculty) {
		super(name, surname, middlename, age, "Student");
		this.year = year;
		this.group = group;
		this.cathedra = cathedra;
		this.faculty = faculty;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year){
		//bachelor
		this.year = year; // validation will be on the input side, not set side
	}

	public int getGroup() {
		return group;
	}

	public void setGroup(int group){
		this.group = group;
	}

	public String getFaculty(){
		return faculty;
	}

	public void setFaculty(String faculty){
		this.faculty = faculty;
	}

	public String getCathedra(){
		return cathedra;
	}

	public void setCathedra(String cathedra){
		this.cathedra = cathedra;
	}

	public String toString(){
		return super.toString() + ". I'm studying at " + cathedra + " at cathedra " + cathedra + " on " + year + " year.";
	}
}
//--------------------------------------------------------------
// в класі University
//
//private static int size = 1;
//
//private String[] employance = new String[1];
//private Faculty[] faculty = new Faculty[1];
//private Cathedra[] cathedra = new Cathedra[1];
//private ...
//+get/set
//
//employance задається з main
//
/*public void setData(String employance, String faculty, String cathedra, int year, int group, String name, String sname, String mname){
//
	tempEmp = Arrays.copyOf(this.employance, this.employance.length+1);
	setEmployance(tempEmp);
	tempFaculty = Arrays.copyOf(this.faculty, this.faculty.length+1);
	setFaculty(tempFaculty);
//
	...6 times
//
	this.employance[size-1] = employance;
	this.faculty[size-1] = faculty;
	this.cathedra[size-1] = cathedra;
	...5 times
//
	size++
}*/
//--------------------------------------------------------------
	
class Cathedra {
	private String name;
	private Professor [] professors;
	private Student [] students;
	Cathedra(String name, Student [] students , Professor [] professors  ) {
		this.name = name;
		this.students = students.clone();
		this.professors = professors.clone();
	}

	public String toString() {
		return "This is " + name +" cathedra";
	}

	public void addStudent(Student addedStudent) {
		students = (appendStudent(students, addedStudent)).clone();
	}

	public void addProfessor(Professor addedProfessor) {
		professors = (appendProfessor(professors, addedProfessor)).clone();
	}

	public void printHuman(Human [] people) {
		for (Human human: people)
			System.out.println(human);
	}

	public void orderedStudentsAlphabetically() {
		Human [] orderedStudents = Utils.quickSortByName(students.clone(), 0, students.length - 1);
		System.out.println("Ordered students alphabetically: ");
		printHuman(orderedStudents);
	}

	public void orderedStudentsByYear() {
		Student [] orderedStudents = Utils.quickSortByYear(students.clone(), 0, students.length - 1);
		System.out.println("Ordered students by year: ");
		printHuman(orderedStudents);
	}


	public void selectStudentsByYear(int year) {
		for (Student student : students) {
			if (student.getYear() == year) {
				System.out.println(student);
			}
		}
	}

	public void orderedStudentsAlphabeticallyInSelectedYear(int year) {
		Student [] orderedStudents = (Student[]) Utils.quickSortByName(students.clone(), 0, students.length - 1);
		System.out.println("Ordered students by name with year " + year + " alphabetically: ");
		for (Student student : orderedStudents) {
			if (student.getYear() == year) {
				System.out.println(student);
			}
		}
	}

	public void orderedProfessorsAlphabetically() {
		Human [] orderedProfessors = Utils.quickSortByName(professors.clone(), 0, professors.length - 1);
		System.out.println("Ordered professors alphabetically: ");
		printHuman(orderedProfessors);
	}

	public Student [] getStudents() {
		return students;
	}

	public int amountOfStudents() {
		return students.length;
	}

	public Professor [] getProfessors() { return professors; }

	public int amountOfProfessors() {return  professors.length; }

	private Student [] appendStudent( Student [] students ,Student student) {
		Student [] newStudents = new Student[students.length + 1];
		System.arraycopy(students, 0, newStudents, 0, students.length);
		newStudents[students.length] = student;
		return newStudents;
	}

	private Professor [] appendProfessor( Professor [] professors ,Professor professor) {
		Professor [] newProfessor = new Professor[professors.length + 1];
		System.arraycopy(professors, 0, newProfessor, 0, professors.length);
		newProfessor[professors.length] = professor;
		return newProfessor;
	}

}


//class Faculty {
//	private String name;
//	private Cathedra [] cathedrae;
//	Faculty(String name) {
//		this.name = name;
//	}
//
//	public Cathedra [] getCathedrae() {
//		return cathedrae;
//	}
//
//	public int amountOfStudents() {
//		int counter = 0;
//		for (Cathedra cathedra : cathedrae) {
//			counter += cathedra.amountOfStudents();
//		}
//		return counter;
//	}
//}



//class University {
//	private String name;
//	private Faculty [] faculties;
//	private int amountOfStudents = 0;
//	private Student [] students;
//	private Professor [] professors;
//	University(String name) {
//		this.name = name;
//	}
//
//	public void findStudent(String name) {
//		for (Student student : students) {
//			if (student.getName().equals(name)) {
//				System.out.println(student);
//			}
//		}
//	}
//
//	public void findStudents(String name, int year) {
//		for (Student student : students) {
//			if (student.getName().equals(name) && student.getYear() == year) {
//				System.out.println(student);
//			}
//		}
//	}
//
//	public void findStudents(String name, int year, int group) {
//		for (Student student : students) {
//			if (student.getName().equals(name) && student.getYear() == year && student.getGroup() == group) {
//				System.out.println(student);
//			}
//		}
//	}
//
//	public void findProfessor(String name) {
//		for (Professor professor : professors) {
//			if (professor.getName().equals(name)) {
//				System.out.println(professor);
//			}
//		}
//	}
//
//	public void findProfessor(String name, int [] group) {
//		for (Professor professor : professors) {
//			if (professor.getName().equals(name)) {
//				System.out.println(professor);
//			}
//		}
//	}
//
//
//}

