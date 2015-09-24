package com.khaannn.sorting;

import java.util.Arrays;

/**
 * Created by jeff on 9/16/15.
 */
public class Bonus {
    public static void main(String[] args) {
        PairData[] input = ReadFromTextFile.test(args[0]);
        JeffSort jeffsort = new JeffSort();
        PairData[] sorted = jeffsort.sort(input);
        for (PairData item : sorted) {
            System.out.print(item + "\n");
        }

        try {
            if (args[1].equalsIgnoreCase("test")) {
                jeffsort.test(input, sorted);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            //ignore(normal case)
        }

    }

    public void test(PairData[] input, PairData[] sorted) {
        Arrays.sort(input);
        assert (Arrays.equals(input, sorted));
    }
}
