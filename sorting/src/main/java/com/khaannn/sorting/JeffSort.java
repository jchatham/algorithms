package com.khaannn.sorting;

import java.util.Arrays;

/**
 * Created by jeff on 9/17/15.
 */
public class JeffSort {
    private PairData[] array;
    private int length;
    private int k;
    private boolean isAscSorted = true;
    private boolean isDescSorted = true;

    private static final int MIN_N_FOR_INSERTION_SORT = 64;
    private static final int MAX_K_FOR_COUNTING_SORT = 1000;

    public PairData[] sort(PairData[] a) {
        this.array = a;
        this.length = a.length;
        //insertion sort on small arrays
        if (this.length < MIN_N_FOR_INSERTION_SORT) {
            PairDataSorting insertionSort = new InsertionSort();
            return insertionSort.sort(this.array);
        }
        findData();
        if (isAscSorted) {
            return array;
        } else if (isDescSorted) {
            reverseArray();
            return array;
        }
        if (k <= MAX_K_FOR_COUNTING_SORT) {
            CountingSort cs = new CountingSort();
            return cs.countingSortHelper(array, k);
        } else {
            return MergeSort.sort(array);
        }
    }


    public void reverseArray() {
        PairData tmp;
        for (int i = 0, k = length; i < k; i++, k--) {
            tmp = array[i];
            array[i] = array[k];
            array[k] = tmp;
        }
    }

    public void findData() {
        k = Integer.MIN_VALUE;
        if (array[0].getKey() > array[length - 1].getKey()) {
            isDescSorted = false;
        }
        if (array[0].getKey() < array[length - 1].getKey()) {
            isAscSorted = false;
        }
        int tmp;
        //Walks array, finding the min vals and also if it's already sorted asc or desc.
        for (int i = 0; i < this.length; i++) {
            tmp = array[i].getKey();
            if (tmp > k) {
                k = tmp;
            }
            if (i != 0) {
                if (isDescSorted) {
                    if (tmp > array[i - 1].getKey()) {
                        isDescSorted = false;
                    }
                }
                if (isAscSorted) {
                    if (tmp < array[i - 1].getKey()) {
                        isAscSorted = false;
                    }
                }
            }
        }


    }
    public static void main(String[] args) {
        PairData[] input = ReadFromTextFile.test(args[0]);
        JeffSort jeffsort = new JeffSort();

        final long startTime = System.nanoTime();
        PairData[] sorted = jeffsort.sort(input);
        final long endTime = System.nanoTime();

        for (PairData item : sorted) {
            System.out.print(item + "\n");
        }

        try {
            if (args[1].equalsIgnoreCase("test")) {
                System.out.println("Elapsed time in Nanoseconds is " + (endTime - startTime));
                jeffsort.test(input, sorted);
            }
        }catch (ArrayIndexOutOfBoundsException e){
            //ignore(normal case)
        }

    }

    public void test(PairData[] input, PairData[] sorted) {
        Arrays.sort(input);
        assert (Arrays.equals(input, sorted));
    }
}

