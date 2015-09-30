package com.khaannn.divideandconquer;

import com.khaannn.sorting.MergeSort;


/**
 * Created by chatham_j on 9/30/2015.
 */
public class InversionCount extends MergeSort {
    private int[] array;
    public InversionCount( int[] array){
        this.array = array;
    }
    public InversionCount countAndSort (){
        sort(array);
        return this;
    }

    public static void main(String args[]){
        int array[] = {1, 20, 6, 4, 5};
        InversionCount inversionCount = new InversionCount(array);
        int inversions = inversionCount.countAndSort().getNumberOfInversions();
        System.out.println("Number of inversions= " + inversions);
    }
}
