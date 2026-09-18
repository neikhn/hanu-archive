package section4.Exercise4;

import java.util.*;

public class OddAlphabet {

    public static void populateCharaterCodes(List<Integer> l1) {
        for (int i = 65; i <= 122; i++) {
            if (i <= 90 || i >= 97) l1.add(i);
        }
    }

    public static void iterateOddCharacter(List<Integer> l1, List<Integer> l2) {
        for (int charaterCode : l1) {
            if (charaterCode % 2 != 0) {
                l2.add(charaterCode);
            }
        }
    }

    public static void printBoard(List<Integer> list) {
        System.out.println("+------------+-----------+");
        System.out.println("| ASCII Code | Character |");
        System.out.println("+------------+-----------+");

        for (int characterCode : list) {
            System.out.printf("| %-10d | %-9c |%n", characterCode, (char) characterCode);
        }

        System.out.println("+------------+-----------+");
    }

    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();

        populateCharaterCodes(l1);
        iterateOddCharacter(l1, l2);

        System.out.println("ASCII English alphabet:");
        printBoard(l1);

        System.out.println("\nASCII English alphabet (odd character):");
        printBoard(l2);
    }
}
