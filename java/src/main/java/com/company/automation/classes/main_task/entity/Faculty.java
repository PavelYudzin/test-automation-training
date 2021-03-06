package com.company.automation.classes.main_task.entity;

public enum Faculty {
    COMPUTER_AIDED_DESIGN("FACULTY OF COMPUTER-AIDED DESIGN"),
    INFORMATION_TECHNOLOGIES("FACULTY OF INFORMATION TECHNOLOGIES AND CONTROL"),
    RADIO_ENGINEERING("FACULTY OF RADIO ENGINEERING AND ELECTRONICS"),
    COMPUTER_SYSTEMS("FACULTY OF COMPUTER SYSTEMS AND NETWORKS"),
    INFO_COMMUNICATION("FACULTY OF INFORMATION COMMUNICATION"),
    ENGINEERING("FACULTY OF ENGINEERING AND ECONOMICS");

    private final String name;

    Faculty(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}