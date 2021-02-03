package com.company.automation.collections.optional_task.task07;

/*
    7. 	Задана строка, состоящая из символов «(», «)», «[», «]», «{», «}». Проверить правильность расстановки скобок. Использовать стек.
 */

import java.util.Stack;

public class Task07 {
    public static void main(String[] args) {
        String correctLine = "public class Task01 {\n" +
                "    public static void main(String[] args) {\n" +
                "        StringBuilder stringBuilder = new StringBuilder(\"Hello, \");\n" +
                "        for (String element : args) {\n" +
                "            stringBuilder.append(element)\n" +
                "                    .append(\" \");\n" +
                "        }\n" +
                "        System.out.println(stringBuilder.toString());\n" +
                "    }\n" +
                "}";
        System.out.println(hasCorrectBrackets(correctLine));
        System.out.println();
        String incorrectLine01 = "){([]){()(){()()}(())}}";
        System.out.println(hasCorrectBrackets(incorrectLine01));
        System.out.println();
        String incorrectLine02 = "{([]){(])(){()()}(())}}";
        System.out.println(hasCorrectBrackets(incorrectLine02));
        System.out.println();
        String incorrectLine03 = "{([]){()(){()()}(())}}(";
        System.out.println(hasCorrectBrackets(incorrectLine03));
    }

    private static boolean hasCorrectBrackets(String line) {
        line = line.replaceAll("[^(){}\\[\\]]", "");
        char[] charArray = line.toCharArray();
        Stack<Character> stackOfBrackets = new Stack<>();

        for (Character element : charArray) {
            if (stackOfBrackets.isEmpty() && (element == ')' || element == ']' || element == '}')) {
                return false;
            } else if (element == '(' || element == '[' || element == '{') {
                stackOfBrackets.push(element);
            } else if (element == ')' && stackOfBrackets.peek() == '(') {
                stackOfBrackets.pop();
            } else if (element == ']' && stackOfBrackets.peek() == '[') {
                stackOfBrackets.pop();
            } else if (element == '}' && stackOfBrackets.peek() == '{') {
                stackOfBrackets.pop();
            } else return false;
        }
        return stackOfBrackets.isEmpty();
    }
}
