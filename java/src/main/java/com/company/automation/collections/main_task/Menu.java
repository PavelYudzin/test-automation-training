package com.company.automation.collections.main_task;

import com.company.automation.collections.main_task.model.MotorcycleGear;

import java.util.*;

public class Menu {
    private final RiderFullEquipment riderFullEquipment;
    private final List<MotorcycleGear> fullEquipment = new ArrayList<>();
    private final Scanner input = new Scanner(System.in);


    public Menu(RiderFullEquipment riderFullEquipment) {
        this.riderFullEquipment = riderFullEquipment;
        fullEquipment.addAll(riderFullEquipment.getFullEquipment().values());
    }

    public void startMenu() {
        String message = "Choose option: >> ";
        int option;
        int optionsQuantity = 4;

        System.out.println("-----------------------");
        System.out.println("1. Show equipment");
        System.out.println("2. Show full price");
        System.out.println("3. Sort by weight");
        System.out.println("4. Find by price range");
        System.out.println("0. Exit");
        System.out.println("-----------------------");
        System.out.println();

        do {
            option = input(message);
        } while (!verifyInput(option, optionsQuantity));
        System.out.println();

        switch (option) {
            case 1:
                showEquipmentMenu();
                break;
            case 2:
                showFullPriceMenu();
                break;
            case 3:
                sortByWeightMenu();
                break;
            case 4:
                findByPriceRange();
                break;
            case 0:
                System.exit(0);
        }
    }

    private int input(String message) {
        System.out.print(message);
        while (!input.hasNextInt()) {
            System.out.print(message);
            input.next();
        }
        return Integer.parseInt(input.next());
    }

    private void pressEnter() {
        System.out.println();
        System.out.print("PRESS ENTER: >> ");
        input.nextLine();
        String a = input.nextLine();
        System.out.println();
    }

    private boolean verifyInput(int option, int optionsQuantity) {
        return option >= 0 && option <= optionsQuantity;
    }

    private void showEquipmentMenu() {
        fullEquipment.forEach((e) -> System.out.printf("%s%n----------%n", e.getDescription()));
        pressEnter();
        startMenu();
    }

    private void showFullPriceMenu() {
        System.out.println("Full price");
        System.out.println("----------");
        fullEquipment.forEach((e) -> System.out.printf("%-50s %10.2f$%n", e.getFullName(), e.getPrice()));
        System.out.printf("%43s ------------------%n", "");
        System.out.printf("%50s %10.2f$%n", "TOTAL:", riderFullEquipment.getFullPrice());
        pressEnter();
        startMenu();
    }

    private void sortByWeightMenu() {
        List<MotorcycleGear> sortedByWeight = riderFullEquipment.sortByWeight();
        System.out.println("Sorted by weight");
        System.out.println("----------------");
        sortedByWeight.forEach((e) -> System.out.printf("%-50s %10.3f kg%n", e.getFullName(), e.getWeight()));
        pressEnter();
        startMenu();
    }

    private void findByPriceRange() {
        int from;
        int to;
        String messageFrom = "Input MIN price(integer number): >> ";
        String messageTo = "Input MAX price(integer number): >> ";

        do {
            from = input(messageFrom);
            to = input(messageTo);
        } while (!verifyPrice(from, to));

        System.out.println("\n$" + from + " - " + to);
        List<MotorcycleGear> suitableEquipment = riderFullEquipment.findByPriceRange(from, to);

        if (suitableEquipment.size() != 0) {
            suitableEquipment.sort(Comparator.comparingDouble(MotorcycleGear::getPrice));
            suitableEquipment.forEach((e) -> System.out.printf("%-50s %10.2f$%n", e.getFullName(), e.getPrice()));
        } else {
            System.out.println("There are no gears in this range");
        }
        pressEnter();
        startMenu();
    }

    private boolean verifyPrice(int from, int to) {
        boolean verification = (from >= 0 && to >= 0) && (from <= to);
        if (!verification) {
            System.out.println("\nWRONG price range!!!\n");
        }
        return verification;
    }
}
