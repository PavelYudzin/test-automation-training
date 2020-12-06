package com.company.automation.classes.main_task.logic;

import com.company.automation.classes.main_task.entity.Course;
import com.company.automation.classes.main_task.entity.Faculty;
import com.company.automation.classes.main_task.entity.Student;

public class StudentLogic {
    private final static StudentLogic STUDENT_LOGIC = new StudentLogic();

    private StudentLogic() {
    }

    public static StudentLogic getStudentLogic() {
        return STUDENT_LOGIC;
    }

    public static Student[] getArrayOfStudents(Student... student) {
        return student;
    }

    public Student[] getStudentsBornAfterYear(Student[] students, int year) {
        int n = getArraySizeAfterYear(students, year);
        Student[] studentsBornAfterYear = new Student[n];
        n = 0;
        for (Student student : students) {
            if (student.getBirthDate().getYear() > year) {
                studentsBornAfterYear[n] = student;
                n++;
            }
        }
        return studentsBornAfterYear;
    }

    public Student[] getStudentsOfGroupSortedByFullName(Student[] students, int group) {
        int n = getArraySize(students, group);
        Student[] studentsOfGroup = new Student[n];
        n = 0;
        for (Student student : students) {
            if (student.getGroup() == group) {
                studentsOfGroup[n] = student;
                n++;
            }
        }
        sortByFullName(studentsOfGroup);
        return studentsOfGroup;
    }

    public Student[] getStudentsOfCourse(Student[] students, Course course) {
        int n = getArraySize(students, course);
        Student[] studentsOfCourse = new Student[n];
        n = 0;
        for (Student student : students) {
            if (student.getCourse() == course) {
                studentsOfCourse[n] = student;
                n++;
            }
        }
        return studentsOfCourse;
    }

    public Student[] getStudentsOfFaculty(Student[] students, Faculty faculty) {
        int n = getArraySize(students, faculty);
        Student[] studentsOfFaculty = new Student[n];
        n = 0;
        for (Student student : students) {
            if (student.getFaculty() == faculty) {
                studentsOfFaculty[n] = student;
                n++;
            }
        }
        return studentsOfFaculty;
    }

    public void sortByFullName(Student[] students) {
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = i; j >= 0; j--) {
                if (students[j + 1].getFullName().compareTo(students[j].getFullName()) < 0) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                } else {
                    break;
                }
            }
        }
    }

    private int getArraySizeAfterYear(Student[] students, int year) {
        int n = 0;
        for (Student student : students) {
            if (student.getBirthDate().getYear() > year) {
                n++;
            }
        }
        return n;
    }

    private int getArraySize(Student[] students, int group) {
        int n = 0;
        for (Student student : students) {
            if (student.getGroup() == group) {
                n++;
            }
        }
        return n;
    }

    private int getArraySize(Student[] students, Faculty faculty) {
        int n = 0;
        for (Student student : students) {
            if (student.getFaculty() == faculty) {
                n++;
            }
        }
        return n;
    }

    private int getArraySize(Student[] students, Course course) {
        int n = 0;
        for (Student student : students) {
            if (student.getCourse() == course) {
                n++;
            }
        }
        return n;
    }
}