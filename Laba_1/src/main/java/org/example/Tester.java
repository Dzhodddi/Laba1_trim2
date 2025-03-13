package org.example;

import java.io.IOException;
// test giy
public class Tester {
    public static void main(String[] args) throws IOException {
        //Cathedra cathedra = new Cathedra();
        int amountOfStudents = 0;//лічильник чи обмеження?
        int amountOfProfessors = 0;//лічильник чи обмеження?
        Student student [] = new Student[amountOfStudents];
        Professor professor[] = new Professor[amountOfProfessors];

        int a = DataInput.getInt("Start?(0/1) ");
        while(a != 0 && a != 1){
            a = DataInput.getInt("Try again, start?(0/1) ");
        }
        if(a == 0){
            System.out.println("The program is finished.");
            return;
        }

        String universityName = DataInput.getString("Write down a University name: ");
        //University university = new University(universityName);
        System.out.println("\n\t** created new University called \""+universityName+"\" **");

        while(true){

            showOptions();
            a = DataInput.getInt("Choose an option:(1-10) ");
            while(a < 1 || a > 10){
                a = DataInput.getInt("Try again, choose an option:(1-10) ");
            }
            switch(a){
                case 1:
                    System.out.println("\nOptions:" +
                            "\n\t1 - створити факультет " +
                            "\n\t2 - видалити факультет" +
                            "\n\t3 - редагувати факультет");
                    a = DataInput.getInt("Choose an option:(1-3) ");
                    while(a < 1 || a > 3){
                        a = DataInput.getInt("Try again, choose an option:(1-3) ");
                    }
                    switch(a){
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                    }
                    break;
                case 2:
                    System.out.println("\nOptions:" +
                            "\n\t1 - створити кафедру (спеціальність) факультету" +
                            "\n\t2 - видалити кафедру (спеціальність) факультету" +
                            "\n\t3 - редагувати кафедру (спеціальність) факультету");

                    a = DataInput.getInt("Choose an option:(1-3) ");
                    while(a < 1 || a > 3){
                        a = DataInput.getInt("Try again, choose an option:(1-3) ");
                    }
                    switch(a){
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                    }
                    break;
                case 3:
                    a = DataInput.getInt("Student or professor:(0/1) ");
                    while(a != 0 && a != 1){
                        a = DataInput.getInt("Try again, student or professor:(0/1) ");
                    }
                    switch(a){
                        case 1:
                            //Cathedra.showCathedraList();
                            a = DataInput.getInt("Choose an cathedra: ");
//                            while(a < 1 || a > //Cathedra.getAmountOfCathedras){
//                                a = DataInput.getInt("Try again, choose a cathedra: ");
//                            }
                            System.out.println("\nOptions:" +
                                    "\n\t1 - додати студента до кафедри" +
                                    "\n\t2 - видалити студента з кафедри" +
                                    "\n\t3 - редагувати студента на кафедрі");

                            a = DataInput.getInt("Choose an option:(1-3) ");
                            while(a < 1 || a > 3){
                                a = DataInput.getInt("Try again, choose an option:(1-3) ");
                            }
                            switch(a){
                                case 1:
                                    break;
                                case 2:
                                    break;
                                case 3:
                                    break;
                            }
                            break;
                        case 2:
                            //Cathedra.showCathedraList();
                            a = DataInput.getInt("Choose an cathedra: ");
//                            while(a < 1 || a > //Cathedra.getAmountOfCathedras){
//                                a = DataInput.getInt("Try again, choose a cathedra: ");
//                            }
                            System.out.println("\nOptions:" +
                                    "\n\t1 - додати викладача до кафедри" +
                                    "\n\t2 - видалити викладача з кафедри" +
                                    "\n\t3 - редагувати викладачі на кафедрі");

                            a = DataInput.getInt("Choose an option:(1-3) ");
                            while(a < 1 || a > 3){
                                a = DataInput.getInt("Try again, choose an option:(1-3) ");
                            }
                            switch(a){
                                case 1:
                                    break;
                                case 2:
                                    break;
                                case 3:
                                    break;
                            }
                            break;
                    }
                    break;
                case 4:
                    a = DataInput.getInt("Student or professor:(0/1) ");
                    while(a != 0 && a != 1){
                        a = DataInput.getInt("Try again, student or professor:(0/1) ");
                    }
                    switch(a){
                        case 1:
                            break;
                        case 2:
                            break;
                    }
                    break;
                case 5:
                    break;
                case 6:
                    a = DataInput.getInt("Student or professor:(0/1) ");
                    while(a != 0 && a != 1){
                        a = DataInput.getInt("Try again, student or professor:(0/1) ");
                    }
                    switch(a){
                        case 1:
                            break;
                        case 2:
                            break;
                    }
                    break;
                case 7:
                    break;
                case 8:
                    a = DataInput.getInt("Student or professor:(0/1) ");
                    while(a != 0 && a != 1){
                        a = DataInput.getInt("Try again, student or professor:(0/1) ");
                    }
                    switch(a){
                        case 1:
                            break;
                        case 2:
                            break;
                    }
                    break;
                case 9:
                    //choose course
                    //all students
                    break;
                case 10:
                    //Cathedra.showCathedraList
                    //choose cathedra
                    //alphabetical students
                    break;
            }



            a = DataInput.getInt("Continue?(0/1) ");
            while(a != 0 && a != 1){
                a = DataInput.getInt("Try again, continue?(0/1) ");
            }
            if(a == 0){
                System.out.println("The program is finished.");
                return;
            }
        }

    }
    private static void showOptions(){
        System.out.println("\nOptions:" +
                "\n\t1. Створити/видалити/редагувати факультет " +
                "\n\t2. Створити/видалити/редагувати кафедру факультета " +
                "\n\t3. Додати/видалити/редагувати студента/викладача до кафедри " +
                "\n\t4. Знайти студента/викладача за ПІБ, курсом або групою " +
                "\n\t5. Вивести всіх студентів впорядкованих за курсами" +
                "\n\t6. Вивести всіх студентів/викладачів факультета впорядкованих за алфавітом " +
                "\n\t7. Вивести всіх студентів кафедри впорядкованих за курсами " +
                "\n\t8. Вивести всіх студентів/викладачів кафедри впорядкованих за алфавітом" +
                "\n\t9. Вивести всіх студентів кафедри вказаного курсу " +
                "\n\t10. Вивести всіх студентів кафедри вказаного курсу впорядкованих за алфавітом");
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

