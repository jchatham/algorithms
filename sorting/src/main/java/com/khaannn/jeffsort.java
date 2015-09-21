package com.khaannn;

import java.util.Arrays;

/**
 * Created by jeff on 9/17/15.
 */
public class jeffsort {
    private PairData[] array;
    private int length;
    private int k;
    private int minVal;
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
        if ((minVal - k) < MAX_K_FOR_COUNTING_SORT) {
            CountingSort cs = new CountingSort();
            return cs.countingSortHelper(array, k);
        } else {
            PairDataSorting ms = new MergeSort();
            return ms.sort(array);
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
        jeffsort js = new jeffsort();
        PairData[] sorted = js.sort(input);
        for (PairData item : sorted) {
            System.out.print(item + "\n");
        }
        Arrays.sort(input);
        assert(Arrays.equals(input, sorted));
    }
}
