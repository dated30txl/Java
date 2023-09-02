public class KaprekarNumbers {
    public static void kaprekarNumbers(int p, int q) {
        boolean foundKaprekar = false;

        for (long i = p; i <= q; i++) {
            long squared = i * i;
            String str = String.valueOf(squared);
            String left = str.substring(0, str.length() / 2);
            String right = str.substring(str.length() / 2);

            long lNum = (left.isEmpty()) ? 0 : Long.parseLong(left);
            long rNum = (right.isEmpty()) ? 0 : Long.parseLong(right);

            if (lNum + rNum == i) {
                System.out.print(i + " ");
                foundKaprekar = true;
            }
        }

        if (!foundKaprekar) {
            System.out.println("INVALID RANGE");
        }

    }

    public static void main(String[] args) {
        kaprekarNumbers(1, 100);
    }
}
