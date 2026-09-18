package section4;
import java.util.Scanner;
public class Act9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the amount of Fibonacci's number(s) you want to calculate: ");
        int input = sc.nextInt();
        sc.close();
        int first = 0, second = 1, third;
        System.out.println("First " + input + " Fibonacci' numbers: ");
        for (int i = 1; i <= input; i ++) {
            third = first + second;
            first = second;
            second = third;
            System.out.print("[" + third + "] ");
        }
    }
}
