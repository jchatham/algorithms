package com.khaannn;

import java.util.Arrays;

/**
 * Created by jeff on 9/16/15.
 */
public class bonus {
    public static void main(String[] args) {
        PairData[] input = ReadFromTextFile.test(args[0]);
        jeffsort js = new jeffsort();
        PairData[] sorted = js.sort(input);
        for (PairData item : sorted) {
            System.out.print(item + "\n");
        }
        Arrays.sort(input);
        assert(Arrays.equals(input, sorted));
    }
}
