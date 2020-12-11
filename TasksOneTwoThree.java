package com.og;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {
     taskTwo();
    }

    public static void taskOne() {
        Scanner scanner = new Scanner(System.in);
        String[] str = scanner.nextLine().split(" ");

        Function<String[], int[]> parseStringToInt = strings -> {
            int[] ints = new int[strings.length];
            for (int i = 0; i < strings.length; i++) {
                ints[i] = Integer.parseInt(strings[i]);
            }
            return ints;
        };

        int[] intArray = parseStringToInt.apply(str);

        UnaryOperator<int[]> add = ints -> {
            for (int i = 0; i < ints.length; i++) {
                ints[i]++;
            }
            return ints;
        };

        UnaryOperator<int[]> multiply = ints -> {
            for (int i = 0; i < ints.length; i++) {
                ints[i] = ints[i] * 2;
            }
            return ints;
        };

        UnaryOperator<int[]> subtract = ints -> {
            for (int i = 0; i < ints.length; i++) {
                ints[i]--;
            }
            return ints;
        };

        Consumer<int[]> print = ints -> {
            System.out.println(Arrays.toString(ints));
        };

        String command = "";

        do {
            command = scanner.nextLine();
            switch (command) {
                case "add" -> add.apply(intArray);
                case "multiply" -> multiply.apply(intArray);
                case "subtract" -> subtract.apply(intArray);
                case "print" -> print.accept(intArray);
            }
        } while (!command.equals("end"));

    }


    public static void taskTwo() {
        Scanner scanner = new Scanner(System.in);
        String[] str = scanner.nextLine().split(" ");

        ArrayList<Integer> intsList = new ArrayList<>();
        for (String s : str) {
            intsList.add(Integer.parseInt(s));
        }
        BiFunction<Scanner, ArrayList<Integer>, ArrayList<Integer>> reversAndRemoveDividend = (scan, ints) -> {
            Collections.reverse(ints);
            int dividend = Integer.parseInt(scan.nextLine());
            for (int i = 0; i < ints.size(); i++) {
                if (ints.get(i) % dividend == 0) {
                    ints.remove(ints.get(i));
                    i--;
                }
            }return ints;
        };

        System.out.println(reversAndRemoveDividend.apply(scanner, intsList));
    }

    public static void taskThree() {
        Scanner scanner = new Scanner(System.in);

        int maxLength = Integer.parseInt(scanner.nextLine());
        String[] str = scanner.nextLine().split(" ");

        ArrayList<String> words = new ArrayList<>(Arrays.asList(str));

        BiFunction<Integer, ArrayList<String>, ArrayList<String>> getWordsByMaxLength = (itemMaxLength, strings) -> {
            strings.removeIf(string -> string.length() > itemMaxLength);
            return strings;
        };

        System.out.println(getWordsByMaxLength.apply(maxLength, words));


    }

}
