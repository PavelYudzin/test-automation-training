package com.company.automation.collections.main_task;

import com.company.automation.collections.main_task.model.*;

public class Runner {
    public static void main(String[] args) {
        MotorcycleGear helmet = new Helmet("Scorpion EXO", "GT-920", HelmetType.MODULAR, "carbon", "black", 1.6, 219.95);
        MotorcycleGear jacket = new Jacket(Gender.MAN, "Scorpion EXO", "Yosemite", "textile", "black", 3.22, 389.95);
        MotorcycleGear pants = new Pants(Gender.MAN, "Scorpion EXO", "Yosemite", "textile", "black", 1.54, 239.95);
        MotorcycleGear gloves = new Gloves("Scorpion EXO", "Klaw II", GlovesType.SHORT_CUFF, "leather", "black", 0.54, 54.95);
        MotorcycleGear boots = new Boots("Alpinestars", "SMX Plus", BootsType.SPORT, "leather", "black/white", 3.8, 204.53);

        RiderFullEquipment riderFullEquipment = new RiderFullEquipment(helmet, jacket, pants, boots, gloves);

        Menu.startMenu(riderFullEquipment);
    }
}
