import java.util.Arrays;
import java.util.Random;

public class BinarySearch {
    public static int binarySearch(int key, int[] a){
        // массив a должен быть отсортированным
        int l = 0;                   // l, r — левая и правая границы
        int r = a.length - 1;
        while (l <= r){
            int m = l + r >>> 1; //m — середина области поиска
            int mV = a[m];
            if (key < mV) r = m - 1;
            else if (key > mV) l = m + 1;
            else  return m; //Сужение области поиска
        }
       return -1; //элемент не найден
    }

    public static void main(String[] args) {
        int[] a = new Random().ints(30, 1, 14).toArray();
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        System.out.println(binarySearch(2, a));
    }
}
