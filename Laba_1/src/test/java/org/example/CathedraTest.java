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
//        cathedra.orderedStudentsByYear();
//        cathedra.orderedStudentsAlphabeticallyInSelectedYear(4);
//        cathedra.orderedProfessorsAlphabetically();
//        cathedra.orderedStudentsAlphabetically();
//        cathedra.selectStudentsByYear(2);
//        cathedra.addStudent(studentA);
//        cathedra.orderedStudentsAlphabetically();
        cathedra.addStudent(studentA);
        cathedra.addProfessor(ProfessorA);
        cathedra.orderedProfessorsAlphabetically();
        System.out.println("before delete");
        cathedra.printHuman(cathedra.getStudents());
        cathedra.deletedStudents("a d");
        System.out.println("Deleted");
        cathedra.printHuman(cathedra.getStudents());

        System.out.println("before delete");
        cathedra.printHuman(cathedra.getProfessors());
        cathedra.deletedProfessor("d");
        System.out.println("Deleted");
        cathedra.printHuman(cathedra.getProfessors());

        cathedra.editedProfessor("a", new Professor("Dima", "DIma", "Dima", 45, "METH", "FI"));
        cathedra.editedProfessor("a d", new Professor("Dima", "DIma", "Dima", 45, "METH", "FI"));



        System.out.println("before delete");
        cathedra.printHuman(cathedra.getProfessors());
        cathedra.deletedProfessor("a d");
        System.out.println("Deleted");
        cathedra.printHuman(cathedra.getProfessors());

    }
}