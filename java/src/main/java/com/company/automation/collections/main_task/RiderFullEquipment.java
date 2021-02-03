package com.company.automation.collections.main_task;

import com.company.automation.collections.main_task.model.GearType;
import com.company.automation.collections.main_task.model.MotorcycleGear;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RiderFullEquipment {
    private final EnumMap<GearType, MotorcycleGear> fullEquipment = new EnumMap<>(GearType.class);

    public RiderFullEquipment() {
    }

    public RiderFullEquipment(MotorcycleGear... motorcycleGears) {
        this.addGear(motorcycleGears);
    }

    public EnumMap<GearType, MotorcycleGear> getFullEquipment() {
        return fullEquipment;
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

    public List<MotorcycleGear> findByPriceRange(double from, double to) {
        List<MotorcycleGear> matches = new ArrayList<>();

        while (iterator.hasNext()) {
            MotorcycleGear current = iterator.next().getValue();
            double price = current.getPrice();
            if (price >= from && price <= to) {
                matches.add(current);
            }
        }
        resetIterator();
        sortByPrice(matches);
        return matches;
    }

    public List<MotorcycleGear> sortByPrice() {
        List<MotorcycleGear> equipmentSortedByPrice = new ArrayList<>(fullEquipment.values());
        equipmentSortedByPrice.sort(Comparator.comparingDouble(MotorcycleGear::getPrice));
        return equipmentSortedByPrice;
    }

    private void sortByPrice(List<MotorcycleGear> equipment) {
        equipment.sort(Comparator.comparingDouble(MotorcycleGear::getPrice));
    }

    private void resetIterator() {
        iterator = fullEquipment.entrySet().iterator();
    }
}
