package com.company.automation.collections.main_task;

import com.company.automation.collections.main_task.Model.GearType;
import com.company.automation.collections.main_task.Model.MotorcycleGear;

import java.util.EnumMap;

public class RiderFullEquipment {
    private EnumMap<GearType, MotorcycleGear> fullEquipment = new EnumMap<GearType, MotorcycleGear>(GearType.class);

    public RiderFullEquipment() {
    }

    public RiderFullEquipment(MotorcycleGear... motorcycleGears) {
        this.addGear(motorcycleGears);
    }

    public EnumMap<GearType, MotorcycleGear> getFullEquipment() {
        return fullEquipment;
    }

    public EnumMap<GearType, MotorcycleGear> addGear(MotorcycleGear... motorcycleGear) {
        for (MotorcycleGear element : motorcycleGear) {

            switch (element.getGearType()) {
                case HELMET:
                    fullEquipment.put(GearType.HELMET, element);
                    break;
                case JACKET:
                    fullEquipment.put(GearType.JACKET, element);
                    break;
                case PANTS:
                    fullEquipment.put(GearType.PANTS, element);
                    break;
                case BOOTS:
                    fullEquipment.put(GearType.BOOTS, element);
                    break;
                case GLOVES:
                    fullEquipment.put(GearType.GLOVES, element);
                    break;
            }
        }
        return fullEquipment;
    }

}
