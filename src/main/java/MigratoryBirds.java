import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MigratoryBirds {
    public static int migratoryBirds(List<Integer> arr) {
        Map<Integer, Long> birdFrequency = arr
                .stream()
                .collect(Collectors.groupingBy(bird -> bird, Collectors.counting()));

        return birdFrequency
                .entrySet()
                .stream()
                .min((entry1, entry2) -> {
                    int freqComparison = entry2
                            .getValue()
                            .compareTo(entry1.getValue());
                    if (freqComparison == 0) {
                        return entry1
                                .getKey()
                                .compareTo(entry2.getKey());
                    }
                    return freqComparison;
                })
                .orElseThrow(() -> new IllegalStateException("The list was empty"))
                .getKey();

    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5, 4, 3, 2, 1, 3, 4);
        System.out.println(migratoryBirds(arr));
    }
}
