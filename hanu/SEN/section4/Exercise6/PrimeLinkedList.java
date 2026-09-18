package section4.Exercise6;

import java.util.*;

import section4.Exercise1.First10Primes;

public class PrimeLinkedList extends LinkedList<Integer>{
    public PrimeLinkedList() {
        super();
    }

    public void primeIterator() {
        System.out.print("[");
        for (Integer element : this) {
            if (First10Primes.isPrime(element))
                System.out.printf(" %d ", element);
        }
        System.out.print("]");
    }

}
