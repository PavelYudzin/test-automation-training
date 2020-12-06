package com.company.automation.fundamentals.main_task;

/*
    1. Приветствовать любого пользователя при вводе его имени через командную строку.
 */

public class Task01 {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder("Hello, ");
        for (String element : args) {
            stringBuilder.append(element)
                    .append(" ");
        }
        System.out.println(stringBuilder.toString());
    }
}