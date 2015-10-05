package com.khaannn.divideandconquer;

import com.khaannn.sorting.MergeSort;


/**
 * Created by chatham_j on 9/30/2015.
 */
public class InversionCount {
    private Comparable[] array;
    private Comparable[] tmp;
    private int numberOfInversions;

    public int getNumberOfInversions() {
        return numberOfInversions;
    }

    public void setNumberOfInversions(int numberOfInversions) {
        this.numberOfInversions = numberOfInversions;
    }

    public InversionCount(Comparable[] array) {
        this.array = array;
        this.tmp = new Comparable[array.length];
    }

    public InversionCount countAndSort() {
        countAndSortHelper(0, array.length - 1);
        return this;
    }

    private void countAndSortHelper(int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            countAndSortHelper(low, mid);
            countAndSortHelper(mid + 1, high);
            merge(low, mid, high);
        }
    }

    private void merge(int low, int mid, int high) {

        for(int i = low; i <= high; i++){
            tmp[i] = array[i];
        }

        for(int k = low, i = low, j = mid + 1; k <= high; k++){
            if(j > high){
                array[k] = tmp[i++];
            } else if (i > mid){
                array[k] = tmp[j++];
            } else if (tmp[i].compareTo(tmp[j]) > 0){
                array[k] = tmp[j++];
                numberOfInversions += (mid - i);
            } else{
                array[k] = tmp[i++];
            }
        }
    }

    public static void main(String args[]) {
        Integer array[] = {1, 20, 6, 4, 5};
        InversionCount inversionCount = new InversionCount(array);
        int inversions = inversionCount.countAndSort().getNumberOfInversions();
        System.out.println("Number of inversions= " + inversions);
        for (int i : array){
            System.out.println(i);
        }

    }
}
