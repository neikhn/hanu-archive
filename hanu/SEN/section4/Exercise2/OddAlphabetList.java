package section4.Exercise2;

import java.util.*;

public class OddAlphabetList {
    static List<Character> list = new ArrayList<>();

    public static void populateList() {
        // odd-numbered characters from ASCII 65 ('A') to 122 ('z')
        for (int i = 65; i <= 122; i += 2) {
            list.add((char) i);
        }
    }

    public static void printAlphabetBoard() {
        System.out.println("+------------+-----------+");
        System.out.println("| ASCII Code | Character |");
        System.out.println("+------------+-----------+");

        for (char c : list) {
            System.out.printf("| %-10d | %-9c |%n", ((int) c), c);
        }

        System.out.println("+------------+-----------+");
    }
    
    public static void main(String[] args) {
        populateList();
        printAlphabetBoard();
    }
}