package com.company.automation.collections.optional_task.Task06;

/*
    6. 	Ввести строки из файла, записать в список ArrayList. Выполнить сортировку строк, используя метод sort() из класса Collections.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Task06 {
    private static final String pathToTask = "src\\main\\java\\com\\company\\automation\\collections\\optional_task\\Task06\\";

    public static void main(String[] args) {
        ArrayList<String> arrayListFromFile = getArrayListFromFile();
        sortArrayListLexicographically(arrayListFromFile);
        arrayListFromFile.forEach(System.out::println);
    }

    private static ArrayList<String> getArrayListFromFile() {
        ArrayList<String> listFromFile = new ArrayList<>();
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

    private static void sortArrayListLexicographically(ArrayList<String> list) {
        list.sort(String::compareTo);
    }
}
