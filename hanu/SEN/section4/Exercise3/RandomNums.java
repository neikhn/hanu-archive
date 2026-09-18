package section4.Exercise3;

import java.util.*;

public class RandomNums {
    static List<Integer> list = new ArrayList<>();

    public static void generateNumbers() {
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(100) + 1);
        }

        System.out.print("[");
        for (int number : list) {
            System.out.printf(" %d ", number);
        }
        System.out.print("]");
    }

    public static void main(String[] args) {
        generateNumbers();    
    }
}
