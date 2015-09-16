/**
 * Created by jeff on 9/15/15.
 */
public class MergeSort implements PairDataSorting {
    private int[] inputArray;
    public PairData[] sort(PairData[] a) {
        MergeSortHelper(a);
        return a;
    }

    public int[] sort(int[] a) {
        this.inputArray = a;
        MergeSortHelper();
        return inputArray;
    }

    private void MergeSortHelper() {
        MergeSortAlg(0, inputArray.length -1);
    }

    private void MergeSortAlg(int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            MergeSortAlg(low, mid);
            MergeSortAlg(mid + 1, high);
            merge(low, mid, high);
        }

    }


    private void MergeSortHelper(PairData[] a) {
        MergeSortAlg(a, 0, a.length - 1);
    }

    private void MergeSortAlg(PairData[] a, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            MergeSortAlg(a, low, mid);
            MergeSortAlg(a, mid + 1, high);
            merge(a, low, mid, high);
        }
    }

    public void merge(int low, int mid, int high) {
        if(low == mid){
            return;
        }
        int sizeOfPt1 = mid - low + 1;
        int sizeOfPt2 = high - mid;
        int[] pt1 = new int[sizeOfPt1];
        int[] pt2 = new int[sizeOfPt2];

        for (int i = 0; i < sizeOfPt1; i++) {
            pt1[i] = inputArray[i + low];
        }
        for (int j = 0; j < sizeOfPt2; j++) {
            pt2[j] = inputArray[j + mid + 1];
        }
        int i = 0, j = 0, k = 0;


        while (i < sizeOfPt1 && j < sizeOfPt2) {
            if (pt1[i] <= pt2[j]) {
                inputArray[k] = pt1[i];
                i++;
            } else {
                inputArray[k] = pt2[j];
                j++;
            }
            k++;
        }
        while (i < sizeOfPt1) {
            inputArray[k] = pt1[i];
            i++;
            k++;
        }
        while (j < sizeOfPt2) {
            inputArray[k] = pt2[j];
            j++;
            k++;
        }
    }

    public void merge(PairData[] a, int low, int mid, int high) {
        PairData[] tmp = new PairData[mid - 1];
        for (int i = 0; i <= mid; i++) {
            tmp[i] = a[i];
        }
        int i = 0, j = mid, k = 0;
        while (i <= mid && j <= a.length) {
            a[k++] = (a[j].getNum() < tmp[i].getNum()) ? a[j++] : tmp[i++];
        }
        while (i <= mid) {
            a[k++] = tmp[i++];
        }


    }

    public static void main(String[] args) {
        int[] tmpArray = {9, 3, 5, 9, 23, 589, 432, 583, 59, 0, 845, -2, 853, 0, 9458, 0, 534};
        PairDataSorting mergeSort = new MergeSort();
        tmpArray = mergeSort.sort(tmpArray);
        for (int item : tmpArray) {
            System.out.print(item + " ");
        }
        System.out.println();
        PairData[] pairData = new PairData[10];
        pairData[0] = new PairData(-5, "jeff");
        pairData[1] = new PairData(45464, "nibbles");
        pairData[2] = new PairData(19, "john");
        pairData[3] = new PairData(43, "kristen");
        pairData[4] = new PairData(5, "kelli");
        pairData[5] = new PairData(0, "alan");
        pairData[6] = new PairData(-65, "jimmy");
        pairData[7] = new PairData(-43, "champion");
        pairData[8] = new PairData(325235, "sasha");
        pairData[9] = new PairData(234523443, "robin");
        pairData = mergeSort.sort(pairData);
        for (PairData item : pairData) {
            System.out.print(item + " ");
        }
    }
}
