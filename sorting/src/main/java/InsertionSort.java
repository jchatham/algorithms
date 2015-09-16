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
        int[] tmpArray = {9,3,5,9,23,589,432,583,59,0,845,-2,853,0,9458,0,534};
        InsertionSort insertionSort = new InsertionSort();
        tmpArray = insertionSort.sort(tmpArray);
        for(int item : tmpArray){
            System.out.print(item + " ");
        }
        System.out.println();
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
        pairData = insertionSort.sort(pairData);
        for(PairData item : pairData){
            System.out.print(item + " ");
        }
    }

}
