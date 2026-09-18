package section4;
import java.util.Scanner;

public class Act8 {
    //StringBuffer or StringBuilder not allowed.
    public static void main(String[] args) {
        System.out.print("Enter a string: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();
        System.out.print("Reversed string: ");
        for (int i = 1; i <= input.length(); i++) {
            System.out.print(input.substring((input.length() - i), (input.length() - i + 1)));
        }
    }
}
