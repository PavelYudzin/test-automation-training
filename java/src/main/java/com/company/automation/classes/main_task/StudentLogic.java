package com.company.automation.classes.main_task;

public class StudentLogic {
    private final static StudentLogic studentLogic = new StudentLogic();

    private StudentLogic() {
    }

    public static StudentLogic getStudentLogic() {
        return studentLogic;
    }

    public String getStudentFullInfo(Student student) {
        return "Id: " + student.getId() + ". " + student.getFullName() + ". Birth date: " + student.getBirthDate() +
                "\nAddress: " + student.getAddress() + "\nPhone number: " + student.getPhoneNumber() + "\n" +
                student.getFaculty().getName() + "\n" + student.getCourse().getNumber() + " course. Group: " + student.getGroup() + "\n";
    }

    public Student[] getStudentsOfGroup(Student[] students, int group) {
        int n = getArraySize(students, group);
        Student[] studentsOfGroup = new Student[n];
        n = 0;
        for (Student item : students) {
            if (item.getGroup() == group) {
                studentsOfGroup[n] = item;
                n++;
            }
        }
        sortByFullName(studentsOfGroup);
        return studentsOfGroup;
    }

    public Student[] getStudentsOfFaculty(Student[] students, Faculty faculty) {
        int n = getArraySize(students, faculty);
        Student[] studentsOfFaculty = new Student[n];
        n = 0;
        for (Student item : students) {
            if (item.getFaculty() == faculty) {
                studentsOfFaculty[n] = item;
                n++;
            }
        }
        return studentsOfFaculty;
    }

    public Student[] getStudentsOfCourse(Student[] students, Course course) {
        int n = getArraySize(students, course);
        Student[] studentsOfCourse = new Student[n];
        n = 0;
        for (Student item : students) {
            if (item.getCourse() == course) {
                studentsOfCourse[n] = item;
                n++;
            }
        }
        return studentsOfCourse;
    }

    public void sortByFullName(Student[] students) {
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = i; j >= 0; j--) {
                if (students[j + 1].getFullName().compareTo(students[j].getFullName()) < 0) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
    }

    private int getArraySize(Student[] students, int group) {
        int n = 0;
        for (Student item : students) {
            if (item.getGroup() == group) {
                n++;
            }
        }
        return n;
    }

    private int getArraySize(Student[] students, Faculty faculty) {
        int n = 0;
        for (Student item : students) {
            if (item.getFaculty() == faculty) {
                n++;
            }
        }
        return n;
    }

    private int getArraySize(Student[] students, Course course) {
        int n = 0;
        for (Student item : students) {
            if (item.getCourse() == course) {
                n++;
            }
        }
        return n;
    }
}