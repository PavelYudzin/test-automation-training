package com.company.automation.collections.main_task.Model;

public enum HelmetType {
    FULL_FACE("full face"), MODULAR("modular"), OPEN_FACE("open face");

    private String name;

    HelmetType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
