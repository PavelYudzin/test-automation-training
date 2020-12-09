package com.company.automation.collections.optional_task.task01;

/*
    1.   Ввести строки из файла, записать в список. Вывести строки в файл в обратном порядке.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task01 {
    private static final String pathToTask = "src\\main\\java\\com\\company\\automation\\collections\\optional_task\\Task01\\";

    public static void main(String[] args) {
        List<String> someLines = getArrayListFromFile();
        System.out.println(someLines);
        List<String> revertListElements = new ArrayList<>(someLines);
        Collections.reverse(revertListElements);
        writeArrayListToFile(revertListElements);
    }

    private static List<String> getArrayListFromFile() {
        List<String> lines = new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(pathToTask + "Task01_Original.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return lines;
    }

    private static void writeArrayListToFile(List<String> list) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(pathToTask + "Task01_Revert.txt");
            for (String element : list) {
                writer.write(element + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
