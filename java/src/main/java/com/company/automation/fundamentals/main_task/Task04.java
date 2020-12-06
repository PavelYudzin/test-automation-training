package com.company.automation.fundamentals.main_task;

/*
    4.Ввести целые числа как аргументы командной строки, подсчитать их сумму (произведение) и вывести результат на
    консоль.
 */

public class Task04 {
    public static void main(String[] args) {
        int sum;
        int multiply;

        sum = getSum(args);
        multiply = multiply(args);

        for (String val : args) {
            System.out.print(val + "  ");
        }

        System.out.println("\nsum = " + sum);
        System.out.println("multiply = " + multiply);
    }

    private static int getSum(String[] args) {
        int sum = 0;

        for (String val : args) {
            sum += Integer.parseInt(val);
        }

        return sum;
    }

    private static int multiply(String[] args) {
        int multiply = 1;

        if (args.length == 0) {
            multiply = 0;
        }

        for (String val : args) {
            multiply *= Integer.parseInt(val);
        }

        return multiply;
    }
}