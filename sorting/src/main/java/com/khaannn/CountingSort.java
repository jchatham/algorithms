package com.khaannn;

import java.util.Arrays;

/**
 * Created by chatham_j on 9/16/2015.
 * Implements counting sort.
 */
public class CountingSort implements PairDataSorting {


    public int[] sort(int[] a) {
        //finds min and max values
        int maxVal = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;
        for (int i : a) {
            if (i >= maxVal) {
                maxVal = i;
            }
            if (i <= minVal) {
                minVal = i;
            }
        }
        //initializes array to range between min and max
        int[] count = new int[maxVal - minVal + 1];
        //walks through array a and assigns values to count offset by min value;
        for (int i = 0; i < a.length; i++) {
            count[a[i] - minVal]++;
        }
        //produces the output array in sorted order
        for (int i = minVal, k = 0; i <= maxVal; i++) {
            while (count[i - minVal] > 0) {
                a[k] = i;
                count[i - minVal]--;
                k++;
            }
        }

        return a;
    }

    public PairData[] sort(PairData[] a) {
        //finds max value
        int k = Integer.MIN_VALUE;
        for (PairData i : a) {
            if (i.getKey() >= k) {
                k = i.getKey();
            }
        }

        return countingSortHelper(a, k);
    }


    protected PairData[] countingSortHelper(PairData[] a, int k) {
        int n = a.length;
        int[] counts = new int[k + 1];
        PairData[] output = new PairData[n];
        for (int i = 0; i < k; i++) {
            counts[i] = 0;
        }
        for (int j = 0; j < n; j++) {
            counts[a[j].getKey()] = counts[a[j].getKey()] + 1;
        }
        for (int i = 1; i <= k; i++) {
            counts[i] = counts[i] + counts[i - 1];
        }

        for (int j = n - 1; j >= 0; j--) {
            output[counts[a[j].getKey()] - 1] = a[j];
            counts[a[j].getKey()] = counts[a[j].getKey()] - 1;
        }

        return output;

    }

    public static void main(String[] args) {
        PairData[] input = ReadFromTextFile.test(args[0]);
        CountingSort countingSort = new CountingSort();
        PairData[] sorted = countingSort.sort(input);
        for (PairData item : sorted) {
            System.out.print(item + "\n");
        }

        try {
            if (args[1].equalsIgnoreCase("test")) {
                countingSort.test(input, sorted);
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