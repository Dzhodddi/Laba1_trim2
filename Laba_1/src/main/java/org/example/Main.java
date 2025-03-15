package org.example;
/*

    Створити/видалити/редагувати факультет.
    Створити/видалити/редагувати кафедру факультета.
    Додати/видалити/редагувати студента/викладача до кафедри. (done, need test)
    Знайти студента/викладача за ПІБ, курсом або групою.
    Вивести всіх студентів впорядкованих за курсами.
    Вивести всіх студентів/викладачів факультета впорядкованих за алфавітом.
    Вивести всіх студентів кафедри впорядкованих за курсами. (done, need test)
    Вивести всіх студентів/викладачів кафедри впорядкованих за алфавітом. (done, need test)
	Вивести всіх студентів кафедри вказаного курсу. (done, need test)
    Вивести всіх студентів кафедри вказаного курсу впорядкованих за алфавітом. (done, need test)


*/

import java.io.IOException;

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

	public String getSurname() {return surname; }

	public String getMiddlename() {return middlename; }

	public String getFirstName() {return name; }

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
		students = (appendStudent(addedStudent)).clone();
	}

	public void addProfessor(Professor addedProfessor) {
		professors = (appendProfessor(addedProfessor)).clone();
	}

	public void deletedProfessor(String name) {
		int index =  getIndexOfSearchedHumanByName(professors, name);
		if (index == -1) {
			System.out.println("Professor with this name doesn't exits");
			return ;
		}
		professors = deleteProfessor(index).clone();
	}

	public void deletedStudents(String name) {
		int index =  getIndexOfSearchedHumanByName(students, name);
		if (index == -1) {
			System.out.println("Student with this name doesn't exits");
			return ;
		}
		students = deleteStudent(index).clone();
	}

	public void editedStudent(String name, Student student) {
		int index = getIndexOfSearchedHumanByName(students, name);
		if (index == -1) {
			System.out.println("Student with this name doesn't exits");
			return;
		}
		students = editStudent(index, student).clone();
	}

	public void editedProfessor(String name, Professor professor) {
		int index = getIndexOfSearchedHumanByName(professors, name);
		if (index == -1) {
			System.out.println("Student with this name doesn't exits");
			return;
		}
		professors = editProfessor(index, professor).clone();
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

	private Student [] appendStudent(Student student) {
		Student [] newStudents = new Student[students.length + 1];
		System.arraycopy(students, 0, newStudents, 0, students.length);
		newStudents[students.length] = student;
		return newStudents;
	}

	private Professor [] appendProfessor(Professor professor) {
		Professor [] newProfessor = new Professor[professors.length + 1];
		System.arraycopy(professors, 0, newProfessor, 0, professors.length);
		newProfessor[professors.length] = professor;
		return newProfessor;
	}

	private Student [] deleteStudent(int index) {
		Student [] newStudents = new Student[students.length - 1];
		System.arraycopy(students, 0, newStudents, 0,index);
		System.arraycopy(students, index + 1, newStudents, index, students.length - index - 1);
		return newStudents;
	}

	private Professor [] deleteProfessor(int index) {
		Professor [] newProfessors = new Professor[professors.length - 1];
		System.arraycopy(professors, 0, newProfessors, 0,index);
		System.arraycopy(professors, index + 1, newProfessors, index, professors.length - index - 1);
		return newProfessors;
	}

	private Student [] editStudent(int index, Student student) {
		students[index] = student;
		return students;
	}

	private Professor [] editProfessor(int index, Professor professor) {
		professors[index] = professor;
		return professors;
	}

	private int getIndexOfSearchedHumanByName(Human [] people ,String name ) {
		// the name contain name + surname divided by space, if there are similar names, the left ones will be changed. If no students found, will return -1
		for (int i = 0; i < people.length; i++) {
			if (people[i].getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStudents(Student[] students) {
		this.students = students;
	}

	public void setProfessors(Professor[] professors) {
		this.professors = professors;
	}
}

class Faculty {
	private String name;
	private Cathedra [] cathedrae;

	Faculty(String name, Cathedra [] cathedrae) {
		this.name = name;
		this.cathedrae = cathedrae;
	}

	public void showCathedraeList(){
		System.out.println("\n\t\t ** Cathedrae Of University: **");
		for(int i = 0; i < cathedrae.length; i++){
			System.out.println("\t - "+(i+1)+" cathedra is "+ cathedrae[i].getName());
		}
	}

	public Student[] allFacultyStudents(){
		int counter = 0;

        for (Cathedra value : this.cathedrae) {
            counter += value.amountOfStudents();
        }

		Student[] students = new Student[counter];
		int index = 0;
        for (Cathedra cathedra : this.cathedrae) {
            Student[] cathedraStudents = cathedra.getStudents();
            for (Student cathedraStudent : cathedraStudents) {
                students[index] = cathedraStudent;
                index++;
            }
        }

		return students;
	}

	public Professor[] allFacultyProfessors(){
		int counter = 0;

		for (Cathedra value : this.cathedrae) {
			counter += value.amountOfProfessors();
		}

		Professor[] professors = new Professor[counter];
		int index = 0;
		for (Cathedra cathedra : this.cathedrae) {
			Professor[] cathedraProfessors = cathedra.getProfessors();
			for (Professor cathedraProfessor : cathedraProfessors) {
				professors[index] = cathedraProfessor;
				index++;
			}
		}

		return professors;
	}

	public static Student[] selectionSortStudentsAlphabetically(Student [] students) {
		int x = students.length;

		for (int i = 0; i < x - 1; i++) {
			int min_idx = i;

			for (int j = i + 1; j < x; j++) {

				if (compare(students[j].getName(), students[min_idx].getName()) < 0) {
					min_idx = j;
				}
			}

			if (min_idx != i) {
				Student temp = students[i];
				students[i] = students[min_idx];
				students[min_idx] = temp;
			}
		}
		return students;
	}

	public static Professor[] selectionSortProfessorsAlphabetically(Professor [] professors) {
		int x = professors.length;

		for (int i = 0; i < x - 1; i++) {
			int min_idx = i;

			for (int j = i + 1; j < x; j++) {

				if (compare(professors[j].getName(), professors[min_idx].getName()) < 0) {
					min_idx = j;
				}
			}

			if (min_idx != i) {
				Professor temp = professors[i];
				professors[i] = professors[min_idx];
				professors[min_idx] = temp;
			}
		}
		return professors;
	}



	private static int compare(String a, String b) {
		int minLength = Math.min(a.length(), b.length());

		for (int i = 0; i < minLength; i++) {
			char charA = Character.toUpperCase(a.charAt(i));
			char charB = Character.toUpperCase(b.charAt(i));

			if (charA != charB) {
				return charA - charB;
			}
		}
		return a.length() - b.length();
	}

	public void addCathedra() throws IOException {
		Cathedra[] cathedrae = new Cathedra[this.cathedrae.length+1];
		for(int i = 0; i < this.cathedrae.length; i++){
			cathedrae[i] = this.cathedrae[i];
		}
		String name = DataInput.getString("Input cathedra' name: ");
		int amountOfStudents = DataInput.validateNumber("Input amount of students: ", 1, 100);
		int amountOfProfessors = DataInput.validateNumber("Input amount of professors: ", 1, 100);
		Student [] students = new Student[amountOfStudents];
		Professor [] professors = new Professor[amountOfProfessors];
		cathedrae[this.cathedrae.length+1] = new Cathedra(name, students, professors);
		System.out.println("\n\t\t** Cathedra "+name+" created **");
	}
	public void editCathedra(int index, String name){
		cathedrae[index].setName(name);
		System.out.println("\n\t\t ** Name Of The Cathedra Successfully Changed ** \n");
	}

	public void deleteCathedra(int index) throws IOException{
		cathedrae[index].setStudents(null);
		cathedrae[index].setProfessors(null);
		cathedrae[index] = null;
		rebuildCathedraList();
		System.out.println("\n\t\t ** Cathedra Deleted Successfully ** \n");
	}

	private void rebuildCathedraList(){
		Cathedra[] cathedrae = new Cathedra[this.cathedrae.length-1];
		for(int i = 0, j = 0; i < this.cathedrae.length; i++){
			if(cathedrae[i] != null){
				this.cathedrae[j] = cathedrae[i];
				j++;
			}
		}
	}

	public Cathedra cathedraAtIndex(int index){
		return cathedrae[index];
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Cathedra [] getCathedrae() {
		return cathedrae;
	}

	public void setCathedrae(Cathedra [] cathedra){
		this.cathedrae = cathedra;
	}
	public int amountOfStudents(){
		int counter = 0;
		for (Cathedra cathedra : cathedrae) {
			counter += cathedra.amountOfStudents();
		}
		return counter;
	}

	public int amountOfProfessors(){
		int counter = 0;
		for (Cathedra cathedra : cathedrae) {
			counter += cathedra.amountOfProfessors();
		}
		return counter;
	}
}

class University {
	private String name;
	private Faculty [] faculties;

	University(String name, Faculty[] faculties) {
		this.name = name;
		this.faculties = faculties;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void showFacultiesList(){
		System.out.println("\n\t\t ** Faculties Of University: **\n");
		for(int i = 0; i < faculties.length; i++){
			System.out.println("\t - "+(i+1)+" faculty is "+ faculties[i].getName());
		}
	}

	public void addFaculty() throws IOException {
		Faculty[] faculties = new Faculty[this.faculties.length+1];
        System.arraycopy(this.faculties, 0, faculties, 0, this.faculties.length);
		String name = DataInput.getString("Input cathedra' name: ");
		int amountOfCathedrae = DataInput.validateNumber("Input amount of cathedrae: ", 1, 10);
		Cathedra[] cathedrae = new Cathedra[amountOfCathedrae];
		faculties[this.faculties.length+1] = new Faculty(name, cathedrae);
		System.out.println("\n\t\t** Faculty "+name+" created **");
	}
	public void editFaculty(int index, String name) throws IOException {
		String temp = faculties[index].getName();
		faculties[index].setName(name);
		System.out.println("\n\t\t ** Name Of The "+temp+" Faculty Successfully Changed To "+name+"** \n");
	}

	public void deleteFaculty(int index) throws IOException {
		for(int i = 0; i < faculties[index].getCathedrae().length; i++){
			faculties[index].deleteCathedra(i);
		}
		faculties[index] = null;
		System.out.println("\n\t\t ** Faculty Deleted Successfully ** \n");
		rebuildFacultyList();
	}

	private void rebuildFacultyList(){
		Faculty[] faculties = new Faculty[this.faculties.length-1];
		for(int i = 0, j = 0; i < this.faculties.length; i++){
			if(faculties[i] != null){
				this.faculties[j] = faculties[i];
				j++;
			}
		}
	}

	public Student[] allUniversityStudents(){
		int counter = 0;

        for (Faculty value : this.faculties) {
			counter += value.amountOfStudents();
        }

		Student[] students = new Student[counter];
		int index = 0;
        for (Faculty faculty : this.faculties) {
            Student[] facultyStudents = faculty.allFacultyStudents();
            for (Student facultyStudent : facultyStudents) {
                students[index] = facultyStudent;
                index++;
            }
        }
		return students;
	}

	public Professor[] allUniversityProfessors(){
		int counter = 0;

		for (Faculty value : this.faculties) {
			counter += value.amountOfProfessors();
		}

		Professor[] professors = new Professor[counter];
		int index = 0;
		for (Faculty faculty : this.faculties) {
			Professor[] facultyProfessors = faculty.allFacultyProfessors();
			for (Professor facultyProfessor : facultyProfessors){
				professors[index] = facultyProfessor;
				index++;
			}
		}

		return professors;
	}

	public Faculty[] getFaculties() {
		return faculties;
	}

	public void setFaculties(Faculty[] faculties) {
		this.faculties = faculties;
	}



	public Faculty facultyAtNumber(int num){
		return faculties[num-1];
	}

	public static Student[] selectionSortByYear(Student[] students){
		int x = students.length;
		for (int i = 0; i < x - 1; i++) {

			int min_idx = i;

			for (int j = i + 1; j < x; j++) {
				if (students[j].getYear() < students[min_idx].getYear())
					min_idx = j;
			}
			Student temp = students[i];
			students[i] = students[min_idx];
			students[min_idx] = temp;
		}
		return students;
	}

	public static void printAllStudents(Student[] students){
		for(int i = 0; i < students.length; i++){
			System.out.println((i+1)+". "+students[i].getName());
		}
	}

	public static void printAllProfessors(Professor[] professors){
		for(int i = 0; i < professors.length; i++){
			System.out.println((i+1)+". "+professors[i].getName());
		}
	}
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


}

