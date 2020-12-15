package com.company.automation.collections.main_task;

import com.company.automation.collections.main_task.Model.*;

public class Runner {
    public static void main(String[] args) {
        MotorcycleGear helmet = new Helmet("LS2", "Assault", HelmetType.FULL_FACE, "carbon", "black", 1.6, 159.98);
        System.out.println(helmet.getDescription());
        MotorcycleGear jacket = new Jacket("Scorpion EXO", "Yosemite", "textile", "black", 3.22, 389.95);
        System.out.println(jacket.getDescription());

    }
}
