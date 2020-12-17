package com.company.automation.collections.main_task;

import com.company.automation.collections.main_task.Model.MotorcycleGear;

import java.util.List;

public class RiderFullEquipment {
    private List<? extends MotorcycleGear> riderFullEquipment;

    public RiderFullEquipment(List<? extends MotorcycleGear> riderFullEquipment) {
        this.riderFullEquipment = riderFullEquipment;
    }

    public List<? extends MotorcycleGear> getRiderFullEquipment() {
        return riderFullEquipment;
    }
}
