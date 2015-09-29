package com.khaannn.sorting;

import java.util.Arrays;

/**
 * Created by chatham_j on 9/29/2015.
 * http://courses.csail.mit.edu/6.006/fall10/handouts/recitation10-8.pdf
 */
public class HeapSort {

    public void sort(Comparable[] a, int p, int r){
        if (p < r){
            int q = partition(a, p, r);
            sort(a, p, q - 1);
            sort(a, q + 1, r);

        }
    }

    public int partition(Comparable[] a, int p, int r){
        Comparable x = a[r];
        int i = p - 1;
        for(int j = p; j < r; j++){
            if (a[j].compareTo(x) <= 0){
                i++;
                exchange(a,i,j);
            }
        }
        exchange(a,i + 1,r);
        return i + 1;
    }


    public void exchange(Object[] a, int i, int j){
        Object tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }


    public void MaxHeapify(Comparable a, int i, int n){

    }

    private int left(Comparable a, int i){
        if(2 * i <= HeapSize(a)){
          return 2 * i + 1;
        } else {
            return -1;
        }
    }


    public static void main(String[] args) {
        Quicksort quicksort = new Quicksort();
        Integer [] input = {34,32094,0,234,2034,95439,985,5348,0,-4};

        final long startTime = System.nanoTime();
        quicksort.sort(input, 0, input.length - 1);
        final long endTime = System.nanoTime();


        for (int item : input) {
            System.out.print(item + "\n");
        }


        try {
            if (args[1].equalsIgnoreCase("test")) {
                System.out.println("Elapsed time in Nanoseconds is " + (endTime - startTime));
                Integer[] input2 = {34,32094,0,234,2034,95439,985,5348,0,-4};
                Quicksort.test(input2, input);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            //ignore(normal case)
        }

    }

    public static void test(Integer[] input, Integer[] sorted) {
        Arrays.sort(input);
        System.out.println(input.length + " " + sorted.length);
        assert (Arrays.equals(input, sorted));
    }
}
