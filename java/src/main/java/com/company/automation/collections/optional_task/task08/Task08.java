package com.company.automation.collections.optional_task.task08;

/*
    8. 	Задан файл с текстом на английском языке. Выделить все различные слова.
		Слова, отличающиеся только регистром букв, считать одинаковыми. Использовать класс HashSet.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Task08 {
    private static final String PATH_TO_TASK = "src" + File.separator + "main" + File.separator + "java" + File.separator + "com"
            + File.separator + "company" + File.separator + "automation" + File.separator + "collections" + File.separator
            + "optional_task" + File.separator + "task08" + File.separator;

    public static void main(String[] args) {
        String fileName = "One_giant_leap_for_mankind.txt";
        String file = PATH_TO_TASK.concat(fileName);
        List<String> allUniqueWords = getAllUniqueWords(file);
        System.out.println("All unique words: " + allUniqueWords.size());
        allUniqueWords.forEach(System.out::println);
    }

    private static List<String> getAllUniqueWords(String path) {
        String allWords = getTextFromFile(path);
        allWords = removeAllRedundantSymbols(allWords).toLowerCase();
        String[] arrayOfAllWords = allWords.split("\\s+");

        Set<String> allUniqueWords;
        allUniqueWords = new HashSet<>(Arrays.asList(arrayOfAllWords));
        List<String> sortedUniqueWords = new ArrayList<>(allUniqueWords);
        sortedUniqueWords.sort(Comparator.naturalOrder());
        return sortedUniqueWords;
    }

    private static String getTextFromFile(String path) {
        File file = new File(path);
        String fileContent = "";

        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                fileContent = fileContent.concat(scan.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return fileContent;
    }

    private static String removeAllRedundantSymbols(String text) {
        text = text.replaceAll("\\d\\w+", " ")
                .replaceAll("\\W", " ")
                .replaceAll("\\d", " ");
        return text;
    }
}
