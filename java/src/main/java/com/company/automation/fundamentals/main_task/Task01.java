package com.company.automation.fundamentals.main_task;

/*
    1. Приветствовать любого пользователя при вводе его имени через командную строку.
 */

public class Task01 {
    public static void main(String[] args) {
        System.out.print("Hello ");
        for (int i = 0; i < args.length; i++) {
            System.out.print(args[i] + " ");
        }
    }
}