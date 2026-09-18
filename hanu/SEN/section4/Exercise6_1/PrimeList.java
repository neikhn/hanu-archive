package section4.Exercise6_1;

import java.util.*;

public class PrimeList implements Iterable<Integer>{
    private List<Integer> primes = new ArrayList<>();

    public static boolean isPrime(Integer number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    private void add(int number) {
        if (isPrime(number)) {
            primes.add(number);
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return primes.iterator();
    }

    public static void main(String[] args) {
        PrimeList primes = new PrimeList();

        for (int i = 1; i <= 20; i++) {
            primes.add(i);
        }

        System.out.print("[");
        for (int element : primes) {
            System.out.printf(" %d ", element);
        }
        System.out.print("]");
    }
}
