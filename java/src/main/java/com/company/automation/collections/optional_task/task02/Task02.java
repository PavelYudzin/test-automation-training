package com.company.automation.collections.optional_task.task02;

/*
2.   Ввести число, занести его цифры в стек. Вывести число, у которого цифры идут в обратном порядке.
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Task02 {
    public static void main(String[] args) {
        int number = getInteger();
        System.out.println("\nOriginal integer: " + number);
        int revertInteger = getRevertInteger(number);
        System.out.println("Revert integer: " + revertInteger);

    }

    private static String inputInteger() {
        String line;
        String message = "Input integer number:>> ";
        System.out.print(message);
        Scanner input = new Scanner(System.in);

        while (!input.hasNextInt()) {
            System.out.print(message);
            input.nextLine();
        }

        line = input.nextLine();
        return line;
    }

    private static int getInteger() {
        String line = inputInteger();
        return Integer.parseInt(line);
    }

    private static int getRevertInteger(int number) {
        char[] digits = Integer.toString(number).toCharArray();
        Deque<Character> digitsOfInteger = new ArrayDeque<>();
        
        for (char element : digits) {
            digitsOfInteger.push(element);
        }
        StringBuilder sb = new StringBuilder();

        while (!digitsOfInteger.isEmpty()) {
            sb.append(digitsOfInteger.pop());
        }
        return Integer.parseInt(sb.toString());
    }
}
