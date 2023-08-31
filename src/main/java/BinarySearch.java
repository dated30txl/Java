import java.util.Arrays;
import java.util.Random;

public class BinarySearch {
    public static int binarySearch(int key, int[] a){
        // масив a має бути відсортованим
        int l = 0;                   // l, r — ліва та права межі
        int r = a.length - 1;
        while (l <= r){
            int m = l + r >>> 1; //m — середина області пошуку
            int mV = a[m];
            if (key < mV) r = m - 1;
            else if (key > mV) l = m + 1;
            else  return m; //Звуження області пошуку
        }
       return -1; //елемент не знайдено
    }

    public static void main(String[] args) {
        int[] a = new Random().ints(30, 1, 14).toArray();

        // Вимірювання часу для Arrays.sort
        long startTimeArraysSort = System.nanoTime();
        Arrays.sort(a);
        System.out.printf("Arrays.sort took: %.6f seconds\n"
                , (System.nanoTime() - startTimeArraysSort) / 1_000_000_000.0);

        System.out.println(Arrays.toString(a));
        System.out.println(binarySearch(2, a));

        int[] b = new Random().ints(30, 1, 14).toArray();

        // Вимірювання часу для mergeSort
        long startTimeMergeSort = System.nanoTime();
        int[] c = MergeSort.mergeSort(b);
        System.out.printf("MergeSort took: %.6f seconds\n"
                , (System.nanoTime() - startTimeMergeSort) / 1_000_000_000.0);

        System.out.println(Arrays.toString(c));
        System.out.println(binarySearch(2, c));

    }

}
