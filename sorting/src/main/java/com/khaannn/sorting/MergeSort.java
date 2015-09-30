package com.khaannn.sorting;

import java.util.Arrays;

/**
 * Created by jeff on 9/15/15.
 * Implementation of Merge Sort.
 */
public class MergeSort {
    private int numberOfInversions = 0;
    public void MergeSort(){

    }

    public int getNumberOfInversions() {
        return numberOfInversions;
    }

    public void setNumberOfInversions(int numberOfInversions) {
        this.numberOfInversions = numberOfInversions;
    }

    public static PairData[] sort(PairData[] a) {
        PairData[] tmp = new PairData[a.length];
        MergeSortAlg(a, tmp, 0, a.length - 1);
        return a;
    }

    public int[] sort(int[] a) {
        int[] tmp = new int[a.length];
        MergeSortAlg(a, tmp, 0, a.length - 1);
        return a;
    }


    private void MergeSortAlg(int[] a, int[] tmp, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            MergeSortAlg(a, tmp, low, mid);
            MergeSortAlg(a, tmp,  mid + 1, high);
            merge(a, tmp, low, mid, high);
        }

    }

    private static void MergeSortAlg(PairData[] a, PairData[] tmp, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            MergeSortAlg(a, tmp, low, mid);
            MergeSortAlg(a, tmp, mid + 1, high);
            merge(a, tmp, low, mid, high);
        }
    }

    public void merge(int[] inputArray, int[] tmp, int low, int mid, int high) {
        int inversionCount = 0;
        for (int i = low; i <= high; i++) {
            tmp[i] = inputArray[i];
        }
        int i = low, j = mid + 1, k = low;
        while (i <= mid && j <= high) {
            if (tmp[i] <= tmp[j]) {
                inputArray[k] = tmp[i];
                i++;
            } else {
                inputArray[k] = tmp[j];
                j++;
            }
            inversionCount += (mid - i + 1);
            k++;
        }
        while (i <= mid) {
            inputArray[k] = tmp[i];
            k++;
            i++;
        }
        this.numberOfInversions += inversionCount;
    }

    public static void merge(PairData[] a, PairData[] tmp, int low, int mid, int high) {
        for (int i = low; i <= high; i++) {
            tmp[i] = a[i];
        }
        int i = low, j = mid + 1, k = low;
        while (i <= mid && j <= high) {
            if (tmp[i].getKey() <= tmp[j].getKey()) {
                a[k] = tmp[i];
                i++;
            } else {
                a[k] = tmp[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            a[k] = tmp[i];
            k++;
            i++;
        }

    }


    public static void main(String[] args) {
        PairData[] input = ReadFromTextFile.test(args[0]);

        final long startTime = System.nanoTime();
        MergeSort.sort(input);
        final long endTime = System.nanoTime();


        for (PairData item : input) {
            System.out.print(item + "\n");
        }


        try {
            if (args[1].equalsIgnoreCase("test")) {
                System.out.println("Elapsed time in Nanoseconds is " + (endTime - startTime));
                PairData[] input2 = ReadFromTextFile.test(args[0]);
                MergeSort.test(input2, input);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            //ignore(normal case)
        }

    }

    public static void test(PairData[] input, PairData[] sorted) {
        Arrays.sort(input);
        System.out.println(input.length + " " + sorted.length);
        assert (Arrays.equals(input, sorted));
    }
}
