package com.company.automation.collections.main_task;

import com.company.automation.collections.main_task.Model.*;

import java.util.Arrays;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<MotorcycleGear> riderFullEquipment = Arrays.asList(
                new Helmet("Scorpion EXO", "GT-920", HelmetType.MODULAR, "carbon", "black", 1.6, 219.95),
                new Jacket(Gender.MAN, "Scorpion EXO", "Yosemite", "textile", "black", 3.22, 389.95),
                new Pants(Gender.MAN, "Scorpion EXO", "Yosemite", "textile", "black", 1.54, 239.95),
                new Gloves("Scorpion EXO", "Klaw II", GlovesType.SHORT_CUFF, "leather", "black", 0.54, 54.95),
                new Boots("Alpinestars", "SMX Plus", BootsType.SPORT, "leather", "black/white", 3.8, 204.55)
        );

    }
}
