package com.company.automation.fundamentals.main_task;

/*
    3. Вывести заданное количество случайных чисел с переходом и без перехода на новую строку
 */

import java.util.Random;

public class Task03 {
    public static void main(String[] args) {
        Random random = new Random();
        int n = 0;

        if (args.length != 1) {
            System.out.println("Enter one integer number as a command line parameter");
            System.exit(-1);
        } else {
            n = Integer.parseInt(args[0]);
        }

        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = random.nextInt();
        }

        for (int num : numbers) {
            System.out.println(num);
        }

        System.out.println();

        for (int num : numbers) {
            System.out.print(num + " ");
        }
    }
}
