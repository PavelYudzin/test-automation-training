package com.company.automation.collections.main_task.model;

public enum BootsType {
    SPORT("sport"), CRUISING("cruising"), ADVENTURE("adventure"), STREET("street");

    private final String name;

    BootsType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
