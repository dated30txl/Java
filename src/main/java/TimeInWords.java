import java.util.Random;

public class TimeInWords {
    public static String timeInWords(int h, int m) {
        String[] numbersToWords = {
                "zero", "one", "two", "three", "four",
                "five", "six", "seven", "eight", "nine",
                "ten", "eleven", "twelve", "thirteen", "fourteen",
                "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
        };

        String[] tensToWords = {
                "twenty", "thirty", "forty", "fifty"
        };

        String timeString;

        switch (m) {
            case 0 -> timeString = numbersToWords[h] + " o' clock";
            case 1 -> timeString = "one minute past " + numbersToWords[h];
            case 15 -> timeString = "quarter past " + numbersToWords[h];
            case 30 -> timeString = "half past " + numbersToWords[h];
            case 45 -> timeString = "quarter to " + numbersToWords[h + 1];
            case 59 -> timeString = "one minute to " + numbersToWords[h + 1];
            default -> {
                if (m <= 30) {
                    if (m <= 20) {
                        timeString = numbersToWords[m] + " minutes past " + numbersToWords[h];
                    } else {
                        timeString = tensToWords[m / 10 - 2] + " " + numbersToWords[m % 10] + " minutes past " + numbersToWords[h];
                    }
                } else {
                    int remainingMinutes = 60 - m;
                    if (remainingMinutes <= 20) {
                        timeString = numbersToWords[remainingMinutes] + " minutes to " + numbersToWords[h + 1];
                    } else {
                        timeString = tensToWords[remainingMinutes / 10 - 2] + " " + numbersToWords[remainingMinutes % 10] + " minutes to " + numbersToWords[h + 1];
                    }
                }
            }
        }

        return timeString;
    }
    public static void main(String[] args) {
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            int h = random.nextInt(12) + 1; // Random hour from 1 to 12
            int m = random.nextInt(60);     // Random minute from 0 to 59

            System.out.println("Input: " + h + ":" + m);
            System.out.println("Output: " + timeInWords(h, m));
            System.out.println();
        }
    }
}
