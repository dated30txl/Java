import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PickingNumbers {
    public static int pickingNumbers1(List<Integer> a) {
        int maxCount = 0;

        Collections.sort(a);

        for (int i = 0; i < a.size(); i++) {
            int count = 1;

            for (int j = i + 1; j < a.size(); j++) {
                if (Math.abs(a.get(j) - a.get(i)) <= 1) {
                    count++;
                }
            }

            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }

    public static int pickingNumbers2(List<Integer> a) {
        int maxCount = 0;

        int[] frequency = new int[101];  // 0 <= a[i] <= 100

        for (int num : a) {
            frequency[num]++;
        }

        for (int i = 1; i <= 100; i++) {
            maxCount = Math.max(maxCount, frequency[i] + frequency[i - 1]);
        }

        return maxCount;
    }

    public static void main(String[] args) {
        List<Integer> a1 = Arrays.asList(4, 6, 5, 3, 3, 1);
        System.out.println(pickingNumbers1(a1)); // 3
        System.out.println(pickingNumbers2(a1)); // 3

        List<Integer> a2 = Arrays.asList(1, 2, 2, 3, 1, 2);
        System.out.println(pickingNumbers1(a2)); // 5
        System.out.println(pickingNumbers2(a2)); // 5
    }
}
