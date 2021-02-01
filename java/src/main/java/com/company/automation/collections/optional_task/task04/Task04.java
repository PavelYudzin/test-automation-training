package com.company.automation.collections.optional_task.task04;

/*
4.  Занести стихотворение в список. Провести сортировку по возрастанию длин строк.
 */

import java.util.Arrays;
import java.util.List;

public class Task04 {
    public static void main(String[] args) {
        String poem = "Не давай им хлеба из рук,\n" +
                "Не учи их быть сильнее тебя,\n" +
                "Не клади им палец в рот\n" +
                "И не спи при них в открытом поле.\n" +
                "Они могут вдруг стать тобой,\n" +
                "Они могут превратиться в свет,\n" +
                "Они будут ждать начало конца,\n" +
                "Но не жди от них спокойных песен.\n" +
                "А когда кто-то глянет на дверь\n" +
                "И увидит там их,\n" +
                "Мы спасемся за чистые стекла весны,\n" +
                "Мы покинем их, и будем правы.";

        List<String> poemAsList;
        poemAsList = Arrays.asList(poem.split("\n"));
        poemAsList.sort(new StringLengthComparator());
        poemAsList.forEach(System.out::println);
    }
}
