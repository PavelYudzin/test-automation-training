package com.company.automation.classes.main_task.view;

import com.company.automation.classes.main_task.entity.Course;
import com.company.automation.classes.main_task.entity.Faculty;
import com.company.automation.classes.main_task.entity.Student;
import com.company.automation.classes.main_task.logic.StudentLogic;

public class StudentView {
    private final StudentLogic studentLogic = StudentLogic.getStudentLogic();
    private static final StudentView studentView = new StudentView();

    private StudentView() {
    }

    public static StudentView getStudentView() {
        return studentView;
    }

    public void printStudentsOfGroup(Student[] students, int group) {
        Student[] studentsOfGroup = studentLogic.getSortedStudentsOfGroup(students, group);
        System.out.println("Group " + group + ":");
        if (studentsOfGroup.length != 0) {
            for (int i = 0; i < studentsOfGroup.length; i++) {
                System.out.println(i + 1 + ". " + studentsOfGroup[i].getFullName());
            }
        } else {
            System.out.println("Group doesn't exist");
        }
        System.out.println();
    }

    public void printStudentsBornAfterYear(Student[] students, int year) {
        Student[] studentsBornAfterYear = studentLogic.getStudentsBornAfterYear(students, year);
        System.out.println("Students who were born after year " + year + ":");
        if (studentsBornAfterYear.length != 0) {
            for (int i = 0; i < studentsBornAfterYear.length; i++) {
                System.out.println(i + 1 + ". " + studentsBornAfterYear[i].getFullName() + " (" + studentsBornAfterYear[i].getBirthDate().getYear() +
                        ")");
            }
        } else {
            System.out.println("All of the students were born before year " + year);
        }
        System.out.println();
    }

    public void printStudentsOfFaculty(Student[] students, Faculty faculty) {
        Student[] studentsOfFaculty = studentLogic.getStudentsOfFaculty(students, faculty);
        System.out.println(faculty.getName());
        for (Course course : Course.values()) {
            Student[] studentsOfCourse = studentLogic.getStudentsOfCourse(studentsOfFaculty, course);
            printStudentsOfCourse(studentsOfCourse, course);
        }
        System.out.println("------------------------------------");
        System.out.println();
    }

    public void printAllFaculties(Student[] students) {
        System.out.println("------------------------------------\n" +
                "          ALL FACULTIES" +
                "\n------------------------------------");
        for (Faculty faculty : Faculty.values()) {
            printStudentsOfFaculty(students, faculty);
        }
    }

    private void printStudentsOfCourse(Student[] students, Course course) {
        if (students.length != 0) {
            System.out.println("        " + course.getNumber() + " course: ");
            for (int i = 0; i < students.length; i++) {
                System.out.println(i + 1 + ". " + students[i].getFullName() + " (group: " + students[i].getGroup() + ")");
            }
        }
    }

    public void printStudentFullInfo(Student student) {
        System.out.println(student.getStudentFullInfo());
    }
}