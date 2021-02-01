package com.company.automation.collections.optional_task.task06;

/*
    6. 	Ввести строки из файла, записать в список ArrayList. Выполнить сортировку строк, используя метод sort() из класса Collections.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Task06 {
    private static final String PATH_TO_TASK = "src" + File.separator + "main" + File.separator + "java" + File.separator + "com" + File.separator +
            "company" + File.separator + "automation" + File.separator + "collections" + File.separator + "optional_task" + File.separator +
            "Task06" + File.separator;

    public static void main(String[] args) {
        String fileName = "SomeText.txt";
        String file = PATH_TO_TASK.concat(fileName);
        String path = new File(file).getAbsolutePath();

        List<String> arrayListFromFile = getArrayListFromFile(path);
        arrayListFromFile.sort(Comparator.naturalOrder());
        arrayListFromFile.forEach(System.out::println);
    }

    private static List<String> getArrayListFromFile(String path) {
        List<String> listFromFile = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.equals("")) {
                    continue;
                }
                listFromFile.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listFromFile;
    }
}
