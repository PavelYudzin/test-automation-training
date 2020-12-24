package com.company.automation.collections.optional_task.task05;

/*
    5. 	Не используя вспомогательных объектов, переставить отрицательные элементы данного списка в конец, а положительные — в начало списка.
 */

import java.util.*;

public class Task05 {
    public static void main(String[] args) {
        List<Double> listOfNumbers = Arrays.asList(4.2, -12.65, 24.4, 132.55, -5.47, 213.7, 2.12, 88.2, 34.3, -34.112, 34d);
        System.out.println("Original list: " + listOfNumbers + "\n");
        listOfNumbers.sort(Comparator.reverseOrder());
        System.out.println("Modified list: " + listOfNumbers);
    }
}
