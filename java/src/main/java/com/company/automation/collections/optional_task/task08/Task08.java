package com.company.automation.collections.optional_task.task08;

/*
    8. 	Задан файл с текстом на английском языке. Выделить все различные слова.
		Слова, отличающиеся только регистром букв, считать одинаковыми. Использовать класс HashSet.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Task08 {
    private static final String PATH = new File("src" + File.separator + "main" + File.separator + "java" + File.separator + "com"
            + File.separator + "company" + File.separator + "automation" + File.separator + "collections" + File.separator
            + "optional_task" + File.separator + "task08" + File.separator + "One_giant_leap_for_mankind.txt").getAbsolutePath();

    public static void main(String[] args) {
        List<String> allUniqueWords = getAllUniqueWords(PATH);
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
        sortedUniqueWords.sort(String::compareTo);
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
