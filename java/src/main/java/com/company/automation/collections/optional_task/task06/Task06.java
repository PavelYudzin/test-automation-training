package com.company.automation.collections.optional_task.task06;

/*
    6. 	Ввести строки из файла, записать в список ArrayList. Выполнить сортировку строк, используя метод sort() из класса Collections.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Task06 {
    private static final String pathToTask = "src\\main\\java\\com\\company\\automation\\collections\\optional_task\\Task06\\";

    public static void main(String[] args) {
        List<String> arrayListFromFile = getArrayListFromFile();
        sortArrayListLexicographically(arrayListFromFile);
        arrayListFromFile.forEach(System.out::println);
    }

    private static List<String> getArrayListFromFile() {
        List<String> listFromFile = new ArrayList<>();
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(pathToTask + "SomeText.txt"));
            String line;

            while ((line = reader.readLine()) != null) {
                listFromFile.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return listFromFile;
    }

    private static void sortArrayListLexicographically(List<String> list) {
        list.sort(String::compareTo);
    }
}
