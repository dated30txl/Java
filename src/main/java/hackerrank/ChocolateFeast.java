package hackerrank;

public class ChocolateFeast {
    public static int chocolateFeast(int n, int c, int m) {
        int chocolates = n / c;
        int wrappers = chocolates;

        while (wrappers >= m) {
            int additionalChocolates = wrappers / m;
            chocolates += additionalChocolates;
            wrappers = additionalChocolates + (wrappers % m);
        }

        return chocolates;

    }
    public static void main(String[] args) {
        int t = 3;
        int[] money = {10, 12, 6};
        int[] cost = {2, 4, 2};
        int[] wrappers = {5, 4, 2};

        for (int i = 0; i < t; i++) {
            int result = chocolateFeast(money[i], cost[i], wrappers[i]);
            System.out.println(result);
        }
    }
}
