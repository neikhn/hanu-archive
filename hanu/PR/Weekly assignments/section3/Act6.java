package section3;
import java.util.Scanner;
public class Act6 {
    public static void main(String[] args) {
        Scanner act6 = new Scanner(System.in);
        System.out.println("Type in random words: ");
        String word = act6.nextLine();
        act6.close();
        int amountOfWord = word.length();
        int divided = amountOfWord / 2;
        if (amountOfWord % 2 == 0) {
            String firstHalf = word.substring(0, divided);
            String secondHalf = word.substring(divided, amountOfWord);
            System.out.println("\"" + word + "\" " + "-> first half: " + firstHalf + ", second: " + secondHalf);
            if (firstHalf.equals(secondHalf)) {
                System.out.println("First and second half SAME.");
            } else {
                System.out.println("First and second half DIFFERENT.");
            }
        } else {
            String firstHalf = word.substring(0, divided);
            String secondHalf = word.substring(++ divided, amountOfWord);
            System.out.println("\"" + word + "\" " + "-> first half: " + firstHalf + ", second: " + secondHalf);
            if (firstHalf.equals(secondHalf)) {
                System.out.println("First and second half SAME.");
            } else {
                System.out.println("First and second half DIFFERENT.");
            }
        }
    }
}
