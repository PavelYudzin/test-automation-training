package com.company.automation.collections.optional_task.task01;

/*
    1.   Ввести строки из файла, записать в список. Вывести строки в файл в обратном порядке.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task01 {
    private static final String PATH_TO_TASK = "src" + File.separator + "main" + File.separator + "java" + File.separator + "com" + File.separator +
            "company" + File.separator + "automation" + File.separator + "collections" + File.separator + "optional_task" + File.separator + "Task01" +
            File.separator;

    public static void main(String[] args) {
        String fileName = "Task01_Original.txt";
        String file = PATH_TO_TASK.concat(fileName);
        String path = new File(file).getAbsolutePath();

        List<String> someLines = getArrayListFromFile(path);
        List<String> reverseElementsList = new ArrayList<>(someLines);
        Collections.reverse(reverseElementsList);

        String newFileName = "Task01_Revert.txt";
        String newFile = PATH_TO_TASK.concat(newFileName);
        String newPath = new File(newFile).getAbsolutePath();
        writeArrayListToFile(reverseElementsList, newPath);
    }

    private static List<String> getArrayListFromFile(String path) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    private static void writeArrayListToFile(List<String> list, String path) {
        try (FileWriter writer = new FileWriter(path)) {
            for (String element : list) {
                writer.write(element + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
