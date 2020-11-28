package com.company.automation.classes.main_task;

import com.company.automation.classes.main_task.entity.Course;
import com.company.automation.classes.main_task.entity.Faculty;
import com.company.automation.classes.main_task.entity.Student;
import com.company.automation.classes.main_task.logic.StudentLogic;
import com.company.automation.classes.main_task.view.StudentView;

import java.time.LocalDate;

public class Runner {
    public static void main(String[] args) {

        Student student01 = new Student(321, "Павел", "Юдин", "Игоревич", LocalDate.of(1986, 6,
                23), "Беларусь, г.Витебск, ул. П.Бровки, 23-1-19", "+375(29) 543-29-72", Course.SECOND, 112144,
                Faculty.ENGINEERING);

        Student student02 = new Student(123, "Man", "Iron", "", LocalDate.of(1995, 2,
                13), "USA, Los Angeles", "555-23-44", Course.THIRD, 112154,
                Faculty.ENGINEERING);

        Student student03 = new Student(431, "", "Wolverine", "", LocalDate.of(1991, 12,
                16), "USA, New York", "555-56-84", Course.THIRD, 112154,
                Faculty.ENGINEERING);

        Student student04 = new Student(54, "Man", "Spider", "", LocalDate.of(1983, 8,
                11), "USA, Massachusetts", "555-99-14", Course.FIRST, 114163,
                Faculty.COMPUTER_AIDED_DESIGN);

        Student student05 = new Student(30, "Widow", "Black", "", LocalDate.of(1980, 8,
                25), "Canada, Toronto", "555-91-74", Course.FOURTH, 114167,
                Faculty.COMPUTER_AIDED_DESIGN);

        Student student06 = new Student(91, "Pool", "Dead", "", LocalDate.of(1999, 10,
                25), "Mexico, Mexico", "", Course.FIRST, 115132,
                Faculty.INFORMATION_TECHNOLOGIES);

        Student student07 = new Student(64, "Lisa", "Simpson", "", LocalDate.of(1982, 3,
                17), "USA, Springfield", "555-29-14", Course.SECOND, 122199,
                Faculty.INFO_COMMUNICATION);

        Student student08 = new Student(837, "Bart", "Simpson", "", LocalDate.of(2000, 5,
                16), "USA, Springfield", "555-19-83", Course.THIRD, 123199,
                Faculty.INFO_COMMUNICATION);

        Student student09 = new Student(993, "Homer", "Simpson", "Jay", LocalDate.of(2002, 7,
                28), "USA, Springfield", "555-29-86", Course.SECOND, 122199,
                Faculty.INFO_COMMUNICATION);

        Student student10;
        student10 = new Student(8383, "Little", "Santa's", "Helper", LocalDate.of(2001, 1,
                1), "USA, Springfield", "555-19-83", Course.FIRST, 142199,
                Faculty.INFO_COMMUNICATION);

        Student[] students = StudentLogic.getArrayOfStudents(student01, student02, student03, student04, student05, student06, student07,
                student08, student09, student10);

        StudentView studentView = StudentView.getStudentView();

        studentView.printStudentsOfFaculty(students, Faculty.INFO_COMMUNICATION);

        studentView.printStudentsBornAfterYear(students, 1992);
        studentView.printStudentsBornAfterYear(students, 2005);

        studentView.printStudentsOfGroup(students, 111777);
        studentView.printStudentsOfGroup(students, 122199);

        studentView.printAllFaculties(students);

        studentView.printStudentFullInfo(student01);
        studentView.printStudentFullInfo(student06);
    }
}