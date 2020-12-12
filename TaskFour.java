package com.og;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] str = scanner.nextLine().split(" ");

        Function<String[], Integer[]> sortByEvenAtFirst = strings -> {
            Integer[] ints = new Integer[strings.length];
            for (int i = 0; i < strings.length; i++) {
                ints[i] = Integer.parseInt(strings[i]);
            }
            Arrays.sort(ints);

            Arrays.sort(ints, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    if (o2 % 2 != 0 && o1 % 2 == 0) return -1;
                    return 0;
                }
            });
            return ints;
        };

        System.out.println(Arrays.toString(sortByEvenAtFirst.apply(str)));
    }
}
