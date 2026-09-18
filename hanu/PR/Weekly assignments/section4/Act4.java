package section4;
import java.util.Scanner;
public class Act4 {
    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
        System.out.print("Input a number to see whether it is a palindrome number or not: ");
        int input = user.nextInt();
        int a; int b = 0; int temp = 0; int temporaryTemp = input;
        while (input > 0) {
            a = input % 10;
            b = b * 10 + a;
            input = input / 10;
            temp = temp * 10 + a;
        }
        System.out.println(temp);
        if (temporaryTemp == temp) {
            System.out.println("The number is a palindrome");
        } else {
            System.out.println("The number is not a palindrome");
        }
        user.close();
    }
}
