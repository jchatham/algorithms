package com.khaannn.divideandconquer;

/**
 * Created by chatham_j on 9/30/2015.
 * A O(nlogn) implementation of the maximal sub-array problem.
 */
public class MaximalSubArray {
    private int startIndex;
    private int endIndex;
    private int sum;
    private boolean maxSubArrayFound = false;
    private int maxLeft;
    private int maxRight;

    public MaximalSubArray max(int[] a){
        maxSubArray(a, 0, a.length - 1);
        return this;
    }

    public int maxSubArray(int[] a, int low, int high) {
        if (low == high) {
            return a[low];
        } else {
            int mid = (low + high) / 2;

            int sumLeftSide = maxSubArray(a,low,mid);
            int sumRightSide = maxSubArray(a, mid + 1, high);
            int sumCross = maxCrossSubArray(a, low, mid, high);

            if(sumLeftSide >= sumRightSide){
                sum = sumLeftSide;
                startIndex = low;
                endIndex = high;
            } else {
                sum = sumRightSide;
                startIndex = mid + 1;
                endIndex = high;
            }

            if(sumCross >= sum){
                sum = sumCross;
                startIndex = maxLeft;
                endIndex = maxRight;
            }

            return sum;
        }
    }

    public int maxCrossSubArray(int[] a, int low, int mid, int high) {
        int leftSum = Integer.MIN_VALUE;
        int rightSum = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = mid; i >= low; i--) {
            sum += a[i];
            if (sum > leftSum) {
                leftSum = sum;
                maxLeft = i;
            }
        }

        sum = 0;
        for (int j = mid + 1; j <= high; j++) {
            sum += a[j];
            if (sum > rightSum) {
                rightSum = sum;
                maxRight = j;
            }
        }

        return leftSum + rightSum;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getSum() {
        return sum;
    }


    public int getEndIndex() {
        return endIndex;

    }

    public static void main(String[] args) {
        int[] array = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        MaximalSubArray maximalSubArray = new MaximalSubArray();
        //int result = maximalSubArray.maxSubArray(array, 0, array.length - 1);
        int result = maximalSubArray.max(array).getSum();
        System.out.println(result + " start= " + maximalSubArray.getStartIndex()
                + " end= " + maximalSubArray.getEndIndex());

    }

}
