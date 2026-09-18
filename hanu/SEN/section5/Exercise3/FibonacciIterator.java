package section5.Exercise3;

import java.util.*;

public class FibonacciIterator implements Iterator<Integer> {
    private int n;
    private int current = 0;
    private int next = 1;
    private int count = 0;

    public FibonacciIterator(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative");
        }
        this.n = n;
    }

    @Override
    public boolean hasNext() {
        return count < n;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int result = current;
        int temp = current;
        current = next;
        next = temp + next;
        count++;
        return result;
    }

    public static void main(String[] args) {
        test(1);
        test(2);
        test(3);
        test(4);
        test(5);
    }

    private static void test(int length) {
        FibonacciIterator iterator = new FibonacciIterator(length);
        List<Integer> sequence = new ArrayList<>();

        while (iterator.hasNext()) {
            sequence.add(iterator.next());
        }

        System.out.println(length + " -> " + sequence);
    }
}
