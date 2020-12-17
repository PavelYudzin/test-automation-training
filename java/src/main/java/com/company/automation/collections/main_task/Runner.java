package com.company.automation.collections.main_task;

import com.company.automation.collections.main_task.Model.*;

public class Runner {
    public static void main(String[] args) {
        MotorcycleGear helmet = new Helmet("LS2", "Assault", HelmetType.FULL_FACE, "carbon", "black", 1.6, 159.98);
        System.out.println(helmet.getDescription());
        System.out.println();

        System.out.println(helmet.toString());
        System.out.println();

        MotorcycleGear jacket = new Jacket(Gender.MAN, "Scorpion EXO", "Yosemite", "textile", "black", 3.22, 389.95);
        System.out.println(jacket.getDescription());
        System.out.println();

        System.out.println(jacket.toString());
        System.out.println();

        MotorcycleGear pants = new Pants(Gender.MAN, "Scorpion EXO", "Yosemite", "textile", "black", 1.54, 239.95);
        System.out.println(pants.getDescription());
        System.out.println();

        System.out.println(pants.toString());


    }
}
