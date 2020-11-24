package com.company.automation.classes.main_task;

public enum Course {
    FIRST(1), SECOND(2), THIRD(3), FOURTH(4), FIFTH(5);

    private final int number;

    private Course(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}