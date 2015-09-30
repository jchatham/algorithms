package com.khaannn.sorting;

import java.io.PrintWriter;

/**
 * Created by jeff on 9/22/15.
 * TODO: Fix this
 */
public class TestExp2 {

    private final String nameOfTheFile;

    public String getNameOfTheFile() {
        return nameOfTheFile;
    }

    public TestExp2(int k, int n){
        nameOfTheFile = "exp2n" + n + "k" + k;
        StringBuilder sb = new StringBuilder();
        String[] tmp = new String[k + 1];
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(nameOfTheFile, "UTF-8");
            for(int i = k; i >= 1; i--){
                tmp[i] = (i + " Jeff" + Integer.toString(i) + "\n");
                //sb.append(i + " Jeff" + Integer.toString(i) + "\n");
            }
            //String output = sb.toString();
            for(int j = 1; j <= n; j+=k){
                //writer.write(output);
                writer.write(tmp[j]);
            }
        } catch (Exception e) {
            System.out.println("Writing file failed because of " + e.toString());
        } finally {
           writer.close();
        }


    }

    public static void main(String[] args){
        CountingSort countingSort = new CountingSort();
        InsertionSort insertionSort = new InsertionSort();
        JeffSort jeffSort = new JeffSort();
        PairData[] output;
        TestExp2[] te = new TestExp2[6];
        final int SIZE_OF_N = 10000000;
        te[0] = new TestExp2(2, SIZE_OF_N);
        te[1] = new TestExp2(5, SIZE_OF_N);
        te[2] = new TestExp2(10, SIZE_OF_N);
        te[3] = new TestExp2(200, SIZE_OF_N);
        te[4] = new TestExp2(500, SIZE_OF_N);
        te[5] = new TestExp2(1000, SIZE_OF_N);

        PairData[] input;

        System.out.println("File Name|Counting Sort|Merge Sort | Insertion Sort | JeffSort" );

        for(int i = 0; i <= 5; i++){
            input = ReadFromTextFile.test(te[i].getNameOfTheFile());


            long startTime1 = System.currentTimeMillis();
            //insertionSort.sort(input);
            long endTime1 = System.currentTimeMillis();

            long startTime = System.currentTimeMillis();
            countingSort.sort(input);
            long endTime = System.currentTimeMillis();


            long startTime2 = System.currentTimeMillis();
            jeffSort.sort(input);
            long endTime2 = System.currentTimeMillis();


            long startTime0 = System.currentTimeMillis();
            MergeSort mergeSort = new MergeSort();
            mergeSort.sort(input);
            long endTime0 = System.currentTimeMillis();

            System.out.println(te[i].getNameOfTheFile() + " -> " + (endTime - startTime) + " " + (endTime0 - startTime0) + " " + (endTime1 - startTime1) + " " + (endTime2 - startTime2));

        }

    }
}
