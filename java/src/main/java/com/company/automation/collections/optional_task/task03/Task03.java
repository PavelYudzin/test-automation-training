package com.company.automation.collections.optional_task.task03;

/*
    3.  Создать список из элементов каталога и его подкаталогов.
 */

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Task03 {
    private static final String PATH = new File("src" + File.separator + "main" + File.separator + "java" + File.separator + "com"
            + File.separator + "company" + File.separator + "automation" + File.separator + "collections" + File.separator
            + "optional_task" + File.separator + "task03" + File.separator + "directory").getAbsolutePath();

    public static void main(String[] args) {
        List<String> directoryContent =  getDirectoryContent(PATH);
        directoryContent.forEach(System.out::println);
    }

    private static List<String> getDirectoryContent(String absolutePath) {
        List<String> directoryContent = new ArrayList<>();
        File dir = new File(absolutePath);
        File[] files = dir.listFiles();

        for (File file : files) {
            if (file.isDirectory()) {
                directoryContent.add(file.getName());
            }
        }

        for (File file : files) {
            if (file.isFile()) {
                directoryContent.add(file.getName());
            }
        }
        return directoryContent;
    }
}

