package algorithms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class HashList<T> {

    public HashList() {}

    public HashList(Collection<T> collection) {
        for (T item : collection) {
            add(item);
        }
    }
    private final ArrayList<T> list = new ArrayList<>();
    private final HashSet<T> set = new HashSet<>();

    public boolean add(T value) {
        if (set.add(value)) {
            list.add(value);
            return true;
        }
        return false;
    }

    public boolean contains(T value) {
        return set.contains(value);
    }

    public boolean remove(T value) {
        if (set.remove(value)) {
            list.remove(value);
            return true;
        }
        return false;
    }

    public T get(int index) {
        return list.get(index);
    }

    public int size() {
        return list.size();
    }

    public void print() {
        for (T item : list) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        HashList<Integer> hashList = new HashList<>();
        hashList.add(1);
        hashList.add(2);
        hashList.add(3);
        hashList.print();  // 1 2 3

        System.out.println(hashList.contains(2)); // true
        System.out.println(hashList.contains(4)); // false

        hashList.remove(2);
        hashList.print();  // 1 3
    }
}
