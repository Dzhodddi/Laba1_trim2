package org.example;

import java.io.IOException;

public class Tester {
    public static void main(String[] args) throws IOException {
        Cathedra cathedra = createCathedra("FI");

    }


    private static Human createHuman() throws IOException {
        String name = DataInput.getString("Input name: ");
        String surname = DataInput.getString("Input surname: ");
        String middlename = DataInput.getString("Input middle name: ");
        int age = DataInput.getNotNegativeInt("Input age: ");
//        String employment = DataInput.getString("Input employment: ");
        return new Human(name, surname, middlename, age, "");
    }

    private static Student createStudent(String cathedra, String faculty) throws IOException {
        Human human = createHuman();
        int year = DataInput.validateNumber("Input year of student: ", 1, 4);
        int group = DataInput.validateNumber("Input group of student: ", 1, 10);
        return new Student(human.getFirstName(), human.getSurname() , human.getMiddlename(), human.getAge() ,year, group, cathedra, faculty);
    }


    private static Professor createProfessor(String cathedra, String faculty) throws IOException {
        Human human = createHuman();
        return new Professor(human.getFirstName(), human.getSurname() , human.getMiddlename(), human.getAge() , cathedra, faculty);
    }

    private static Cathedra createCathedra(String faculty) throws IOException {
        String name = DataInput.getString("Input cathedra' name: ");
        int amountOfStudents = DataInput.validateNumber("Input amount of students: ", 1, 100);
        int amountOfProfessors = DataInput.validateNumber("Input amount of professors: ", 1, 100);
        Student [] students = new Student[amountOfStudents];
        Professor [] professors = new Professor[amountOfProfessors];
        System.out.println("Set students: ");
        for (int i = 0; i < amountOfStudents; i++) {
            Student student = createStudent(name, faculty);
            students[i] = student;
            System.out.println("Student created");
        }
        System.out.println("Set professors: ");
        for (int i = 0; i < amountOfProfessors; i++) {
            Professor professor = createProfessor(name, faculty);
            professors[i] = professor;
            System.out.println("Professor created");
        }
        return new Cathedra(name, students, professors);
    }
}
