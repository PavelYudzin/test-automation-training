package com.company.automation.collections.main_task;

import com.company.automation.collections.main_task.Model.Helmet;
import com.company.automation.collections.main_task.Model.HelmetType;
import com.company.automation.collections.main_task.Model.MotorcycleGear;

public class Runner {
    public static void main(String[] args) {
        MotorcycleGear gear = new Helmet("AAA", "COOL", HelmetType.MODULAR, 1.6, 230);
        MotorcycleGear otherGear = new Helmet("BBB", "COOLer", HelmetType.MODULAR, 1.6, 210);
        System.out.println(gear);
        System.out.println(gear.getDescription());
        System.out.println();
        System.out.println(gear.equals(otherGear));

    }
}
