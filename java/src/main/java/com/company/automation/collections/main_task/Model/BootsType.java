package com.company.automation.collections.main_task.Model;

public enum BootsType {
    SPORT("sport"), CRUISING("cruising"), ADVENTURE("adventure"), STREET("street");

    private String name;

    BootsType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
