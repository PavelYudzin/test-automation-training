package com.company.automation.classes.main_task.entity;

import java.time.LocalDate;

public class Student {
    private int id;
    private String firstName;
    private String secondName;
    private String additionalName;
    private LocalDate birthDate;
    private String address;
    private String phoneNumber = "";
    private int group;
    private Course course;
    private Faculty faculty;

    public Student(int id, String firstName, String secondName, String additionalName, LocalDate birthDate, String address) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.additionalName = additionalName;
        this.birthDate = birthDate;
        this.address = address;
    }

    public Student(int id, String firstName, String secondName, String additionalName, LocalDate birthDate, String address,
                   String phoneNumber) {
        this(id, firstName, secondName, additionalName, birthDate, address);
        this.phoneNumber = phoneNumber;
    }

    public Student(int id, String firstName, String secondName, String additionalName, LocalDate birthDate, String address,
                   String phoneNumber, Course course, int group, Faculty faculty) {
        this(id, firstName, secondName, additionalName, birthDate, address, phoneNumber);
        this.course = course;
        this.group = group;
        this.faculty = faculty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getAdditionalName() {
        return additionalName;
    }

    public void setAdditionalName(String additionalName) {
        this.additionalName = additionalName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(int year, int month, int day) {
        this.birthDate = LocalDate.of(year, month, day);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", additionalName='" + additionalName + '\'' +
                ", birthDate=" + birthDate +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", course=" + course +
                ", group=" + group +
                ", faculty=" + faculty +
                '}';
    }

    public String getFullName() {
        return secondName + " " + firstName + " " + additionalName;
    }

    public String getStudentFullInfo() {
        return "Id: " + id + ". " + getFullName() + ". Birth date: " + birthDate +
                "\nAddress: " + address + "\nPhone number: " + phoneNumber + "\n" +
                faculty.getName() + "\n" + course.getNumber() + " course. Group: " + group + "\n";
    }
}