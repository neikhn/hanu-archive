package section4.Exercise1;

import java.util.*;

public class First10Primes {
    List<Integer> list = new ArrayList<Integer>();
        

    public static List<Integer> PrimeGenerator(int count) {
        List<Integer> primeList = new ArrayList<Integer>();

        int temp = 2;
        while (primeList.size() < count) {
            if (isPrime(temp)) {
                primeList.add(temp);
            }
            temp++;
        }
        return primeList;
    }

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

    public static void printPrimeBoard(List<Integer> primes) {
        System.out.println("+-----+-------+");
        System.out.println("|  #  | Prime |");
        System.out.println("+-----+-------+");

        for (int i = 0; i < primes.size(); i++) {
            System.out.printf("| %-3d | %-5d |%n", i + 1, primes.get(i));
        }

        System.out.println("+-----+-------+");
    }

    public static void main(String[] args) {
        List<Integer> list = PrimeGenerator(10);
        printPrimeBoard(list);
    }
}
