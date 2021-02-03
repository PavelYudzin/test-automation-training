package com.company.automation.collections.main_task;

import com.company.automation.collections.main_task.verification.MenuVerification;
import com.company.automation.collections.main_task.view.EquipmentView;

import java.util.Scanner;

public class Menu {
    private static final Scanner input = new Scanner(System.in);

    public static void startMenu(RiderFullEquipment riderFullEquipment) {
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
        } while (!MenuVerification.verifyInput(option, optionsQuantity));
        System.out.println();

        switch (option) {
            case 1:
                showEquipmentOption(riderFullEquipment);
                break;
            case 2:
                showFullPriceOption(riderFullEquipment);
                break;
            case 3:
                sortByWeightOption(riderFullEquipment);
                break;
            case 4:
                findByPriceRange(riderFullEquipment);
                break;
            case 0:
                System.exit(0);
        }
    }

    private static int input(String message) {
        System.out.print(message);
        while (!input.hasNextInt()) {
            System.out.print(message);
            input.next();
        }
        return Integer.parseInt(input.next());
    }

    private static void pressEnter() {
        System.out.println();
        System.out.print("PRESS ENTER: >> ");
        input.nextLine();
        String a = input.nextLine();
        System.out.println();
    }

    private static void showEquipmentOption(RiderFullEquipment riderFullEquipment) {
        EquipmentView.printEquipment(riderFullEquipment);
        pressEnter();
        startMenu(riderFullEquipment);
    }

    private static void showFullPriceOption(RiderFullEquipment riderFullEquipment) {
        EquipmentView.printFullPrice(riderFullEquipment);
        pressEnter();
        startMenu(riderFullEquipment);
    }

    private static void sortByWeightOption(RiderFullEquipment riderFullEquipment) {
        EquipmentView.printSortedByWeight(riderFullEquipment);
        pressEnter();
        startMenu(riderFullEquipment);
    }

    private static void findByPriceRange(RiderFullEquipment riderFullEquipment) {
        int from;
        int to;
        String messageFrom = "Input MIN price(integer number): >> ";
        String messageTo = "Input MAX price(integer number): >> ";

        do {
            from = input(messageFrom);
            to = input(messageTo);
        } while (!MenuVerification.verifyPriceRange(from, to));

        EquipmentView.printSortedByPriceRange(riderFullEquipment, from, to);

        pressEnter();
        startMenu(riderFullEquipment);
    }
}
