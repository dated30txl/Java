import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.BiFunction;

//В методі main реалізован Benchmark для contains для різних структур
public class BeautifulTriplets {

    static double SEC = 1_000_000_000.0;
    public static int beautifulTriplets1(int d, List<Integer> arr) {
        // contains викликається на об'єкті типу List,
        // і ця операція вимагає лінійного часу для перевірки наявності елемента,
        // так як у худшему випадку доведеться перевірити кожен елемент списку.
        // Пошук додавання/видалення O(n) ( O(1) якщо в кінець списку)
        return (int) arr.stream()
                .filter(num -> arr.contains(num + d) && arr.contains(num + 2 * d))
                .count();
    }

    public static int beautifulTriplets2(int d, List<Integer> arr) {
        // contains викликається на об'єкті типу HashSet
        // хеш-таблиця дає прирост швидкості
        // Пошук додавання/видалення O(1)
        Set<Integer> set = new HashSet<>(arr);
        return (int) arr.stream()
                .filter(num -> set.contains(num + d) && set.contains(num + 2 * d))
                .count();
    }

    public static int beautifulTriplets3(int d, List<Integer> arr) {
        TreeSet<Integer> treeSet = new TreeSet<>(arr);
        // contains викликається на об'єкті типу TreeSet
        // хеш-таблиця дає прирост швидкості приблизно
        // Пошук додавання/видалення O(log n) варто використовувати якщо важливе сортування
        return (int) arr.stream()
                .filter(num -> treeSet.contains(num + d) && treeSet.contains(num + 2 * d))
                .count();
    }

    public static int beautifulTriplets4(int d, List<Integer> arr) {
        //кастомна структура HashSet + ArrayList
        HashList<Integer> treeSet = new HashList<>(arr);
        return (int) arr.stream()
                .filter(num -> treeSet.contains(num + d) && treeSet.contains(num + 2 * d))
                .count();
    }

    public static void main(String[] args) {
        Random random = ThreadLocalRandom.current();

        List<Integer> dataSizes = Arrays.asList(1000, 10000, 100000);

        int d = 1;


        BiFunction<Integer, List<Integer>, Integer>[] functions = new BiFunction[]{
                new BiFunction<Integer, List<Integer>, Integer>() {
                    @Override
                    public Integer apply(Integer d, List<Integer> arr) {
                        return BeautifulTriplets.beautifulTriplets1(d, arr);
                    }

                    @Override
                    public String toString() {
                        return "List";
                    }
                },
                new BiFunction<Integer, List<Integer>, Integer>() {
                    @Override
                    public Integer apply(Integer d, List<Integer> arr) {
                        return BeautifulTriplets.beautifulTriplets2(d, arr);
                    }

                    @Override
                    public String toString() {
                        return "HashSet";
                    }
                },
                new BiFunction<Integer, List<Integer>, Integer>() {
                    @Override
                    public Integer apply(Integer d, List<Integer> arr) {
                        return BeautifulTriplets.beautifulTriplets3(d, arr);
                    }

                    @Override
                    public String toString() {
                        return "TreeSet";
                    }
                },
                new BiFunction<Integer, List<Integer>, Integer>() {
                    @Override
                    public Integer apply(Integer d, List<Integer> arr) {
                        return BeautifulTriplets.beautifulTriplets4(d, arr);
                    }

                    @Override
                    public String toString() {
                        return "HashList";
                    }
                }
        };

        for (int dataSize : dataSizes) {
            List<Integer> arr = generateRandomArray(dataSize, random);

            System.out.printf("Data Size: %d\n", dataSize);

            double[] totalDurations = new double[functions.length];

            for (int i = 0; i < functions.length; i++) {
                BiFunction<Integer, List<Integer>, Integer> function = functions[i];
                double duration = measureExecutionTime(() -> function.apply(d, arr));
                totalDurations[i] += duration;
                System.out.printf("%-10s: %.7f sec\n", function, duration);
            }

            System.out.println();

            for (int i = 0; i < functions.length; i++) {
                System.out.printf("%-10s: %.7f sec (average)\n", functions[i], totalDurations[i] / dataSizes.size());
            }

            System.out.println();
        }
    }

    public static List<Integer> generateRandomArray(int size, Random random) {
        List<Integer> arr = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            arr.add(random.nextInt());
        }
        return arr;
    }

    public static double measureExecutionTime(Runnable runnable) {
        long startTime = System.nanoTime();
        runnable.run();
        return (System.nanoTime() - startTime) / SEC;
    }
}
