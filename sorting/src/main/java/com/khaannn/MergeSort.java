package com.khaannn;

/**
 * Created by jeff on 9/15/15.
 */
public class MergeSort implements PairDataSorting {
    public PairData[] sort(PairData[] a) {
        MergeSortAlg(a, 0, a.length - 1);
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

    private void MergeSortAlg(PairData[] a, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            MergeSortAlg(a, low, mid);
            MergeSortAlg(a, mid + 1, high);
            merge(a, low, mid, high);
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

    public void merge(PairData[] a, int low, int mid, int high) {
        PairData[] tmp = new PairData[a.length];
        for (int i = low; i <= high; i++) {
            tmp[i] = a[i];
        }
        int i = low, j = mid + 1, k = low;
        while (i <= mid && j <= high) {
            if (tmp[i].getNum() <= tmp[j].getNum()) {
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
        PairDataSorting mergeSort = new MergeSort();
        input = mergeSort.sort(input);
        for (PairData item : input) {
            System.out.print(item + "\n");
        }
    }
}
