package com.company.automation.collections.main_task.view;

import com.company.automation.collections.main_task.RiderFullEquipment;
import com.company.automation.collections.main_task.model.MotorcycleGear;

import java.util.ArrayList;
import java.util.List;

public class EquipmentView {
    public static void printEquipment(RiderFullEquipment riderFullEquipment) {
        List<MotorcycleGear> fullEquipment = new ArrayList<>(riderFullEquipment.getFullEquipment().values());
        fullEquipment.forEach((e) -> System.out.printf("%s%n----------%n", e.getDescription()));
    }

    public static void printFullPrice(RiderFullEquipment riderFullEquipment) {
        List<MotorcycleGear> fullEquipment = new ArrayList<>(riderFullEquipment.getFullEquipment().values());
        System.out.println("Full price");
        System.out.println("----------");
        fullEquipment.forEach((e) -> System.out.printf("%-50s %10.2f$%n", e.getFullName(), e.getPrice()));
        System.out.printf("%43s ------------------%n", "");
        System.out.printf("%50s %10.2f$%n", "TOTAL:", riderFullEquipment.getFullPrice());
    }

    public static void printSortedByWeight(RiderFullEquipment riderFullEquipment) {
        List<MotorcycleGear> sortedByWeight = riderFullEquipment.sortByWeight();
        System.out.println("Sorted by weight");
        System.out.println("----------------");
        sortedByWeight.forEach((e) -> System.out.printf("%-50s %10.3f kg%n", e.getFullName(), e.getWeight()));
    }

    public static void printSortedByPriceRange(RiderFullEquipment riderFullEquipment, double from, double to) {

        System.out.println("\n$" + from + " - " + to);
        List<MotorcycleGear> suitableEquipment = riderFullEquipment.findByPriceRange(from, to);

        if (suitableEquipment.size() != 0) {
            suitableEquipment.forEach((e) -> System.out.printf("%-50s %10.2f$%n", e.getFullName(), e.getPrice()));
        } else {
            System.out.println("There are no gears in this range");
        }
    }
}
