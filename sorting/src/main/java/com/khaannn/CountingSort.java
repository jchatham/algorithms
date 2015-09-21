package com.khaannn;

import java.util.HashMap;

/**
 * Created by chatham_j on 9/16/2015.
 */
public class CountingSort implements PairDataSorting{


    public int[] sort(int[] a) {
        //finds min and max values
        int maxVal = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;
        for (int i : a) {
            if (i >= maxVal) {
                maxVal = i;
            }
            if (i <= minVal) {
                minVal = i;
            }
        }
        //initializes array to range between min and max
        int[] count = new int[maxVal - minVal + 1];
        //walks through array a and assigns values to count offset by min value;
        for(int i = 0; i < a.length; i++){
            count[a[i] - minVal]++;
        }
        //produces the output array in sorted order
        for (int i = minVal, k = 0; i <= maxVal; i++){
            while(count[i - minVal] > 0){
                a[k] = i;
                count[i - minVal]--;
                k++;
            }
        }

        return a;
    }
    public PairData[] sort(PairData[] a){
        //finds min and max values
        int maxVal = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;
        for (PairData i : a) {
            if (i.getNum() >= maxVal) {
                maxVal = i.getNum();
            }
            if (i.getNum() <= minVal) {
                minVal = i.getNum();
            }
        }

        return countingSortHelper(a, minVal, maxVal);
    }

    protected PairData[] countingSortHelper(PairData[] a, int minVal, int maxVal){

        //initializes array to range between min and max
        int[] count = new int[maxVal - minVal + 1];
        //walks through array a and assigns values to count offset by min value;
        for(int i = 0; i < a.length; i++){
            count[a[i].getNum() - minVal]++;
        }
        int total = 0, tmp;
        for(int i = 0; i < a.length; i++){
            tmp = count[i];
            count[i] = total;
            total += tmp;
        }
        //produces the output array in sorted order
        for (int i = minVal, k = 0; i <= maxVal; i++){
            while(count[i - minVal] > 0){
                a[k].setNum(i);
                count[i - minVal]--;
                k++;
            }
        }
        return a;

    }


    public static void main(String[] args) {
        PairData[] input = ReadFromTextFile.test(args[0]);
        CountingSort countingSort = new CountingSort();
        input = countingSort.sort(input);
        for (PairData item : input) {
            System.out.print(item + "\n");
        }
    }
}