package com.company.automation.classes.main_task;

/*
Создать классы, спецификации которых приведены ниже. Определить конструкторы и методы setТип(), getТип(), toString().
Определить дополнительно методы в классе, создающем массив объектов. Задать критерий выбора данных и вывести эти данные на консоль.
В каждом классе, обладающем информацией, должно быть объявлено несколько конструкторов.

1. Student: id, Фамилия, Имя, Отчество, Дата рождения, Адрес, Телефон, Факультет, Курс, Группа.
Создать массив объектов. Вывести:
+ a) список студентов заданного факультета;
+ b) списки студентов для каждого факультета и курса;
+ c) список студентов, родившихся после заданного года;
+ d) список учебной группы.

 */

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

    public Student(int id, String firstName, String secondName, String additionalName, int year, int month, int day, String address) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.additionalName = additionalName;
        this.birthDate = LocalDate.of(year, month, day);
        this.address = address;
    }

    public Student(int id, String firstName, String secondName, String additionalName, int year, int month, int day, String address,
                   String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.additionalName = additionalName;
        this.birthDate = LocalDate.of(year, month, day);
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Student(int id, String firstName, String secondName, String additionalName, int year, int month, int day, String address,
                   String phoneNumber, Course course, int group, Faculty faculty) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.additionalName = additionalName;
        this.birthDate = LocalDate.of(year, month, day);
        this.address = address;
        this.phoneNumber = phoneNumber;
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

    public static Student[] getArrayOfStudents(Student... student) {
        return student;
    }

    public String getFullName() {
        return secondName + " " + firstName + " " + additionalName;
    }
}