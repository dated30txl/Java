import java.util.Arrays;

public class MergeSort {
    public static int[] mergeSort(int[] array) {
        return mergeSort(array, 0, array.length - 1);
    }

    private static int[] mergeSort(int[] array, int l, int r) {
        if (l >= r) {
            return new int[]{array[l]};
        }

        int m = l + r >>> 1; // int m = l + (r - l) / 2;

        int[] left = mergeSort(array, l, m);
        int[] right = mergeSort(array, m + 1, r);

        return merge(left, right);
    }

    static int[] merge(int[] xs, int[] ys) {
        int[] zs = new int[xs.length + ys.length];
        int i = 0; // xs
        int j = 0; // ys
        int k = 0; // zs
        while (i < xs.length && j < ys.length) {
            zs[k++] = xs[i] < ys[j] ? xs[i++] : ys[j++];
        }
        while (i < xs.length) {
            zs[k++] = xs[i++];
        }
        while (j < ys.length) {
            zs[k++] = ys[j++];
        }
        return zs;
    }

    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10};
        int[] sortedArray = mergeSort(array);
            System.out.print(Arrays.toString(sortedArray));

    }
}
