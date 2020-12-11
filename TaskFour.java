package com.og;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.function.BiFunction;

public class Main implements Comparable<com.og.Main> {
    int number;

    public Main(int number) {
        this.number = number;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] str = scanner.nextLine().split(" ");


        Integer[] numbers = new Integer[str.length];


        BiFunction<String[], Integer[], com.og.Main[]> sortByEvenAtFirst = (strings, ints) -> {
            for (int i = 0; i < strings.length; i++) {
                ints[i] = Integer.parseInt(strings[i]);
            }
            Arrays.sort(ints);
            com.og.Main[] mainNumbers = new com.og.Main[str.length];
            for (int i = 0; i < mainNumbers.length; i++) {
                mainNumbers[i] = new com.og.Main(numbers[i]);
            }

            Arrays.sort(mainNumbers, new Comparator<com.og.Main>() {
                @Override
                public int compare(com.og.Main o1, com.og.Main o2) {
                    return o1.compareTo(o2);
                }
            });
            return mainNumbers;
        };


        System.out.println(Arrays.toString(sortByEvenAtFirst.apply(str, numbers)));

    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return " " + number;
    }

    @Override
    public int compareTo(com.og.Main other) {
        return ((this.number % 2 != 0) ? 1 : (other.getNumber() % 2 == 0) ? 0 : -1);
    }
}

