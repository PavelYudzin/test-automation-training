package com.company.automation.fundamentals.optional_task.optional_task_01;

/*
Задание. Ввести n чисел с консоли.

1. + Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.
2. + Вывести числа в порядке возрастания (убывания) значений их длины.
3. + Вывести на консоль те числа, длина которых меньше (больше) средней длины по всем числам, а также длину.
4. + Найти число, в котором количество различных цифр минимально. Если таких чисел несколько, найти первое из них.
5. + Найти количество чисел, содержащих только четные цифры, а среди оставшихся — количество чисел с равным числом
     четных и нечетных цифр.
6. + Найти число, цифры в котором идут в строгом порядке возрастания. Если таких чисел несколько, найти первое из них.
7. + Найти число, состоящее только из различных цифр. Если таких чисел несколько, найти первое из них.
 */

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OptionalTask01 {
    public static void main(String[] args) {
        String numbersLine = getStringOfIntegersFromConsole();

        String[] arrayOfNumbers = numbersLine.split("\\s+");

        System.out.println(Arrays.toString(arrayOfNumbers));

        System.out.println();
        printTheShortestNumber(arrayOfNumbers);
        printTheLongestNumber(arrayOfNumbers);

        String[] arrayByIncreasingLength = sortByIncreasingLength(arrayOfNumbers);
        System.out.println("\nNumbers are sorted by increasing their length:");
        System.out.println(Arrays.toString(arrayByIncreasingLength));

        String[] arrayByDecreasingLength = sortByDecreasingLength(arrayOfNumbers);
        System.out.println("\nNumbers are sorted by decreasing their length:");
        System.out.println(Arrays.toString(arrayByDecreasingLength));

        printIntegersThatAreShorterThanAverageLength(arrayOfNumbers);
        printIntegersThatAreLongerThanAverageLength(arrayOfNumbers);

        System.out.println("\n" + Arrays.toString(arrayOfNumbers));

        int numberWithMinAmountOfDifferentDigits = getIntegerWithMinAmountOfDifferentDigits(arrayOfNumbers);
        System.out.println("\nThe first number that contains min amount of different digits: " +
                numberWithMinAmountOfDifferentDigits + "\n");

        int quantityOfNumbersWithOnlyEvenDigits = getQuantityOfIntegersWithOnlyEvenDigits(arrayOfNumbers);
        System.out.println("Quantity of numbers which contain only even digits: " +
                quantityOfNumbersWithOnlyEvenDigits + "\n");

        int quantityOfNumbersWithEqualAmountOfEvenAndUnevenDigits = getQuantityOfIntegersWithEqualAmountOfEvenAndUnevenDigits(arrayOfNumbers);
        System.out.println("Quantity of numbers which contain equal amount of even and uneven digits: " +
                quantityOfNumbersWithEqualAmountOfEvenAndUnevenDigits + "\n");

        int integerWithRisingDigitsSequence = getIntegerWithRisingDigitsSequence(arrayOfNumbers);
        System.out.println("The first number with rising digits sequence: " + integerWithRisingDigitsSequence + "\n");

        int integerWithOnlyDifferentDigits = getIntegerWithOnlyDifferentDigits(arrayOfNumbers);
        System.out.println("The first number with only different digits: " + integerWithOnlyDifferentDigits + "\n");
    }


    private static String getStringOfIntegersFromConsole() {
        boolean hasWrongCharacters;
        boolean hasDigits;
        String line;
        String message = "Enter integer numbers using SPACE to divide them:>> ";
        Scanner in = new Scanner(System.in);

        do {
            System.out.print(message);
            line = in.nextLine();
            hasWrongCharacters = Pattern.compile("[^0-9-\\s+]").matcher(line).find();
            hasDigits = Pattern.compile("[\\d]").matcher(line).find();
        } while (hasWrongCharacters || !hasDigits);

        line = line.replaceAll("\\+\\s*", " ");
        line = line.replaceAll("-\\s*", " -");
        line = line.trim();
        return line;
    }


    private static void printTheShortestNumber(String[] numbers) {
        int minLength = numbers[0].length();

        for (String value : numbers) {
            if (value.length() < minLength) {
                minLength = value.length();
            }
        }
        System.out.print("The shortest number(s) is(are): ");

        for (String value : numbers) {
            if (value.length() == minLength) {
                System.out.print(value + " ");
            }
        }
        System.out.print("(length: " + minLength + ")\n");
    }


    private static void printTheLongestNumber(String[] numbers) {
        int maxLength = numbers[0].length();

        for (String value : numbers) {
            if (value.length() > maxLength) {
                maxLength = value.length();
            }
        }
        System.out.print("The longest number(s) is(are): ");

        for (String value : numbers) {
            if (value.length() == maxLength) {
                System.out.print(value + " ");
            }
        }
        System.out.print("(length: " + maxLength + ")\n");
    }


    private static String[] sortByIncreasingLength(String[] numbers) {
        String[] arrayCopy = Arrays.copyOf(numbers, numbers.length);

        // bubble sorting
        for (int i = 0; i < arrayCopy.length - 1; i++) {
            for (int j = i; j >= 0; j--) {
                if (arrayCopy[j].length() > arrayCopy[j + 1].length()) {
                    String temp = arrayCopy[j];
                    arrayCopy[j] = arrayCopy[j + 1];
                    arrayCopy[j + 1] = temp;
                }
            }
        }
        return arrayCopy;
    }


    private static String[] sortByDecreasingLength(String[] numbers) {
        String[] arrayCopy = Arrays.copyOf(numbers, numbers.length);

        // bubble sorting
        for (int i = 0; i < arrayCopy.length - 1; i++) {
            for (int j = i; j >= 0; j--) {
                if (arrayCopy[j].length() < arrayCopy[j + 1].length()) {
                    String temp = arrayCopy[j];
                    arrayCopy[j] = arrayCopy[j + 1];
                    arrayCopy[j + 1] = temp;
                }
            }
        }
        return arrayCopy;
    }


    private static void printIntegersThatAreShorterThanAverageLength(String[] numbers) {
        double averageLength = getAverageLength(numbers);

        System.out.printf("\nAverage length: %.2f\n", averageLength);
        System.out.println("Numbers which length less than average length:");

        for (String value : numbers) {
            if ((double) value.length() < averageLength) {
                System.out.println(value + "(length: " + value.length() + ")  ");
            }
        }
    }


    private static void printIntegersThatAreLongerThanAverageLength(String[] numbers) {
        double averageLength = getAverageLength(numbers);

        System.out.printf("\nAverage length: %.2f\n", averageLength);
        System.out.println("Numbers which length more than average length:");

        for (String value : numbers) {
            if ((double) value.length() > averageLength) {
                System.out.println(value + "(length: " + value.length() + ")  ");
            }
        }
    }


    private static double getAverageLength(String[] numbers) {
        double averageLength;
        int fullLength = 0;

        for (String value : numbers) {
            fullLength += value.length();
        }

        averageLength = (double) fullLength / numbers.length;

        return averageLength;
    }


    private static int getIntegerWithMinAmountOfDifferentDigits(String[] numbers) {
        int numberWithMinAmountOfDifferentDigits;
        int minDifferentDigitsAmount = 10;
        int minDifferentDigitsIndex = 0;

        for (int i = 0; i < numbers.length; i++) {
            int differentDigitsAmount;

            differentDigitsAmount = getAmountOfDifferentDigits(numbers[i]);

            if (differentDigitsAmount < minDifferentDigitsAmount) {
                minDifferentDigitsAmount = differentDigitsAmount;
                minDifferentDigitsIndex = i;
            }
        }

        numberWithMinAmountOfDifferentDigits = Integer.parseInt(numbers[minDifferentDigitsIndex]);

        return numberWithMinAmountOfDifferentDigits;
    }


    private static int getAmountOfDifferentDigits(String number) {
        int amountOfDifferentDigits;
        StringBuilder differentDigits = new StringBuilder();

        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == '-') {
                continue;
            }
            String stringOfDifferentNumbers = differentDigits.toString();
            if (!stringOfDifferentNumbers.contains(Character.toString(number.charAt(i)))) {
                differentDigits.append(number.charAt(i));
            }
        }

        amountOfDifferentDigits = differentDigits.toString().length();

        return amountOfDifferentDigits;
    }


    private static int getQuantityOfIntegersWithOnlyEvenDigits(String[] numbers) {
        int quantityOfNumbersWithOnlyEvenDigits = 0;

        for (String value : numbers) {

            if (hasOnlyEvenDigits(value)) {
                quantityOfNumbersWithOnlyEvenDigits++;
            }
        }
        return quantityOfNumbersWithOnlyEvenDigits;
    }


    private static boolean hasOnlyEvenDigits(String number) {
        Pattern pattern = Pattern.compile("[13579]");
        Matcher matcher = pattern.matcher(number);
        return !matcher.find();
    }


    private static int getQuantityOfIntegersWithEqualAmountOfEvenAndUnevenDigits(String[] numbers) {
        int quantityOfNumbersWithEqualAmountOfEvenAndUnevenDigits = 0;

        for (String value : numbers) {

            if (hasEqualAmountOfEvenAndUnevenDigits(value)) {
                quantityOfNumbersWithEqualAmountOfEvenAndUnevenDigits++;
            }
        }

        return quantityOfNumbersWithEqualAmountOfEvenAndUnevenDigits;
    }


    private static boolean hasEqualAmountOfEvenAndUnevenDigits(String number) {
        int amountOfEvenDigits = 0;
        int amountOfUnevenDigits = 0;
        int[] digitsOfTheNumber = getDigitsOfTheNumber(number);

        for (int value : digitsOfTheNumber) {
            if (value % 2 == 0) {
                amountOfEvenDigits++;
            } else {
                amountOfUnevenDigits++;
            }
        }

        return amountOfEvenDigits == amountOfUnevenDigits;
    }


    private static int getIntegerWithRisingDigitsSequence(String[] numbers) {
        int integerWithRisingDigitsSequence = 0;

        for (String value : numbers) {

            if (hasRisingDigitsSequence(value)) {
                integerWithRisingDigitsSequence = Integer.parseInt(value);
                break;
            }
        }

        return integerWithRisingDigitsSequence;
    }


    private static boolean hasRisingDigitsSequence(String number) {
        int[] digitsOfTheNumber = getDigitsOfTheNumber(number);

        if (digitsOfTheNumber.length == 1) {
            return false;
        }

        for (int i = 0; i < digitsOfTheNumber.length - 1; i++) {
            if (digitsOfTheNumber[i + 1] < digitsOfTheNumber[i]) {
                return false;
            }
        }
        return true;
    }


    private static int[] getDigitsOfTheNumber(String stringNumber) {
        int n;
        int number = Integer.parseInt(stringNumber);

        if (number < 0) {
            n = stringNumber.length() - 1;
            number = Math.abs(number);
        } else {
            n = stringNumber.length();
        }

        int[] digits = new int[n];

        for (int i = digits.length - 1; i >= 0; i--) {
            int num = number / 10;
            int digit = number - num * 10;
            digits[i] = digit;
            number = num;
        }
        return digits;
    }


    private static int getIntegerWithOnlyDifferentDigits(String[] numbers) {
        int integerWithOnlyDifferentDigits = 0;

        for (String value : numbers) {
            if (hasOnlyDifferentDigits(value)) {
                integerWithOnlyDifferentDigits = Integer.parseInt(value);
                break;
            }
        }
        return integerWithOnlyDifferentDigits;
    }


    private static boolean hasOnlyDifferentDigits(String number) {
        StringBuilder sequence = new StringBuilder();

        if (number.length() == 1) {
            return true;
        }

        if (number.length() == 2 && number.charAt(0) == '-') {
            return true;
        }

        for (int i = 0; i < number.length(); i++) {

            String digits = sequence.toString();
            if (digits.contains(Character.toString(number.charAt(i)))) {
                return false;
            } else {
                sequence.append(number.charAt(i));
            }
        }
        return true;
    }
}