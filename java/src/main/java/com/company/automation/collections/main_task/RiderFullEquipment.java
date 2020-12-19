package com.company.automation.collections.main_task;

import com.company.automation.collections.main_task.model.GearType;
import com.company.automation.collections.main_task.model.MotorcycleGear;

import java.util.*;

public class RiderFullEquipment {
    private final EnumMap<GearType, MotorcycleGear> fullEquipment = new EnumMap<>(GearType.class);

    public RiderFullEquipment() {
    }

    public RiderFullEquipment(MotorcycleGear... motorcycleGears) {
        this.addGear(motorcycleGears);
    }

    public List<MotorcycleGear> getFullEquipment() {
        return new ArrayList<>(fullEquipment.values());
    }

    public void addGear(MotorcycleGear... motorcycleGear) {
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
    }

    Iterator<Map.Entry<GearType, MotorcycleGear>> iterator = fullEquipment.entrySet().iterator();

    public double getFullPrice() {
        double fullPrice = 0;

        while (iterator.hasNext()) {
            fullPrice += iterator.next().getValue().getPrice();
        }
        resetIterator();
        return fullPrice;
    }

    public List<MotorcycleGear> sortByWeight() {
        List<MotorcycleGear> equipmentSortedByWeight = new ArrayList<>(fullEquipment.values());
        equipmentSortedByWeight.sort(Comparator.comparingDouble(MotorcycleGear::getWeight));
        return equipmentSortedByWeight;
    }

    public List<MotorcycleGear> findByPrice(double from, double to) {
        List<MotorcycleGear> matches = new ArrayList<>();

        while (iterator.hasNext()) {
            MotorcycleGear current = iterator.next().getValue();
            double price = current.getPrice();
            if (price >= from && price <= to) {
                matches.add(current);
            }
        }
        resetIterator();
        return matches;
    }

    private void resetIterator() {
        iterator = fullEquipment.entrySet().iterator();
    }
}
