package com.company.automation.collections.optional_task.task03;

/*
    3.  Создать список из элементов каталога и его подкаталогов.
 */

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class Task03 {
    private static final String PATH_TO_TASK = "src" + File.separator + "main" + File.separator + "java" + File.separator + "com"
            + File.separator + "company" + File.separator + "automation" + File.separator + "collections" + File.separator
            + "optional_task" + File.separator + "task03" + File.separator + "directory";
    private static final String ABSOLUTE_PATH = new File(PATH_TO_TASK).getAbsolutePath();

    public static void main(String[] args) {
        List<String> directoryContent = getDirectoryContent(ABSOLUTE_PATH);
        directoryContent.forEach(System.out::println);
    }

    private static List<String> getDirectoryContent(String path) {
        LinkedList<String> directoryContent = new LinkedList<>();
        File dir = new File(path);
        File[] files = dir.listFiles();

        for (File file : files) {
            if (file.isDirectory()) {
                directoryContent.addFirst(file.getName());
            } else if (file.isFile()) {
                directoryContent.addLast(file.getName());
            }
        }
        return directoryContent;
    }
}
