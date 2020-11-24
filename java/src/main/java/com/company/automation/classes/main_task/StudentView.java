package com.company.automation.classes.main_task;

public class StudentView {
    private final StudentLogic studentLogic = StudentLogic.getStudentLogic();
    private static final StudentView studentView = new StudentView();

    private StudentView() {
    }

    public static StudentView getStudentView() {
        return studentView;
    }


    public void printStudentsOfGroup(Student[] students, int group) {
        int i = 1;
        Student[] studentsOfGroup = studentLogic.getStudentsOfGroup(students, group);
        System.out.println("Group " + group + ":");
        if (studentsOfGroup.length != 0) {
            for (Student item : studentsOfGroup) {
                System.out.println(i + ". " + item.getFullName());
                i++;
            }
        } else {
            System.out.println("Group doesn't exist");
        }
        System.out.println();
    }

    public void printStudentsWhoWereBornAfterYear(Student[] students, int year) {
        boolean hasYoungerStudents = false;
        int i = 1;
        System.out.println("Students who were born after year " + year + ":");
        for (Student item : students) {
            if (item.getBirthDate().getYear() > year) {
                hasYoungerStudents = true;
                System.out.println(i + ". " + item.getFullName() + " (" + item.getBirthDate().getYear() + ")");
                i++;
            }
        }
        if (!hasYoungerStudents) {
            System.out.println("All of the students were born before year " + year);
        }
        System.out.println();
    }

    public void printStudentsOfFaculty(Student[] students, Faculty faculty) {
        Student[] studentsOfFaculty = studentLogic.getStudentsOfFaculty(students, faculty);
        System.out.println(faculty.getName());
        for (Course item : Course.values()) {
            Student[] studentsOfCourse = studentLogic.getStudentsOfCourse(studentsOfFaculty, item);
            printStudentsOfCourse(studentsOfCourse, item);
        }
        System.out.println("------------------------------------");
        System.out.println();
    }

    public void printAllFaculties(Student[] students) {
        System.out.println("------------------------------------\n" +
                "          ALL FACULTIES" +
                "\n------------------------------------");
        for (Faculty item : Faculty.values()) {
            printStudentsOfFaculty(students, item);
        }
    }

    private void printStudentsOfCourse(Student[] students, Course course) {
        if (students.length != 0) {
            System.out.println("        " + course.getNumber() + " course: ");
            int i = 1;
            for (Student item : students) {
                System.out.println(i + ". " + item.getFullName() + " (group: " + item.getGroup() + ")");
                i++;
            }
        }
    }

    public void printStudentFullInfo(Student student) {
        System.out.println(studentLogic.getStudentFullInfo(student));
    }
}