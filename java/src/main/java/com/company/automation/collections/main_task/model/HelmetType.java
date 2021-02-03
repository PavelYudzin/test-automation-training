package com.company.automation.collections.main_task.model;

public enum HelmetType {
    FULL_FACE("full face"), MODULAR("modular"), OPEN_FACE("open face");

    private final String name;

    HelmetType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
