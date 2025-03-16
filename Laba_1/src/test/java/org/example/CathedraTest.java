package org.example;



public class CathedraTest  {
    public static void main(String[] args) {
        Student studentA = new Student("a", "d", "d", 12, 4, 2, "Meth", "FI");
        Student studentB = new Student("b", "d", "d", 12, 4, 2, "Meth", "FI");
        Student studentC = new Student("c", "d", "d", 12, 3, 2, "Meth", "FI");
        Professor ProfessorA = new Professor("a", "d", "d", 12,  "Meth", "FI");
        Professor ProfessorB = new Professor("b", "d", "d", 12, "Meth", "FI");
        Professor ProfessorC = new Professor("c", "d", "d", 12, "Meth", "FI");
        Student [] students = new Student[]{studentA, studentB, studentC, studentA};
        Professor [] professors = new Professor[]{ProfessorA, ProfessorB, ProfessorC};
        Cathedra cathedra = new Cathedra("Meth", students, professors);
        Cathedra cathedra1 = new Cathedra("PE", students, professors);
        Faculty faculty = new Faculty("FI", new Cathedra[]{cathedra, cathedra1});
        faculty.showCathedraeList();
        for (Professor student : faculty.allFacultyProfessors()) {
            System.out.println(student);
        }
        System.out.println("CHANGING");
        cathedra1.editedProfessor("a d", new Professor("YA CHANGED", "", "", 45, "MEth", "FI"));
        cathedra.deletedStudents("a d");
        cathedra.deletedStudents("a d");
        cathedra.deletedStudents("a t");
        cathedra1.deletedStudents("a d");
        for (Professor student : faculty.allFacultyProfessors()) {
            System.out.println(student);
        }
        System.out.println(".");
        for (Student student : faculty.allFacultyStudents()) {
            System.out.println(student);
        }

        cathedra.editedStudent("b d", new Student("а", "а", "q", 18, 2, 6, "MEth", "FI"));
        cathedra.editedStudent("c d", new Student("а", "б", "q", 18, 2, 6, "MEth", "FI"));
        System.out.println("EDITED");
        for (Student student : faculty.allFacultyStudents()) {
            System.out.println(student);
        }
        cathedra.orderedStudentsAlphabetically();
        System.out.println("f");
        cathedra1.orderedStudentsAlphabetically();
        System.out.println("ї".compareTo("ґ"));
    }
}