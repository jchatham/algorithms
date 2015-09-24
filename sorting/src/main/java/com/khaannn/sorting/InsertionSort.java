package com.khaannn.sorting;

import java.util.Arrays;

/**
 * Created by jeff on 9/15/15.
 * Implementation of Insertion Sort.
 */


public class InsertionSort implements PairDataSorting {

    public int [] sort(int [] a){
        int j, tmp;
        for(int i =0;  i<a.length;i++){
            j = i;
            while (j > 0 && a[j - 1] > a[j]) {
                tmp = a[j];
                a[j] = a[j-1];
                a[j-1] = tmp;
                j--;
            }
        }
        return a;
    }

    public PairData[] sort(PairData[] a){
        int j;
        PairData tmp;
        for(int i =0;  i<a.length;i++){
            j = i;
            while (j > 0 && a[j - 1].getKey() > a[j].getKey()) {
                tmp = a[j];
                a[j] = a[j-1];
                a[j-1]= tmp;
                j--;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        PairData[] input = ReadFromTextFile.test(args[0]);
        InsertionSort insertionSort = new InsertionSort();

        PairData[] sorted;
        final long startTime = System.nanoTime();
        sorted = insertionSort.sort(input);
        final long endTime = System.nanoTime();

        for (PairData item : sorted) {
            System.out.print(item + "\n");
        }

        try {
            if (args[1].equalsIgnoreCase("test")) {
                System.out.println("Elapsed time in Nanoseconds is " + (endTime - startTime));
                insertionSort.test(input, sorted);
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
