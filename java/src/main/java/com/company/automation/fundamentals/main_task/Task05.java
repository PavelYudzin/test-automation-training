package com.company.automation.fundamentals.main_task;

/*
    5.Ввести число от 1 до 12. Вывести на консоль название месяца, соответствующего данному числу. Осуществить
    проверку корректности ввода чисел.
 */

import java.util.Scanner;

public class Task05 {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        int month;

        do {
            month = inputInteger("Enter number from 1 to 12: >> ");
        }
        while (month < 1 || month > 12);

        switch (month) {
            case 1:
                System.out.println("January");
                break;
            case 2:
                System.out.println("February");
                break;
            case 3:
                System.out.println("March");
                break;
            case 4:
                System.out.println("April");
                break;
            case 5:
                System.out.println("May");
                break;
            case 6:
                System.out.println("June");
                break;
            case 7:
                System.out.println("July");
                break;
            case 8:
                System.out.println("August");
                break;
            case 9:
                System.out.println("September");
                break;
            case 10:
                System.out.println("October");
                break;
            case 11:
                System.out.println("November");
                break;
            case 12:
                System.out.println("December");
                break;
        }
    }

    private static int inputInteger(String message) {
        System.out.print(message);
        while (!in.hasNextInt()) {
            in.next();
            System.out.print(message);
        }

        return in.nextInt();
    }
}