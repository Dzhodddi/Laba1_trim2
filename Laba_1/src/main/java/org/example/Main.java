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
	private  String [] groups;
	private  String [] students;
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

	private void addStudents(Student [] students) {

	}

}

class Student extends Human {
	private String name;
	// TO-DO variables
	private int year;
	private int group;
	Student(String name, String surname, String middlename, int age, int year) {
		super(name, surname, middlename, age, "Student");
		this.year = year;
	}

	public int getYear() {
		return year;
	}

	public int getGroup() {
		return group;
	}

}

class Cathedra {
	private String name;
	private Professor [] professors;
	private Student [] students;
	Cathedra(String name) {
		this.name = name;
	}

	public void orderedStudentsAlphabetically() {
		Student [] orderedStudents = (Student[]) Utils.quickSortByName(students, 0, students.length - 1);
		System.out.print("Ordered students alphabetically: ");
		for (Student student : students) {
			System.out.println(student);
		}
	}

	public void orderedProfessorsAlphabetically() {
		Professor [] orderedProfessors = (Professor[]) Utils.quickSortByName(professors, 0, professors.length - 1);
		System.out.print("Ordered professors alphabetically: ");
		for (Professor professor : professors) {
			System.out.println(professor);
		}
	}

	public Student [] selectStudentsByYear(int year) {

		int counter = 0;
//		System.out.print("Students that student in year " + year + " : ");
		for (Student student : students) {
			if (student.getYear() == year) {
				System.out.println(student);
				counter++;
			}
		}
		Student [] selectStudentsByYear = new Student[counter];
		counter = 0;
        for (Student student : students) {
            if (student.getYear() == year) {
                selectStudentsByYear[counter] = student;
                counter++;
            }
        }
		return selectStudentsByYear;
	}

	public void orderedStudentsAlphabeticallyInSelectedYear(int year) {
		Student [] orderedStudents = (Student[]) Utils.quickSortByName(selectStudentsByYear(year), 0, students.length - 1);
		System.out.print("Ordered students by name with year " + year + " alphabetically: ");
		for (Student student : students) {
			System.out.println(student);
		}
	}

	public int amountOfStudents() {
		return students.length;
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

