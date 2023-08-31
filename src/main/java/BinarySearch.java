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
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        System.out.println(binarySearch(2, a));
    }
}
