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
        String numbersLine;
        String[] stringOfNumbers;

        numbersLine = inputIntegersAsAString();

        stringOfNumbers = numbersLine.split("\\s+");

        System.out.println(Arrays.toString(stringOfNumbers));

        System.out.println();
        printTheShortestNumber(stringOfNumbers);
        printTheLongestNumber(stringOfNumbers);

        String[] arrayByIncreasingLength;
        arrayByIncreasingLength = sortByIncreasingLength(stringOfNumbers);
        System.out.println("\nNumbers are sorted by increasing their length:");
        System.out.println(Arrays.toString(arrayByIncreasingLength));

        String[] arrayByDecreasingLength;
        arrayByDecreasingLength = sortByDecreasingLength(stringOfNumbers);
        System.out.println("\nNumbers are sorted by decreasing their length:");
        System.out.println(Arrays.toString(arrayByDecreasingLength));

        printIntegersThatAreShorterThanAverageLength(stringOfNumbers);
        printIntegersThatAreLongerThanAverageLength(stringOfNumbers);

        System.out.println("\n" + Arrays.toString(stringOfNumbers));
        int numberWithMinAmountOfDifferentDigits;
        numberWithMinAmountOfDifferentDigits = getIntegerWithMinAmountOfDifferentDigits(stringOfNumbers);
        System.out.println("\nThe first number that contains min amount of different digits: " +
                numberWithMinAmountOfDifferentDigits + "\n");

        int quantityOfNumbersWithOnlyEvenDigits;
        quantityOfNumbersWithOnlyEvenDigits = getQuantityOfIntegersWithOnlyEvenDigits(stringOfNumbers);
        System.out.println("Quantity of numbers which contain only even digits: " +
                quantityOfNumbersWithOnlyEvenDigits + "\n");

        int quantityOfNumbersWithEqualAmountOfEvenAndUnevenDigits;
        quantityOfNumbersWithEqualAmountOfEvenAndUnevenDigits =
                getQuantityOfIntegersWithEqualAmountOfEvenAndUnevenDigits(stringOfNumbers);
        System.out.println("Quantity of numbers which contain only equal amount of even and uneven digits: " +
                quantityOfNumbersWithEqualAmountOfEvenAndUnevenDigits + "\n");

        int integerWithRisingDigitsSequence;
        integerWithRisingDigitsSequence = getIntegerWithRisingDigitsSequence(stringOfNumbers);
        System.out.println("Integer with rising digits sequence: " + integerWithRisingDigitsSequence + "\n");

        int integerWithOnlyDifferentDigits;
        integerWithOnlyDifferentDigits = getIntegerWithOnlyDifferentDigits(stringOfNumbers);
        System.out.println("Integer with only different digits: " + integerWithOnlyDifferentDigits + "\n");
    }


    private static String inputIntegersAsAString() {
        boolean found;
        String line;
        String message;
        Scanner in = new Scanner(System.in);

        message = "Enter integer numbers using SPACE to divide them:>> ";
        do {
            System.out.print(message);
            Pattern pattern = Pattern.compile("[^0-9-\\s+]");
            line = in.nextLine();
            Matcher matcher = pattern.matcher(line);
            found = matcher.find();
        } while (found);

        line = line.replaceAll("\\+", " ");
        line = line.replaceAll("-\\s*", "-");
        line = line.trim();
        return line;
    }


    private static void printTheShortestNumber(String[] numbers) {
        int minLength;
        minLength = numbers[0].length();
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i].length() < minLength) {
                minLength = numbers[i].length();
            }
        }
        System.out.print("The shortest number(s) is(are): ");
        for (String val : numbers) {
            if (val.length() == minLength) {
                System.out.print(val + " ");
            }
        }
        System.out.print("(length: " + minLength + ")\n");
    }


    private static void printTheLongestNumber(String[] numbers) {
        int maxLength;
        maxLength = numbers[0].length();
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i].length() > maxLength) {
                maxLength = numbers[i].length();
            }
        }
        System.out.print("The longest number(s) is(are): ");
        for (String val : numbers) {
            if (val.length() == maxLength) {
                System.out.print(val + " ");
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
        for (String var : numbers) {
            if ((double) var.length() < averageLength) {
                System.out.println(var + "(length: " + var.length() + ")  ");
            }
        }
    }


    private static void printIntegersThatAreLongerThanAverageLength(String[] numbers) {
        double averageLength = getAverageLength(numbers);

        System.out.printf("\nAverage length: %.2f\n", averageLength);
        System.out.println("Numbers which length less than average length:");
        for (String var : numbers) {
            if ((double) var.length() > averageLength) {
                System.out.println(var + "(length: " + var.length() + ")  ");
            }
        }
    }


    private static double getAverageLength(String[] numbers) {
        double averageLength;
        int fullLength = 0;

        for (String val : numbers) {
            fullLength += val.length();
        }

        averageLength = (double) fullLength / numbers.length;

        return averageLength;
    }


    private static int getIntegerWithMinAmountOfDifferentDigits(String[] numbers) {
        int numberWithMinAmountOfDifferentDigits;
        int[] intArray = getIntArrayFromStringArray(numbers);
        int minDifferentDigitsAmount = 10;
        int minDifferentDigitsIndex = 0;

        for (int i = 0; i < intArray.length; i++) {
            int currentDifferentDigitsAmount = 0;
            int[] digitsOfNumber = getDigitsOfTheNumber(intArray[i]);

            for (int digit = 0; digit < 10; digit++) {
                for (int val : digitsOfNumber) {
                    if (val == digit) {
                        currentDifferentDigitsAmount++;
                        break;
                    }
                }
            }

            if (currentDifferentDigitsAmount < minDifferentDigitsAmount) {
                minDifferentDigitsAmount = currentDifferentDigitsAmount;
                minDifferentDigitsIndex = i;
            }

        }

        numberWithMinAmountOfDifferentDigits = intArray[minDifferentDigitsIndex];

        return numberWithMinAmountOfDifferentDigits;
    }


    private static int[] getIntArrayFromStringArray(String[] numbers) {
        int[] intArray = new int[numbers.length];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = Integer.parseInt(numbers[i]);
        }
        return intArray;
    }


    private static int[] getDigitsOfTheNumber(int number) {
        int n;
        n = String.valueOf(number).length();
        int[] digits = new int[n];

        for (int i = digits.length - 1; i >= 0; i--) {
            int num = number / 10;
            int digit = number - num * 10;
            digits[i] = digit;
            number = num;
        }

        return digits;
    }


    private static int getQuantityOfIntegersWithOnlyEvenDigits(String[] numbers) {
        int quantityOfNumbersWithOnlyEvenDigits = 0;
        int[] intArray = getIntArrayFromStringArray(numbers);

        for (int val : intArray) {
            int[] digitsOfTheNumber;
            boolean hasOnlyEvenDigits;

            digitsOfTheNumber = getDigitsOfTheNumber(val);
            hasOnlyEvenDigits = true;

            for (int item : digitsOfTheNumber) {
                if (item % 2 != 0) {
                    hasOnlyEvenDigits = false;
                    break;
                }
            }

            if (hasOnlyEvenDigits) {
                quantityOfNumbersWithOnlyEvenDigits++;
            }

        }
        return quantityOfNumbersWithOnlyEvenDigits;
    }


    private static int getQuantityOfIntegersWithEqualAmountOfEvenAndUnevenDigits(String[] numbers) {
        int quantityOfNumbersWithEqualAmountOfEvenAndUnevenDigits = 0;
        int[] intArray = getIntArrayFromStringArray(numbers);

        for (int val : intArray) {
            int[] digitsOfTheNumber = getDigitsOfTheNumber(val);
            int amountOfEvenDigits = 0;
            int amountOfUnevenDigits = 0;

            for (int item : digitsOfTheNumber) {
                if (item % 2 == 0) {
                    amountOfEvenDigits++;
                } else {
                    amountOfUnevenDigits++;
                }
            }

            if (amountOfEvenDigits == amountOfUnevenDigits) {
                quantityOfNumbersWithEqualAmountOfEvenAndUnevenDigits++;
            }
        }

        return quantityOfNumbersWithEqualAmountOfEvenAndUnevenDigits;
    }


    private static int getIntegerWithRisingDigitsSequence(String[] numbers) {
        int integerWithRisingDigitsSequence = 0;
        int[] intArray = getIntArrayFromStringArray(numbers);

        for (int val : intArray) {
            int[] digitsOfTheNumber;
            boolean hasRisingDigitsSequence = false;
            digitsOfTheNumber = getDigitsOfTheNumber(val);

            if (String.valueOf(val).length() == 1) {
                continue;
            }

            for (int i = 0; i < digitsOfTheNumber.length - 1; i++) {

                if (digitsOfTheNumber[i + 1] >= digitsOfTheNumber[i]) {
                    hasRisingDigitsSequence = true;
                } else {
                    hasRisingDigitsSequence = false;
                    break;
                }
            }

            if (hasRisingDigitsSequence) {
                integerWithRisingDigitsSequence = val;
                break;
            }
        }

        return integerWithRisingDigitsSequence;
    }


    private static int getIntegerWithOnlyDifferentDigits(String[] numbers) {
        int integerWithOnlyDifferentDigits = 0;

        for (String val : numbers) {
            if (hasOnlyDifferentDigits(val)) {
                integerWithOnlyDifferentDigits = Integer.parseInt(val);
                break;
            }
        }
        return integerWithOnlyDifferentDigits;
    }


    private static boolean hasOnlyDifferentDigits(String number) {
        boolean hasOnlyDifferentDigits = true;
        StringBuilder sequence = new StringBuilder();

        for (int i = 0; i < number.length(); i++) {
            String digits = sequence.toString();
            if (digits.contains(Character.toString(number.charAt(i)))) {
                hasOnlyDifferentDigits = false;
                break;
            } else {
                sequence.append(number.charAt(i));
            }
        }

        return hasOnlyDifferentDigits;
    }
}
