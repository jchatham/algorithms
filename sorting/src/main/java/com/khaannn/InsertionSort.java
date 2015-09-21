package com.khaannn;

/**
 * Created by jeff on 9/15/15.
 * Insertion Sort for an integer array.
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
            while (j > 0 && a[j - 1].getNum() > a[j].getNum()) {
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
        input = insertionSort.sort(input);
        for (PairData item : input) {
            System.out.print(item + "\n");
        }
    }

}
