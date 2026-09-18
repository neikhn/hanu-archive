package section5; 
import java.util.Scanner;
public class Act1Review {
    public static void main(String[] args) {
        //calling out each functions
        int x; int y = 0;
        x = sumEven(5);
        System.out.println("The sum of all even numbers between 2 and 100: " + x);
        x = sumSquares(y);
        System.out.println("The sum of all squares between 1 and 100: " + x);
        powerTwo(y);
        System.out.println();
        sumOdd();
        sumOddDigits();

    }
    //function calculating sum of all even numbers between 2 and 100
    public static int sumEven(int y) {
        for (int i = 2; i <= 100; i += 2) {
            y += i;
        }
        return y;
    }
    //function calculating sum of all squares between 1 and 100
    public static int sumSquares(int y) {
        for (int i = 1; i <= 100; i ++) {
            y += (i * i);
        }
        return y;
    }
    //function calculating all powers of 2 from 20 up to 220
    public static void powerTwo(double y) {
        System.out.print("All powers of 2 from 20 up to 220: ");
        for (int i = 0; y <= 220; i ++) {
           y = Math.pow(2, i);
           if (y >= 20 && y <= 220) {
               System.out.print("[" + (int) y + "] ");
           }
        }
    }
    //function calculating the sum of all odd numbers between a and b
    public static void sumOdd() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input a: ");
        int a = sc.nextInt();
        System.out.print("Input b: ");
        int b = sc.nextInt();
        sc.close();
        int x = 0;
        System.out.print("Odd number extracted: ");
        for(int i = a; i < b; i ++) {
            if (i % 2 != 0) {
                System.out.print(i + " ");
                x += i;
            }
        }
        System.out.println("\nThe sum of all odd numbers between a and b: " + "[ " + x + " ]");
    }
    //function calculating the sum of all odd digits of an input
    public static void sumOddDigits() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input number: ");
        long input = sc.nextInt();
        sc.close();
        long sum = 0;
        int inputLength = String.valueOf(input).length();
        System.out.print("Odd number(s) extracted: ");
        for (int i = 1; i <= inputLength; i ++) {
            long x = input % 10;
            input /= 10;
            if (x % 2 != 0) {
                System.out.print(x + " ");
                sum += x;
            }
        }
        System.out.println("\nThe sum of all odd digits: " + "[ " + sum + " ]");
    }
}
