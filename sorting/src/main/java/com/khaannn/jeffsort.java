package com.khaannn;

/**
 * Created by jeff on 9/17/15.
 */
public class jeffsort {
    private PairData[] array;
    private int length;
    private int maxVal;
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
        if ((minVal - maxVal) < MAX_K_FOR_COUNTING_SORT) {
            CountingSort cs = new CountingSort();
            return cs.countingSortHelper(array, minVal, maxVal);
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
        maxVal = Integer.MIN_VALUE;
        minVal = Integer.MAX_VALUE;
        if (array[0].getNum() > array[length - 1].getNum()) {
            isDescSorted = false;
        }
        if (array[0].getNum() < array[length - 1].getNum()) {
            isAscSorted = false;
        }
        int tmp;
        //Walks array, finding the min/max vals and also if it's already sorted asc or desc.
        for (int i = 0; i <= this.length; i++) {
            tmp = array[i].getNum();
            if (tmp > maxVal) {
                maxVal = tmp;
            }
            if (tmp < minVal) {
                minVal = tmp;
            }
            if (i != 0) {
                if (isDescSorted) {
                    if (tmp > array[i - 1].getNum()) {
                        isDescSorted = false;
                    }
                }
                if (isAscSorted) {
                    if (tmp < array[i - 1].getNum()) {
                        isAscSorted = false;
                    }
                }
            }
        }


    }
    public static void main(String[] args) {
        jeffsort js = new jeffsort();

        PairData[] pairData = new PairData[10];
        pairData[0] = new PairData(-5,"jeff");
        pairData[1] = new PairData(45464,"nibbles");
        pairData[2] = new PairData(19,"john");
        pairData[3] = new PairData(43,"kristen");
        pairData[4] = new PairData(5,"kelli");
        pairData[5] = new PairData(0,"alan");
        pairData[6] = new PairData(-65,"jimmy");
        pairData[7] = new PairData(-43,"champion");
        pairData[8] = new PairData(325235,"sasha");
        pairData[9] = new PairData(234523443,"robin");
        pairData = js.sort(pairData);
        for(PairData item : pairData){
            System.out.print(item + "\n");
        }
    }
}
