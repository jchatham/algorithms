package com.khaannn;

import java.util.Arrays;

/**
 * Created by jeff on 9/15/15.
 * Implementation of Merge Sort.
 */
public class MergeSort implements PairDataSorting {
    int cores = Runtime.getRuntime().availableProcessors();

  /*  public PairData[] sortParallel(PairData[] a){
        parallelMergeSortAlg(a, 0, a.length - 1);
        return a;
    }

    public void parallelMergeSortAlg(PairData[] a, int low, int high){
        if (low < high) {
            int mid = (low + high) / 2;
            Thread lowThread = new Thread(new parallelMergeSortAlg(a, low, mid));
            MergeSortAlg(a, mid + 1, high);
            merge(a, low, mid, high);
        }

    }*/




    public PairData[] sort(PairData[] a) {
        PairData[] tmp = new PairData[a.length];
        MergeSortAlg(a, tmp, 0, a.length - 1);
        return a;
    }

    public int[] sort(int[] a) {
        MergeSortAlg(a, 0, a.length - 1);
        return a;
    }


    private void MergeSortAlg(int[] a, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            MergeSortAlg(a, low, mid);
            MergeSortAlg(a, mid + 1, high);
            merge(a, low, mid, high);
        }

    }

    private void MergeSortAlg(PairData[] a, PairData[] tmp, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            MergeSortAlg(a, tmp, low, mid);
            MergeSortAlg(a, tmp, mid + 1, high);
            merge(a, tmp, low, mid, high);
        }
    }

    public void merge(int[] inputArray, int low, int mid, int high) {
        int[] tmp = new int[inputArray.length];
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
            k++;
        }
        while (i <= mid) {
            inputArray[k] = tmp[i];
            k++;
            i++;
        }
    }

    public void merge(PairData[] a, PairData[] tmp, int low, int mid, int high) {
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
        MergeSort mergeSort = new MergeSort();

        final long startTime = System.currentTimeMillis();
        input = mergeSort.sort(input);
        final long endTime = System.currentTimeMillis();
        System.out.println("Elapsed time in Miliseconds is " + (endTime - startTime));


        PairData[] sorted = mergeSort.sort(input);
        for (PairData item : sorted) {
            //System.out.print(item + "\n");
        }


        try {
            if (args[1].equalsIgnoreCase("test")) {
                mergeSort.test(input, sorted);
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
