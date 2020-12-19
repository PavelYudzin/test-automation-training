package com.company.automation.collections.main_task;

import com.company.automation.collections.main_task.model.MotorcycleGear;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private final List<MotorcycleGear> fullEquipment;
    Scanner input = new Scanner(System.in);

    public Menu(RiderFullEquipment riderFullEquipment) {
        fullEquipment = riderFullEquipment.getFullEquipment();
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
                showEquipment();
                break;
            case 2:
                showFullPrice();
                break;
//            case 3:
//                sortByWeight();
//                break;
//            case 4:
//                findByPriceRange();
//                break;
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
        System.out.print("PRESS ENTER");
        input.nextLine();
        String a = input.nextLine();
        System.out.println();
    }

    private boolean verifyInput(int option, int optionsQuantity) {
        return option >= 0 && option <= optionsQuantity;
    }

    private void showEquipment() {
        fullEquipment.forEach((e) -> System.out.println(e.getDescription() + "\n"));
        pressEnter();
        startMenu();
    }

    private void showFullPrice() {

    }

}
