package com.company.automation.collections.main_task.Model;

public enum GlovesType {
    FINGERLESS("fingerless"), GAUNTLET("gauntlet"), SHORT_CUFF("short cuff");

    private String name;

    GlovesType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
