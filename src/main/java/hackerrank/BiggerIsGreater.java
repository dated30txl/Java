package hackerrank;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BiggerIsGreater {

    public static String biggerIsGreater(String w) {
        return Stream.of(w.chars()
                        .mapToObj(ch -> (char) ch)//List<Character>
                        .collect(Collectors.toList()))//Stream<List<Character>>
                .flatMap(chars -> {
//1. Знаходимо символ i у рядку (рахуючи з права наліво), який менший за наступний символ.
                    Optional<Integer> optI = IntStream.rangeClosed(0, chars.size() - 2)//IntStream
                            .boxed()//Stream<Integer>
                            .sorted(Collections.reverseOrder())//зворотний лексикографічний порядок
                            .filter(idx -> chars.get(idx) < chars.get(idx + 1))
                            .findFirst();

                    if (optI.isEmpty()) return Stream.of("no answer");
                    int i = optI.get();
//2. Знаходимо символ j справа від символу i, який є найменшим із символів, більших за символ i.
                    int j = IntStream.range(i + 1, chars.size())
                            .filter(idx -> chars.get(idx) > chars.get(i))
                            .max()//OptionalInt
                            .orElseThrow();
//3. Swap
                    char temp = chars.get(i);
                    chars.set(i, chars.get(j));
                    chars.set(j, temp);

                    Collections.reverse(chars.subList(i + 1, chars.size()));

                    return chars.stream().map(String::valueOf);
                })
                .collect(Collectors.joining());
    }
//Другий спосіб
    private static void reverse(char[] chars, int start) {
        int end = chars.length - 1;
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }

    public static String biggerIsGreater0(String w) {
        char[] chars = w.toCharArray();

        int i = chars.length - 2;
        while (i >= 0 && chars[i] >= chars[i + 1]) i--;

        if (i == -1) return "no answer";

        int j = chars.length - 1;
        while (chars[j] <= chars[i]) j--;
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;

        reverse(chars, i + 1);

        return new String(chars);

    }


    public static void main(String[] args) {
        List<String> w = Arrays.asList("ab", "bb", "hefg", "dhck", "dkhc");

        w.forEach(cr -> System.out.println(biggerIsGreater(cr)));

        System.out.println();

        w.forEach(cr -> System.out.println(biggerIsGreater0(cr)));
    }
}
